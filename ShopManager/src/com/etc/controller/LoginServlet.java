package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.ManagerDao;
import com.etc.daoimpl.ManagerDaoImpl;
import com.etc.entity.Manager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName=request.getParameter("uname");
		String userPwd=request.getParameter("upwd");
		ManagerDao manager=new ManagerDaoImpl();
		Manager m = manager.dologin(userName,userPwd);
		PrintWriter out=response.getWriter();
		if(m!=null)
		{
			out.print("success");
//			<script>alert('µÇÂ½³É¹¦');location='ee.jsp';</script>
		}
		else
		{
			out.print("false");
//			<script>alert('µÇÂ½Ê§°Ü');location='index.jsp';</script>
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
