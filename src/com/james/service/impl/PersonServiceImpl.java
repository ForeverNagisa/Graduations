package com.james.service.impl;

import java.sql.SQLException;

import com.james.bean.Person;
import com.james.dao.PersonDao;
import com.james.dao.impl.PersonDaoImpl;
import com.james.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao dao = new PersonDaoImpl();

	// 注册处理
	@Override
	public boolean register(Person person) {
		
		boolean isRegister = false;
		try {
			 isRegister = dao.RegisterUser(person);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRegister;
	}

	// 登录处理
	@Override
	public boolean login(Person person) {
		boolean isLogin = false;
		
		try {
			isLogin = dao.loginPerson(person);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回false 登陆失败 true登陆成功
		return isLogin;
	}
	
	
}
