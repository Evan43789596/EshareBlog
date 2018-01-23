package eshareBlog.core.persist.dao.custom;

import eshareBlog.core.data.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by evan on 2017/9/30.
 */
public interface PostDaoCustom {
    Page<Post> search(Pageable pageable, String q) throws Exception;
    Page<Post> searchByTag(Pageable pageable, String tag);
    void resetIndexs();
}
