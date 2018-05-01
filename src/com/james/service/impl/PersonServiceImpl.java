package com.james.service.impl;


import com.james.bean.Person;
import com.james.dao.PersonDao;
import com.james.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao dao;

	// 用户登录请求
	@Override
	public Person loginPerson(Person person) {
		return dao.loginPerson(person);
	}


	// 用户注册请求
	@Override
	public boolean registerPerson(Person person) {
		// 根据用户提供名字检查是否注册过
		Person persons = dao.selectPersonByName(person.getUsername());
		if (persons != null){
			// 走到这 说明用户名被占用
			return false;
		}
		dao.registerPerson(person);
		return true;

	}

	// 修改用户信息
	@Override
	public void updatePersonInfo(Person person) {

		dao.updatePersonInfo(person);
	}

	// 上传用户头像
	@Override
	public void upPersonimgs(String newFileName, Integer id) {
		dao.upPersonimgs(newFileName,id);
	}

	// 查找头像

	@Override
	public String getPersonImg(Person person) {
		return dao.getPersonImg(person);
	}
}
