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

import java.util.Date;

/**
 * @author evan
 *
 */
public interface LogService {
	void add(int logType, long userId, long targetId, String ip);
}
