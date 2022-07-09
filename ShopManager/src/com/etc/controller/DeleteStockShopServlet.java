package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.daoimpl.ShopDaoImpl;
import com.etc.daoimpl.StockDaoImpl;
import com.etc.entity.Shop;

/**
 * Servlet implementation class DeleteStockShopServlet
 */
@WebServlet("/DeleteStockShopServlet")
public class DeleteStockShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStockShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stockName = request.getParameter("stockName");
		ShopDaoImpl sdao = new ShopDaoImpl();
		Shop shop = sdao.getShopByName(stockName);
		PrintWriter out = response.getWriter();
		if (shop == null) {
			out.print("false");
		}else {
			sdao.deleteShopByName(stockName);
			StockDaoImpl sd = new StockDaoImpl();
			boolean rs = sd.deleteStock(stockName);
			out.print(rs?"success":"false");
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
