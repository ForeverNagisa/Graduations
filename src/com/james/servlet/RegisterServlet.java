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

public class RegisterServlet extends HttpServlet {

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
		boolean isRegister = service.register(person);
		if (isRegister) {
			// 注册成功
			request.setAttribute("msg", "注册成功!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			// 注册失败
			request.setAttribute("msg", "注册失败,请重新注册!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}