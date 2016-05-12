package com.keepmoving.yuanmeng.services.impls;

import java.util.List;

import javax.annotation.Resource;

import com.keepmoving.yuanmeng.dao.DbDao;
import com.keepmoving.yuanmeng.services.interfaces.BaseService;

public class BaseServiceImpl implements BaseService {

	@Resource(name = "dbDao")
	private DbDao dbDao;

	public int add(String statement) {
		return (Integer) dbDao.insert(statement);
	}
	
	public int add(String statement, Object parameters) {
		return (Integer) dbDao.insert(statement, parameters);
	}

	public int update(String statement) {
		return this.dbDao.update(statement);
	}
	
	public int update(String statement, Object parameters) {
		return this.dbDao.update(statement, parameters);
	}

	public int delete(String statement) {
		return this.dbDao.delect(statement);
	}
	
	public int delete(String statement, Object parameters) {
		return this.dbDao.delect(statement, parameters);
	}

	public List<Object> query(String statement) {
		return this.dbDao.query(statement);
	}

	public List<Object> query(String statement, Object parameters) {
		return this.dbDao.query(statement, parameters);
	}

	
}
