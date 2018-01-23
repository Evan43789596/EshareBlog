/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.base.utils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author evan
 *
 */
public class URLUtils {
	
	public static String getHost(String link) {
		URL url;
		String host = "";
		try {
			url = new URL(link);
			host = url.getHost();
		} catch (MalformedURLException e) {
		}
		return host;
	}
}
