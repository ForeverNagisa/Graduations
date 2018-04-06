package com.james.dao.impl;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.james.bean.Person;
import com.james.dao.PersonDao;
import com.james.utils.DataSourceUtil;

public class PersonDaoImpl implements PersonDao {
	// 第三方类包
	QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

	// 注册用户
	@Override
	public boolean RegisterUser(Person person) throws SQLException {
		// 判断用户名是否已被占用
		boolean isRegist = findUserName(person);
		if (isRegist) {
			// 返回ture 表示没有被注册
			String sql = "insert into person values(Null,?,?,?,?)";
			int row = qr.update(sql, person.getUsername(),person.getPassword(),person.getSex(),person.getEmail());
			if (row > 0) {
				// 插入成功
				return true;
			}
		}
		
		return false;
	}

	// 查找用户名
	@Override
	public boolean findUserName(Person person) throws SQLException {

		String sql = "select * from person where username = ?";
		Person p = qr.query(sql, new BeanHandler<>(Person.class),person.getUsername());
		if (p == null) {
			// 用户名查无此人 
			return true;
		}
		return false;
	}
	
	// 用户登录
	@Override
	public boolean loginPerson(Person person) throws SQLException {
		
		String sql = "select * from person where username = ? and password = ?";
		Person p = qr.query(sql, new BeanHandler<>(Person.class),person.getUsername(),person.getPassword());
		if (p == null) {
			// 登录失败 
			return false;
		}
		return true;
	}
}