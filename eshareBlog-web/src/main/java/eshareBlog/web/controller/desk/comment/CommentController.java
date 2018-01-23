/**
 * 
 */
package eshareBlog.web.controller.desk.comment;

import eshareBlog.base.data.Data;
import eshareBlog.base.lang.Consts;
import eshareBlog.base.lang.EntityStatus;
import eshareBlog.core.data.AccountProfile;
import eshareBlog.core.data.Comment;
import eshareBlog.core.event.NotifyEvent;
import eshareBlog.core.persist.dao.UserDao;
import eshareBlog.core.persist.entity.UserPO;
import eshareBlog.core.persist.service.CommentService;
import eshareBlog.web.controller.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Calendar;

/**
 * @author evan
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private UserDao userDao;

	@RequestMapping("/list/{toId}")
	public @ResponseBody Page<Comment> view(@PathVariable Long toId) {
		Pageable pageable = wrapPageable();
		Page<Comment> page = commentService.paging(pageable, toId);
		return page;
	}

	/*@RequestMapping("/submit")
	public @ResponseBody
	Data post(Long toId, String text, HttpServletRequest request) {
		Data data = Data.failure("操作失败");

		long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);

		if (!SecurityUtils.getSubject().isAuthenticated()) {
			data = Data.failure("请先登录在进行操作");

			return data;
		}
		if (toId > 0 && StringUtils.isNotEmpty(text)) {
			AccountProfile up = getSubject().getProfile();

			Comment c = new Comment();
			c.setToId(toId);
			c.setContent(HtmlUtils.htmlEscape(text));
			c.setAuthorId(up.getId());

			c.setPid(pid);

			commentService.post(c);

			if(toId != up.getId()) {
				sendNotify(up.getId(), toId, pid);
			}

			data = Data.success("发表成功!", Data.NOOP);
		}
		return data;
	}*/


	@RequestMapping("/submit")
	public @ResponseBody
	Data post(Long toId, String text, HttpServletRequest request) {
		Data data = Data.failure("操作失败");

		long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);

		UserPO user = new UserPO();
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			//对于没有登录或者注册的用户，直接创建一个虚拟账户,让其可以提交评论
			user.setName("来自" + request.getRemoteAddr() + "的网友");
			user.setAvatar(null);
			user.setRoles(null);
			user.setStatus(EntityStatus.DISABLED);
			user.setCreated(Calendar.getInstance().getTime());
			user = userDao.save(user);
		}
		if (toId > 0 && StringUtils.isNotEmpty(text)) {
			AccountProfile up = getSubject().getProfile();
			Comment c = new Comment();
			c.setToId(toId);
			c.setContent(HtmlUtils.htmlEscape(text));
			c.setAuthorId(user.getId());
			c.setPid(pid);

			commentService.post(c);
			//对于验证成功的用户并且不是当前作者自己回复，发送通知
			if (SecurityUtils.getSubject().isAuthenticated()&&toId != up.getId()) {
				sendNotify(up.getId(), toId, pid);
			}

			data = Data.success("发表成功!", Data.NOOP);
		}
		return data;
	}

	@RequestMapping("/delete")
	public @ResponseBody Data delete(Long id) {
		Data data = Data.failure("操作失败");
		if (id != null) {
			AccountProfile up = getSubject().getProfile();
			try {
				commentService.delete(id, up.getId());
				data = Data.success("操作成功", Data.NOOP);
			} catch (Exception e) {
				data = Data.failure(e.getMessage());
			}
		}
		return data;
	}

	/**
	 * 发送通知
	 * @param userId
	 * @param postId
	 */
	private void sendNotify(long userId, long postId, long pid) {
		NotifyEvent event = new NotifyEvent("NotifyEvent");
		event.setFromUserId(userId);

		if (pid > 0) {
			event.setEvent(Consts.NOTIFY_EVENT_COMMENT_REPLY);
		} else {
			event.setEvent(Consts.NOTIFY_EVENT_COMMENT);
		}
		// 此处不知道文章作者, 让通知事件系统补全
		event.setPostId(postId);
		applicationContext.publishEvent(event);
	}
}