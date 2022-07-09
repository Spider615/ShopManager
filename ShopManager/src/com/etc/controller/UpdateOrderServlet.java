package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.daoimpl.OrderDaoImpl;
import com.etc.daoimpl.ShopDaoImpl;
import com.etc.entity.Order;
import com.etc.entity.Shop;

/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderServlet() {
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
        String orderRecevie = request.getParameter("orderRecevie");
        String orderPhone = request.getParameter("orderPhone");
		String orderAddress = request.getParameter("orderAddress");
		String orderTypeId = request.getParameter("orderTypeId");
		String orderId = request.getParameter("orderId");
		String orderName = request.getParameter("orderName");
		String orderMethod = request.getParameter("orderMethod");
		Order order = new Order(Integer.parseInt(orderId),Integer.parseInt(orderTypeId),orderPhone,orderRecevie,orderAddress,orderName,orderMethod);
		OrderDaoImpl od = new OrderDaoImpl();
		boolean re = od.modifiOrder(order);
		PrintWriter out = response.getWriter();
		if (re) {
			out.print("success");
		}else {
			out.print("false");
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
