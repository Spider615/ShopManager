package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.etc.daoimpl.ShopDaoImpl;
import com.etc.entity.Shop;

/**
 * Servlet implementation class UpdateShopServlet
 */
@WebServlet("/UpdateShopServlet")
public class UpdateShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShopServlet() {
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
        String shopId = request.getParameter("shopId");
        String typeId = request.getParameter("typeId");
		String typeName = request.getParameter("typeName");
		String shopName = request.getParameter("shopName");
		String shopPrice = request.getParameter("shopPrice");
		String shopStock = request.getParameter("shopStock");
		String shopDesc = request.getParameter("shopDesc");
		Shop shop = new Shop(Integer.parseInt(shopId),shopName,Integer.parseInt(typeId),Double.parseDouble(shopPrice),Integer.parseInt(shopStock),shopDesc);
		ShopDaoImpl sd = new ShopDaoImpl();
		boolean re = sd.modifiShop(shop);
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
