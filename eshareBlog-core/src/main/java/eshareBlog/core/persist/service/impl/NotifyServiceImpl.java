package eshareBlog.core.persist.service.impl;

import eshareBlog.base.lang.Consts;
import eshareBlog.core.data.Notify;
import eshareBlog.core.data.Post;
import eshareBlog.core.data.User;
import eshareBlog.core.persist.dao.NotifyDao;
import eshareBlog.core.persist.entity.NotifyPO;
import eshareBlog.core.persist.service.NotifyService;
import eshareBlog.core.persist.service.PostService;
import eshareBlog.core.persist.service.UserService;
import eshareBlog.core.persist.utils.BeanMapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author evan on 2015/8/31.
 */
@Service
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    private NotifyDao notifyDao;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @Override
    @Transactional(readOnly = true)
    public Page<Notify> findByOwnId(Pageable pageable, long ownId) {
        Page<NotifyPO> page = notifyDao.findAllByOwnIdOrderByIdDesc(pageable, ownId);
        List<Notify> rets = new ArrayList<>();

        Set<Long> postIds = new HashSet<>();
        Set<Long> fromUserIds = new HashSet<>();

        // 筛选
        page.getContent().forEach(po -> {
            Notify no = BeanMapUtils.copy(po);

            rets.add(no);

            if (no.getPostId() > 0) {
                postIds.add(no.getPostId());
            }
            if (no.getFromId() > 0) {
                fromUserIds.add(no.getFromId());
            }

        });

        // 加载
        Map<Long, Post> posts = postService.findSingleMapByIds(postIds);
        Map<Long, User> fromUsers = userService.findMapByIds(fromUserIds);

        rets.forEach(n -> {
            if (n.getPostId() > 0) {
                n.setPost(posts.get(n.getPostId()));
            }
            if (n.getFromId() > 0) {
                n.setFrom(fromUsers.get(n.getFromId()));
            }
        });

        return new PageImpl<>(rets, pageable, page.getTotalElements());
    }

    @Override
    @Transactional
    public void send(Notify notify) {
        if (notify == null || notify.getOwnId() <=0 || notify.getFromId() <= 0) {
            return;
        }

        NotifyPO po = new NotifyPO();
        BeanUtils.copyProperties(notify, po);
        po.setCreated(new Date());

        notifyDao.save(po);
    }

    @Override
    @Transactional(readOnly = true)
    public int unread4Me(long ownId) {
        return notifyDao.countByOwnIdAndStatus(ownId, Consts.UNREAD);
    }

    @Override
    @Transactional
    public void readed4Me(long ownId) {
        notifyDao.updateReadedByOwnId(ownId);
    }
}
