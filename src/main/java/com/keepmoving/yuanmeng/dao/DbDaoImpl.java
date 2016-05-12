package com.keepmoving.yuanmeng.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * dao实现类
 * 
 * @author Administrator
 *
 */

@Repository(value = "dbDao")
public class DbDaoImpl extends SqlSessionDaoSupport implements DbDao {

	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public Object queryOne(String statement){
		return this.getSqlSession().selectOne(statement);
	}

	public Object queryOne(String statement, Object parameters){
		return this.getSqlSession().selectOne(statement, parameters);
	}

	public List<Object> query(String statement) {
		return this.getSqlSession().selectList(statement);
	}

	public List<Object> query(String statement, Object parameters) {
		return this.getSqlSession().selectList(statement, parameters);
	}

	public Object insert(String statement) {
		return this.getSqlSession().insert(statement);
	}

	public Object insert(String statement, Object parameters) {
		return this.getSqlSession().insert(statement, parameters);
	}

	public int update(String statement) {
		return this.getSqlSession().update(statement);
	}

	public int update(String statement, Object parameters) {
		return this.getSqlSession().update(statement, parameters);
	}

	public int delect(String statement) {
		return this.getSqlSession().delete(statement);
	}

	public int delect(String statement, Object parameters) {
		return this.getSqlSession().delete(statement, parameters);
	}
}
