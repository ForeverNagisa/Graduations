package com.james.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.james.bean.Person;
import com.james.service.PersonService;
import com.james.service.impl.PersonServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Person person = new Person();
		try {
			BeanUtils.populate(person, request.getParameterMap());
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PersonService service = new PersonServiceImpl();
		boolean login = service.login(person);
		String headimg = service.getHeadimg(person);
		if (login) {
			// 登录成功
			person.setHeadimg(headimg);
			request.getSession().setAttribute("username", person);		
			response.setHeader("refresh", "0;url=" + request.getContextPath() + "/Personindex.jsp");
		}else {
			// 登录失败 
			request.setAttribute("msg", "登录失败 用户名或密码错误");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}