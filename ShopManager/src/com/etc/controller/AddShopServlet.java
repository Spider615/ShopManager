package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.ShopDao;
import com.etc.dao.ShopTypeDao;
import com.etc.daoimpl.ShopDaoImpl;
import com.etc.daoimpl.ShopTypeImpl;
import com.etc.entity.Shop;

/**
 * Servlet implementation class AddShopServlet
 */
@WebServlet("/AddShopServlet")
public class AddShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopType = request.getParameter("shopType");
		String shopName = request.getParameter("shopName");
		String shopPrice = request.getParameter("shopPrice");
		String shopStock = request.getParameter("shopStock");
		String shopDesc = request.getParameter("shopDesc");
		ShopDao sD = new ShopDaoImpl();
		Shop shop = new Shop(shopName,Integer.parseInt(shopType),Double.parseDouble(shopPrice),Integer.parseInt(shopStock),shopDesc);
		String re = "";
		if (sD.addShop(shop)) {
			re = "success";
		}else{
			re = "false";
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
