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

import eshareBlog.core.persist.entity.UserPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * @author evan
 */
public interface UserDao extends JpaRepository<UserPO, Long>, JpaSpecificationExecutor<UserPO> {
    UserPO findByUsername(String username);

    UserPO findByEmail(String email);
    
    List<UserPO> findTop12ByOrderByFansDesc();
    @Query("from UserPO f1 where f1.username is not null)")
    Page<UserPO> findAllByOrderByIdDesc(Pageable pageable);

    List<UserPO> findAllByIdIn(Set<Long> ids);

}
