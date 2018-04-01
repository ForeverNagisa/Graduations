package com.james;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class CodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ValidateCode vCode = new ValidateCode(100, 30, 4, 10);
		String code = vCode.getCode();
		// 写到网页上(通过字节流 写回网页)
		System.out.println(code);
		vCode.write(response.getOutputStream());
//		request.getSession().setAttribute("code", code);
		request.setAttribute("code", code);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
