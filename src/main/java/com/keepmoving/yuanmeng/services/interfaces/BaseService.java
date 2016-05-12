package com.keepmoving.yuanmeng.services.interfaces;

import java.util.List;

public interface BaseService {
	
	int add(String statement);
	
	int add(String statement, Object parameters);

	int update(String statement);

	int update(String statement, Object parameters);

	int delete(String statement);
	
	int delete(String statement, Object parameters);

	List<Object> query(String statement);

	List<Object> query(String statement, Object parameters);
}
