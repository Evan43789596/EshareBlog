package eshareBlog.core.data;

import eshareBlog.core.persist.entity.NotifyPO;

/**
 * @author evan on 2015/8/31.
 */
public class Notify extends NotifyPO {
    // extend
    private User from;
    private Post post;

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
