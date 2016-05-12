package com.keepmoving.yuanmeng.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keepmoving.yuanmeng.pojo.Blog;
import com.keepmoving.yuanmeng.services.interfaces.BlogService;
import com.keepmoving.yuanmeng.utils.JSON2Object;
import com.keepmoving.yuanmeng.utils.Utils;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource(name = "blogService")
	private BlogService blogService;

	/**
	 * 添加微博
	 * 
	 * @param request
	 * @param response
	 * @param uId
	 * @param content
	 */
	@RequestMapping("/addBlog")
	public void addBlog(HttpServletRequest request, HttpServletResponse response, int uId, String content) {
		String status = "\"\"";
		String result = "";

		Blog blog = new Blog();
		blog.setuId(uId);
		blog.setContent(content);
		// 调用保存方法
		blogService.addBlog(blog);
		status = Utils.SUCCESS;

		result = JSON2Object.toJSONString("添加成功");
		// 输出json
		Utils.printWriter(request, response, status, result);
	}

	/**
	 * 查询微博
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryBlog")
	public void queryBlog(HttpServletRequest request, HttpServletResponse response) {
		String status = "\"\"";
		String result = "";

		// 调用保存方法
		List<Object> blogReult = blogService.queryBlog();
		status = Utils.SUCCESS;

		result = JSON2Object.toJSONString(blogReult);
		// 输出json
		Utils.printWriter(request, response, status, result);
	}

	/**
	 * 删除微博
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/delBlog")
	public void delBlog(HttpServletRequest request, HttpServletResponse response, int id) {
		String status = "\"\"";
		String result = "";

		if (Utils.isEmpty(String.valueOf(id))) {
			status = Utils.PARAMETER_NOT_COMPLETE;
			result = JSON2Object.toJSONString("微博编号为空");
		} else {
			// 调用删除方法
			blogService.delBlog(id);
			status = Utils.SUCCESS;
			result = JSON2Object.toJSONString("删除成功");
		}
		// 输出json
		Utils.printWriter(request, response, status, result);
	}

	/**
	 * 更新转发数量
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/updTransferSend")
	public void updTransferSend(HttpServletRequest request, HttpServletResponse response, int id) {
		String status = "\"\"";
		String result = "";

		if (Utils.isEmpty(String.valueOf(id))) {
			status = Utils.PARAMETER_NOT_COMPLETE;
			result = JSON2Object.toJSONString("微博编号为空");
		} else {
			// 调用删除方法
			blogService.updateTransferSend(id);
			status = Utils.SUCCESS;
			result = JSON2Object.toJSONString("更新成功");
		}
		// 输出json
		Utils.printWriter(request, response, status, result);
	}

	/**
	 * 更新点赞数量
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/updClick")
	public void updClick(HttpServletRequest request, HttpServletResponse response, int id) {
		String status = "\"\"";
		String result = "";

		if (Utils.isEmpty(String.valueOf(id))) {
			status = Utils.PARAMETER_NOT_COMPLETE;
			result = JSON2Object.toJSONString("微博编号为空");
		} else {
			// 调用删除方法
			blogService.updateClick(id);
			status = Utils.SUCCESS;
			result = JSON2Object.toJSONString("更新成功");
		}
		// 输出json
		Utils.printWriter(request, response, status, result);
	}
}
