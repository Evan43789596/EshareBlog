/*
+--------------------------------------------------------------------------
|   eshareBlog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 eshare. All Rights Reserved
|   http://www.eshare.com
|
+---------------------------------------------------------------------------
*/
package eshareBlog.core.data;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import eshareBlog.core.persist.entity.CommentPO;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author evan
 * 
 */
public class Comment extends CommentPO implements Serializable {
	private static final long serialVersionUID = 9192186139010913437L;

	// extend parameter
	private User author;
	private Comment parent;
	private Post post;

	@JSONField(format="yyyy-MM-dd")
	public Date getCreated() {
		return super.getCreated();
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
