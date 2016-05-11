package com.keepmoving.yuanmeng.services.impls;

import java.util.List;

import javax.annotation.Resource;

import com.keepmoving.yuanmeng.dao.DbDao;
import com.keepmoving.yuanmeng.services.interfaces.BaseService;

public class BaseServiceImpl implements BaseService {

	@Resource(name = "dbDao")
	private DbDao dbDao;

	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Object> query(String statement) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> query(String statement, Object parameters) {
		return this.dbDao.query(statement, parameters);
	}

	
}
