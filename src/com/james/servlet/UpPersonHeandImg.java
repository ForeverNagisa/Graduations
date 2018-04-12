package com.james.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.james.bean.Person;
import com.james.utils.DataSourceUtil;

public class UpPersonHeandImg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("username");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setSizeMax(5 * 1024 * 1024);
		List<FileItem> list = null;
		String path = "";
		try {
			list = sfu.parseRequest(request);

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> iterator = list.iterator();
		while (iterator.hasNext()) {
			FileItem fileItem = iterator.next();
			if (fileItem.isFormField()) {
				String name = fileItem.getFieldName();
				String value = fileItem.getString("utf-8");
			} else {
				String fileName = fileItem.getName();// 文件名称
				System.out.println("原文件名：" + fileName);

				String suffix = fileName.substring(fileName.lastIndexOf('.'));
				System.out.println("扩展名：" + suffix);

				String newFileName = new Date().getTime() + suffix;
				System.out.println("新文件名：" + newFileName);// 

				File file = new File("/Users/lanou/Desktop/java/javaweb/Graduation/WebContent/upimg/" + newFileName);
				path = file.getAbsolutePath();
				try {
					fileItem.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}

				fileItem.delete();
				QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
				String SQL = "update person set headimg=? where username='"+ person.getUsername()+"'";
				int rows = 0;
				try {
					rows = qr.update(SQL, newFileName);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (rows > 0) {
					ServletContext context = this.getServletContext();
					String realPath = context.getRealPath("/img/" + newFileName + "");
					
//					session.setAttribute("image_name", newFileName);
					
					System.out.println(newFileName);
//					session.setAttribute("image_path", "touxiang/" + newFileName);
				}
			}
		}
		response.sendRedirect(request.getContextPath() + "/Personindex.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}