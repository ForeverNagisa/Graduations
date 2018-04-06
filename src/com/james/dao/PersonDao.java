package com.james.dao;

import java.sql.SQLException;

import com.james.bean.Person;

/*
 *  操作用户表数据
 * 
 */

public interface PersonDao {
	
	/**
	 * 注册用户
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public boolean RegisterUser(Person person) throws SQLException;

	/**
	 * 根据用户名查找该用户是否注册
	 * @param person
	 * @throws SQLException
	 */
	public boolean findUserName(Person person) throws SQLException ;
	
	/**
	 * 用户登录
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public boolean loginPerson(Person person) throws SQLException ;
	
	/**
	 * 用户信息修改
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean alterPerson(String[] id) throws SQLException;
}
