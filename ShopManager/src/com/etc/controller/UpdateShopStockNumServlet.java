package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.daoimpl.StockDaoImpl;
import com.etc.entity.Stock;

/**
 * Servlet implementation class UpdateShopStockNumServlet
 */
@WebServlet("/UpdateShopStockNumServlet")
public class UpdateShopStockNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShopStockNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopStock = request.getParameter("shopStock");
		String shopName = request.getParameter("shopName");
		String importNum = request.getParameter("quantity");
		StockDaoImpl sd = new StockDaoImpl();
		Stock stock = new Stock(shopName,Integer.parseInt(importNum),Integer.parseInt(shopStock));
		boolean rs = sd.modifiSock(stock);
		PrintWriter out = response.getWriter();
		if (rs) {
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
