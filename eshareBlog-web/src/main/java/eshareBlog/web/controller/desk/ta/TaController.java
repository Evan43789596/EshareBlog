/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.web.controller.desk.ta;

import eshareBlog.core.data.Post;
import eshareBlog.core.data.User;
import eshareBlog.core.persist.service.PostService;
import eshareBlog.core.persist.service.UserService;
import eshareBlog.web.controller.BaseController;
import eshareBlog.web.controller.desk.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 访问他人主页
 * @author evan
 *
 */
@Controller
public class TaController extends BaseController {
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/ta/{uid}")
	public String home(@PathVariable Long uid, ModelMap model) {
		User user = userService.get(uid);
		Pageable pageable = wrapPageable();
		Page<Post> page = postService.pagingByAuthorId(pageable, uid);
		
		model.put("user", user);
		model.put("page", page);
		return getView(Views.TA_HOME);
	}
}
