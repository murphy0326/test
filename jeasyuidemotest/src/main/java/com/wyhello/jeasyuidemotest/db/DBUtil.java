package com.wyhello.jeasyuidemotest.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String driverClassName = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	private DBUtil() {// 构造方法私有化 （谁都创建不了这个类的对象）

	}

	static {	// 静态代码块 （只会随着这个类的加载一次）
		Class<DBUtil> clazz  = DBUtil.class;
		// 查找一个给定名称的资源（会到类路径下所搜文件）
		InputStream is = clazz.getResourceAsStream("/dbconf.properties");
		Properties props = new Properties();
		try {
			props.load(is);
			driverClassName = props.getProperty("driverClassName");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (IOException e) {
			System.out.println("加载配置文件失败");
		}

		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
