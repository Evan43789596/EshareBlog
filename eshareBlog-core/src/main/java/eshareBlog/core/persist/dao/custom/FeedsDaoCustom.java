package eshareBlog.core.persist.dao.custom;

import eshareBlog.core.data.Feeds;

/**
 * Created by evan on 2017/9/30.
 */
public interface FeedsDaoCustom {
    /**
     * 添加动态, 同时会分发给粉丝
     *
     * @param feeds
     * @return
     */
    int batchAdd(Feeds feeds);
}
