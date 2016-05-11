package com.keepmoving.yuanmeng.services.interfaces;

import java.util.List;

public interface BaseService {

	public int add();

	public int update();

	public int delete();

	public List<Object> query(String statement);

	public List<Object> query(String statement, Object parameters);
}
