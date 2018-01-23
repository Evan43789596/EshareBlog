/**
 *
 */
package eshareBlog.template.directive;

import eshareBlog.base.lang.Consts;
import eshareBlog.core.data.Post;
import eshareBlog.core.persist.service.PostService;
import eshareBlog.template.DirectiveHandler;
import eshareBlog.template.TemplateDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * 文章内容查询
 *
 * 示例：
 * 	请求：http://eshare.com/index?ord=newest&pn=2
 *  使用：@contents group=x pn=pn ord=ord
 *
 * @author evan
 *
 */
@Component
public class ContentsDirective extends TemplateDirective {
	@Autowired
    private PostService postService;

    @Override
    public String getName() {
        return "contents";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        Integer pn = handler.getInteger("pn", 1);
        Integer group = handler.getInteger("group", 0);
        String order = handler.getString("ord", Consts.order.NEWEST);

        Pageable pageable = new PageRequest(pn - 1, 10);
        Page<Post> result = postService.paging(pageable, group, order, true);

        handler.put(RESULTS, result).render();
    }
}
