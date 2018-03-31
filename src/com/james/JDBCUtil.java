package com.james;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	static {
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection =  DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException("获取连接错误");
		}
		return connection;
	}
	
	public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			}
			catch (SQLException e) {
			throw new RuntimeException("关闭失败");
		}
			// 加快系统回收的速度♻️
			resultSet = null;
		} 
		if (statement != null) {
			try {
				statement.close();
			}
			catch (SQLException e) {
			throw new RuntimeException("关闭失败");
		}
			// 加快系统回收的速度♻️
			statement = null;
		} 
		if (connection != null) {
			try {
				connection.close();
			}
			catch (SQLException e) {
			throw new RuntimeException("关闭失败");
		}
			// 加快系统回收的速度♻️
			connection = null;
		} 
	}
}

