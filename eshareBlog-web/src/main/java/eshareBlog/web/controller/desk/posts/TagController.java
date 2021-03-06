/**
 *
 */
package eshareBlog.web.controller.desk.posts;

import eshareBlog.core.data.Post;
import eshareBlog.core.persist.service.PostService;
import eshareBlog.web.controller.BaseController;
import eshareBlog.web.controller.desk.Views;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 标签
 * @author evan
 *
 */
@Controller
public class TagController extends BaseController {
    @Autowired
    private PostService postService;

    @RequestMapping("/tag/{tag}")
    public String tag(@PathVariable String tag, ModelMap model) {
        Pageable pageable = wrapPageable();
        try {
            if (StringUtils.isNotEmpty(tag)) {
                Page<Post> page = postService.searchByTag(pageable, tag);
                model.put("page", page);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.put("tag", tag);
        return getView(Views.TAGS_TAG);
    }

}
