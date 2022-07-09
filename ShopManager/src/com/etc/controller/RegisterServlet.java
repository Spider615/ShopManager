package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.ManagerDao;
import com.etc.daoimpl.ManagerDaoImpl;
import com.etc.entity.Manager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName=request.getParameter("uname");
		String userPwd=request.getParameter("upwd");
		String reregpass=request.getParameter("reregpass");
		PrintWriter out=response.getWriter();
		if("".equals(userName) || "".equals(userPwd) || "".equals(reregpass))
		{
			String str="false";
			out.print(str);			
		}
		else
		{
			try {
				if(userPwd.equals(reregpass))
				{
					ManagerDao manager=new ManagerDaoImpl();
					Manager mm= new Manager(userName,userPwd);
					boolean m = manager.register(mm);
					if(m)
					{
						out.print("success");
					}
					else
					{
						out.print("false1");
					}
				}
				else
				{
					out.print("false2");
				}
			} catch (Exception e) {
//				e.printStackTrace();
			}
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
