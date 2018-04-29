package com.james.dao;

import java.sql.SQLException;

import com.james.bean.Person;
import org.apache.ibatis.annotations.Param;

/*
 *  操作用户表数据
 * 
 */

public interface PersonDao {


	Person loginPerson(Person person);

	Person selectPersonByName(String username);

	void registerPerson(Person person);

	void updatePersonInfo(Person person);

    void upPersonimgs(@Param("newFileName") String newFileName,@Param("id") Integer id);
}
