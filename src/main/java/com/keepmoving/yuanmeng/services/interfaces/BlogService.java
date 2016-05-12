package com.keepmoving.yuanmeng.services.interfaces;

import java.util.List;
import java.util.Map;

import com.keepmoving.yuanmeng.pojo.Blog;

/**
 * 微博service接口
 * @author Administrator
 *
 */
public interface BlogService extends BaseService{

	public void addBlog(Blog blog);
	
	public List<Object> queryBlog();
	
	public int delBlog(int id);
	
	public int updateTransferSend(int id);
	
	public int updateClick(int id);
}
