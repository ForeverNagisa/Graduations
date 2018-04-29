package com.james.service;

import com.james.bean.Person;
import org.springframework.stereotype.Service;


public interface PersonService {

	// 用户登录
	Person loginPerson(Person person);

	// 注册
	boolean registerPerson(Person person);

	// 修改用户信息
	void updatePersonInfo(Person person);

    void upPersonimgs(String newFileName, Integer id);
}
