package com.james;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
/*
 * 注册
 */

public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 获取信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		String codes = (String) request.getSession().getAttribute("code");
		
		// 连接数据库
		Connection connection = JDBCUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "insert into person values(?,?,?,?)";
		// 判断验证码输入是否正确
		if (code.equalsIgnoreCase(codes)) {
			// 正确
			try {
			int row = qr.update(connection,sql, username,password,sex,email);
			if (row>0) {
				System.out.println("插入成功");
				response.setHeader("refresh", "0;url=/Graduation/index.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}else {
			// 验证码错误
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
