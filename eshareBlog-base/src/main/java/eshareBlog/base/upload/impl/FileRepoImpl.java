/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.base.upload.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * @author langhsu
 *
 */
@Service("fileRepo")
public class FileRepoImpl extends AbstractFileRepo {
	private static String KEY = "absolute";

	@PostConstruct
	public void init() {
		fileRepoFactory.addRepo(KEY, this);
	}

	@Override
	public String getRoot() {
		return appContext.getRoot();
	}

}
