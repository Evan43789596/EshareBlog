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

import eshareBlog.core.persist.dao.custom.PostDaoCustom;
import eshareBlog.core.persist.entity.PostPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

/**
 * @author evan
 *
 */
public interface PostDao extends JpaRepository<PostPO, Long>, JpaSpecificationExecutor<PostPO>, PostDaoCustom {
	/**
	 * 查询指定用户
	 * @param pageable
	 * @param authorId
	 * @return
	 */
	Page<PostPO> findAllByAuthorIdOrderByCreatedDesc(Pageable pageable, long authorId);

	// findLatests
	List<PostPO> findTop12ByOrderByCreatedDesc();

	// findHots
	List<PostPO> findTop12ByOrderByViewsDesc();

	List<PostPO> findAllByIdIn(Collection<Long> id);

	List<PostPO> findTop5ByFeaturedGreaterThanOrderByCreatedDesc(int featured);

	@Query("select coalesce(max(p.featured), 0) from PostPO p")
	int maxFeatured();
	
}
