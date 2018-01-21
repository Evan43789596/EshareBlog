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

import eshareBlog.core.persist.entity.OpenOauthPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 第三方开发授权登录
 * @author langhsu on 2015/8/12.
 */
public interface OpenOauthDao extends JpaRepository<OpenOauthPO, Long>, JpaSpecificationExecutor<OpenOauthPO> {
    OpenOauthPO findByAccessToken(String accessToken);

    OpenOauthPO findByOauthUserId(String oauthUserId);
    
    OpenOauthPO findByUserId(long userId);
}
