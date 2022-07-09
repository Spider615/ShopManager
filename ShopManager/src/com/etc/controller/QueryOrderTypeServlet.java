package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.etc.dao.SentTypeDao;
import com.etc.dao.ShopTypeDao;
import com.etc.daoimpl.SentTypeDaoImpl;
import com.etc.daoimpl.ShopTypeImpl;
import com.etc.entity.SentType;
import com.etc.entity.ShopType;

/**
 * Servlet implementation class QueryOrderTypeServlet
 */
@WebServlet("/QueryOrderTypeServlet")
public class QueryOrderTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOrderTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        SentTypeDao stDao = new SentTypeDaoImpl();
      //²éÑ¯×ÜÊý
      	int countAll = stDao.countAll();
        List<SentType> list = stDao.SentTypeAll();
        String str = "";
        int i=0;
        for (SentType s:list) {
        	if (i!=0) {
        		str += ",";
        	}
        	str += s.getTypeId();
        	str += ",";
        	str += s.getSentName();
        	i++;
        }
		PrintWriter out = response.getWriter();
		out.print(str);
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
