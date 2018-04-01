package com.james;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/*
 * 登陆账号
 */

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "select * from person where username=? and password=?";
		QueryRunner qr = new QueryRunner();
		Connection connection = JDBCUtil.getConnection();
		try {
			List<Object[]> query = qr.query(connection, sql, new ArrayListHandler(), username,password);
			if (!query.isEmpty()) {
				response.setHeader("refresh", "0;url=/Graduation/Personindex.jsp");			
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}