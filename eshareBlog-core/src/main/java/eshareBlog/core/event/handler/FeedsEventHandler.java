/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.core.event.handler;

import eshareBlog.base.lang.Consts;
import eshareBlog.core.data.Feeds;
import eshareBlog.core.event.FeedsEvent;
import eshareBlog.core.persist.service.FeedsService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * @author evan on 2015/8/18.
 */
@Component
public class FeedsEventHandler implements ApplicationListener<FeedsEvent> {
    private Logger log = Logger.getLogger(getClass());

    @Autowired
    private FeedsService feedsService;

    @Async
    @Override
    public void onApplicationEvent(FeedsEvent event) {
        if (event == null) {
            return;
        }

        // 创建动态对象
        Feeds feeds = new Feeds();
        feeds.setType(Consts.FEEDS_TYPE_POST);
        feeds.setOwnId(event.getAuthorId());
        feeds.setPostId(event.getPostId());
        feeds.setAuthorId(event.getAuthorId());

        int ret = feedsService.add(feeds);

        log.debug(MessageFormat.format("成功派发 {0} 条动态!", ret));
    }
}
