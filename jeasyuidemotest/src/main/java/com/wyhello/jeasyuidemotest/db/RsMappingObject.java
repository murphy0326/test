package com.wyhello.jeasyuidemotest.db;

import java.sql.ResultSet;

/*
 * 记录集转对象
 */
public interface RsMappingObject {//接口里没有构造方法
	public Object mapper2Obj(ResultSet rs); //rs要转换的结果集对象
	
}

