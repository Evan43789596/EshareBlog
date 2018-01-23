/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.web.controller.desk.group;

import eshareBlog.core.data.Post;
import eshareBlog.core.persist.service.PostService;
import eshareBlog.web.controller.BaseController;
import eshareBlog.web.controller.desk.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章浏览
 * 
 * @author evan
 * 
 */
@Controller
@RequestMapping("/view")
public class GroupViewController extends BaseController {
	@Autowired
	private PostService postService;

	@RequestMapping("/{id}")
	public String view(@PathVariable Long id, ModelMap model) {
		Post ret = postService.get(id);
		
		Assert.notNull(ret, "该文章已被删除");
		
		postService.identityViews(id);
		model.put("ret", ret);
		return getView(Views.ROUTE_POST_VIEW);
	}
}
