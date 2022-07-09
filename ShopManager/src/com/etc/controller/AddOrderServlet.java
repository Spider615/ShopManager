package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ect.serviceimpl.ShopServiceImpl;
import com.etc.dao.OrderDao;
import com.etc.dao.ShopDao;
import com.etc.daoimpl.OrderDaoImpl;
import com.etc.daoimpl.SentTypeDaoImpl;
import com.etc.daoimpl.ShopDaoImpl;
import com.etc.entity.Order;
import com.etc.entity.Shop;
import com.etc.service.ShopService;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String re = "";
		String sentType = request.getParameter("sentType");
		String receive = request.getParameter("receive");
		String phone = request.getParameter("phone");
		String orderAddress = request.getParameter("orderAddress");
		String orderName = request.getParameter("orderName");
		OrderDao od = new OrderDaoImpl();
		SentTypeDaoImpl st = new SentTypeDaoImpl();
		ShopService sp = new ShopServiceImpl();
		Shop shop = sp.getShopIdByName(orderName);
		if (shop!=null) {
			String orderPrice = request.getParameter("orderPrice");
			String orderDesc = request.getParameter("orderDesc");
			
			String sentMethod = st.getSentByTypeId(Integer.parseInt(sentType)).getSentName();
			Order order = new Order(Integer.parseInt(sentType),orderName,receive,phone,orderAddress,sentMethod,Double.parseDouble(orderPrice),orderDesc);
			if (od.addOrder(order)) {
				re = "success";
			}else{
				re = "false";
			}
		}else {
			re = "false:orderName";
		}
		PrintWriter out = response.getWriter();
		out.print(re);
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
