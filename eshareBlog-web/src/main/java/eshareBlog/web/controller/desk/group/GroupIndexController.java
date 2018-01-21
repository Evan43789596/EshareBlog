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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import eshareBlog.base.lang.Consts;
import eshareBlog.core.data.Group;
import eshareBlog.core.persist.service.GroupService;
import eshareBlog.web.controller.BaseController;
import eshareBlog.web.controller.desk.Views;

/**
 * Group 主页
 * @author langhsu
 *
 */
@Controller
public class GroupIndexController extends BaseController {
	@Autowired
	private GroupService groupService;
	
	@RequestMapping("/g/{groupKey}")
	public String root(@PathVariable String groupKey, ModelMap model,
			HttpServletRequest request) {
		// init params
		String order = ServletRequestUtils.getStringParameter(request, "ord", Consts.order.NEWEST);
		int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
		Group group = groupService.getByKey(groupKey);
		
		// callback params
		model.put("group", group);
		model.put("ord", order);
		model.put("pn", pn);
		return getView(Views.ROUTE_POST_INDEX);
	}
	
}
