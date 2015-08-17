package com.wyhello.jeasyuidemotest.db;

import java.util.Collection;

public interface SQLTemplate {

	public abstract void close();

	//DML
	//insert into emp values(?,?,?,?,?,?,?,?);
	public abstract void update(String sql, Object[] args);

	public abstract Collection<? extends Object> query(String sql, Object[] args,
			RsMappingObject mapper);
	public abstract Object find(String sql, Object[] args,RsMappingObject mapper);
}