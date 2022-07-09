package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ect.serviceimpl.ShopTypeServiceImpl;
import com.etc.daoimpl.OrderDaoImpl;
import com.etc.daoimpl.SentTypeDaoImpl;
import com.etc.daoimpl.ShopDaoImpl;
import com.etc.entity.Order;
import com.etc.entity.Shop;
import com.etc.entity.ShopType;
import com.google.gson.Gson;

/**
 * Servlet implementation class FuzzyQueryOrderServlet
 */
@WebServlet("/FuzzyQueryOrderServlet")
public class FuzzyQueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuzzyQueryOrderServlet() {
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
		String msg = request.getParameter("msg");		//¶©µ¥±àºÅ
		OrderDaoImpl od = new OrderDaoImpl();
		Order order = od.getOrderById(Integer.parseInt(msg));
		Map<String,Object> mm = new HashMap<String, Object>();
		mm.put("orderId", order.getOrderId());
		mm.put("orderName", order.getOrderName());
		mm.put("orderDesc", order.getOrderDesc());
		mm.put("orderPhone", order.getPhone());
		mm.put("orderReceive", order.getReceiver());
		mm.put("orderAddress", order.getAddress());
		mm.put("orderSentMethod", order.getSentMethod());
		mm.put("orderPrice", order.getOrderPrice());
		mm.put("orderTime", order.getTime());
		Gson gson = new Gson();
		String jsonStr = gson.toJson(mm);
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
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
