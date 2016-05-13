package com.keepmoving.yuanmeng.services.impls;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.keepmoving.yuanmeng.pojo.Blog;
import com.keepmoving.yuanmeng.services.interfaces.BlogService;

@Service(value = "blogService")
public class BlogServiceImpl extends BaseServiceImpl implements BlogService {

	public void addBlog(Blog blog) {
		this.add("blog.addBlog", blog);
	}

	public List<Object> queryBlog() {
		return this.query("blog.selectBlog");
	}

	public int delBlog(int id) {
		return this.delete("blog.deleteBlog", id);
	}

	public int updateTransferSend(int id) {
		return this.update("blog.updateTransferSend", id);
	}

	public int updateClick(int id) {
		return this.update("blog.updateClick", id);
	}

	public List<Object> queryBlogById(int uId) {
		return this.query("blog.queryBlogById", uId);
	}

}
