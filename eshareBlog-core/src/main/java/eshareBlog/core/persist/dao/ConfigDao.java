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

import eshareBlog.core.persist.entity.ConfigPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author evan
 *
 */
public interface ConfigDao extends JpaRepository<ConfigPO, Long>, JpaSpecificationExecutor<ConfigPO> {
	ConfigPO findByKey(String key);
}
