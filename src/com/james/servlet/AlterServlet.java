package com.james.servlet;
/*
 * 修改个人信息
 */

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

public class AlterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("id");
		Person person = new Person();
		System.out.println(name);
		try {
			BeanUtils.populate(person, request.getParameterMap());
			System.out.println(person);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PersonService service = new PersonServiceImpl();
		boolean isAlter = service.alterPeson(name, person);
		if (isAlter) {
			// 修改成功
			response.getWriter().write("修改成功 请重新登陆");
			response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
		}else {
			response.getWriter().write("修改失败");
			response.setHeader("refresh", "1;url=" + request.getContextPath() + "/Personindex.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
