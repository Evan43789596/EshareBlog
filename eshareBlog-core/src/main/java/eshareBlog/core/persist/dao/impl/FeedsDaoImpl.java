/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.core.persist.dao.impl;

import eshareBlog.core.data.Feeds;
import eshareBlog.core.persist.dao.custom.FeedsDaoCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.MessageFormat;

/**
 * @author evan
 *
 */
public class FeedsDaoImpl implements FeedsDaoCustom {
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	String pattern = "INSERT INTO mto_feeds (own_id, type, post_id, author_id, created) SELECT user_id, {0}, {1}, {2}, now() FROM mto_follows WHERE follow_id = {3}";

	@Override
	public int batchAdd(Feeds feeds) {
		String sql = MessageFormat.format(pattern, feeds.getType(), feeds.getPostId(), feeds.getAuthorId(), feeds.getAuthorId());
		return entityManager.createNativeQuery(sql).executeUpdate();
	}

}
