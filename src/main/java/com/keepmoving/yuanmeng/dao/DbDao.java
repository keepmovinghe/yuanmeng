package com.keepmoving.yuanmeng.dao;

import java.util.List;

/**
 * dao接口 定义一些基础方法
 * 
 * @author Administrator
 *
 */
public interface DbDao {

	public Object queryOne(String statement);
	
	public Object queryOne(String statement, Object parameters);
	/**
	 * 无参数查询
	 * 
	 * @param statement
	 *            执行SQL
	 * @return 返回List<Object>类型
	 */
	public List<Object> query(String statement);

	/**
	 * 有参数查询
	 * 
	 * @param statement
	 *            执行SQL
	 * @param parameters
	 *            参数
	 * @return 返回List<Object>
	 */
	public List<Object> query(String statement, Object parameters);

	/**
	 * 无参数插入
	 * 
	 * @param statement
	 *            执行SQL
	 * @return 返回受影响的行数或插入后的ID
	 */
	public Object insert(String statement);

	/**
	 * 有参数插入
	 * 
	 * @param statement
	 *            执行SQL
	 * @param parameters
	 *            参数
	 * @return 返回受影响的行数或插入后的ID
	 */
	public Object insert(String statement, Object parameters);

	/**
	 * 无参数更新数据
	 * 
	 * @param statement
	 *            执行SQL
	 * @return 返回受影响的行数
	 */
	public int update(String statement);

	/**
	 * 有参数更新数据
	 * 
	 * @param statement
	 *            执行SQL
	 * @param parameters
	 *            参数
	 * @return 返回受影响的行数
	 */
	public int update(String statement, Object parameters);

	/**
	 * 无参数删除
	 * 
	 * @param statement
	 *            执行SQL
	 * @return 返回受影响的行数
	 */
	public int delect(String statement);

	/**
	 * 有参数删除
	 * 
	 * @param statement
	 *            执行SQL
	 * @param parameters
	 *            参数
	 * @return 返回受影响的行数
	 */
	public int delect(String statement, Object parameters);
}
