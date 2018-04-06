package com.james.service;

import com.james.bean.Person;

public interface PersonService {

	// 注册用户
	public boolean register(Person person);
	
	// 登录用户
	public boolean login(Person person);
}