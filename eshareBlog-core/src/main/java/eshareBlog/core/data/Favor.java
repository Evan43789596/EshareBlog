package eshareBlog.core.data;

import eshareBlog.core.persist.entity.FavorPO;

import java.util.Date;

/**
 * @author evan on 2015/8/31.
 */
public class Favor extends FavorPO {
    // extend
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
