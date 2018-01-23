/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.core.persist.dao;

import eshareBlog.core.persist.entity.CommentPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author evan
 *
 */
public interface CommentDao extends JpaRepository<CommentPO, Long>, JpaSpecificationExecutor<CommentPO> {
	Page<CommentPO> findAll(Pageable pageable);
	Page<CommentPO> findAllByToIdOrderByCreatedDesc(Pageable pageable, long toId);
	Page<CommentPO> findAllByAuthorIdOrderByCreatedDesc(Pageable pageable, long authorId);
	List<CommentPO> findByIdIn(Set<Long> ids);
	List<CommentPO> findAllByAuthorIdAndToIdOrderByCreatedDesc(long authorId, long toId);

	int deleteAllByIdIn(Collection<Long> ids);
}
