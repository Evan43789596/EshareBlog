/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.core.persist.service;

import eshareBlog.core.data.OpenOauth;
import eshareBlog.core.data.User;

/**
 * @author evan on 2015/8/12.
 */
public interface OpenOauthService {
    //通过 oauth_token 查询 user
    User getUserByOauthToken(String oauth_token);

    OpenOauth getOauthByToken(String oauth_token);
    
    OpenOauth getOauthByOauthUserId(String oauthUserId);

    OpenOauth getOauthByUid(long userId);

    boolean checkIsOriginalPassword(long userId);

    void saveOauthToken(OpenOauth oauth);

}
