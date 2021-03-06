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

import eshareBlog.core.persist.entity.AttachPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author evan
 *
 */
@Repository
public interface AttachDao extends JpaRepository<AttachPO, Long>, JpaSpecificationExecutor<AttachPO> {
	List<AttachPO> findAllByToId(long toId);
	List<AttachPO> findAllByToIdIn(Set<Long> toIds);
	List<AttachPO> findAllByIdIn(Set<Long> ids);

	@Transactional
	void deleteAllByToId(long toId);
}
