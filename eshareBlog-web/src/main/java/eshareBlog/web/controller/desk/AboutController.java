/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.web.controller.desk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import eshareBlog.web.controller.BaseController;

/**
 * @author langhsu
 *
 */
@Controller
public class AboutController extends BaseController {
	
	@RequestMapping("/about")
	public String about() {
		return getView("/about/about");
	}
	
	@RequestMapping("/joinus")
	public String joinus() {
		return getView("/about/joinus");
	}
	
	@RequestMapping("/faqs")
	public String faqs() {
		return getView("/about/faqs");
	}

}
