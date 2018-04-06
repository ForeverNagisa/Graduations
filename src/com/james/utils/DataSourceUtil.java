package com.james.utils;
/*
 * javax.sql.DataSource java扩展包
 * 需要导入的jar包(dbcp中依赖pool架包中的类)
 * commons-dbcp-1.4.jar 
 * commons-pool-1.5.6.jar
 * BasicDataSource 是 DataSource(规范类) 的实现类
 * 基础设置(要使用数据库连接池 必须要设置的内容)
 * mysql驱动类 com.mysql.jdbc.Driver
 * 访问数据库连接地址 
 * 数据库访问用户名 和 密码
 */

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceUtil {
	private static BasicDataSource dataSource
	= new BasicDataSource();
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		//  设置dataSource
		//  mysql的驱动类的全限定类名
		dataSource.setDriverClassName(rb.getString("driverClass"));
		dataSource.setUrl(rb.getString("url"));
		dataSource.setUsername(rb.getString("user"));
		dataSource.setPassword(rb.getString("password"));
		//  扩展设置
		//  初始化连接数
		dataSource.setInitialSize(Integer.parseInt(rb.getString("initialSize")));
		//  最大活动数
		dataSource.setMaxActive(Integer.parseInt(rb.getString("maxActive")));
		//  最大空闲连接数
		dataSource.setMaxIdle(Integer.parseInt(rb.getString("maxIdle")));
		//  最小空闲连接数
		dataSource.setMinIdle(Integer.parseInt(rb.getString("minIdle")));
	}
	
	//  获取数据连接池方法
	public static DataSource getDataSource() {
		return dataSource;
	}
	
}







