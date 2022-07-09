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
import com.etc.daoimpl.ShopDaoImpl;
import com.etc.entity.Shop;
import com.etc.entity.ShopType;
import com.google.gson.Gson;

/**
 * Servlet implementation class FuzzyQueryServlet
 */
@WebServlet("/FuzzyQueryServlet")
public class FuzzyQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuzzyQueryServlet() {
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
		String shopName = request.getParameter("shopName");
		ShopDaoImpl sd = new ShopDaoImpl();
		ShopTypeServiceImpl st = new ShopTypeServiceImpl();
		List<Shop> list = sd.getShopByDim(shopName);
		int count = list.size();
		Map<Integer,Map> map = new HashMap<Integer, Map>();
		Map<String,Object> m = new HashMap<String, Object>();
		m.put("count", count);
		map.put(0,m);
		int i=1;
		for (Shop shop:list) {
			Map<String,Object> mm = new HashMap<String, Object>();
			mm.put("Id", shop.getShopId());
			int typeId = shop.getTypeId();
			ShopType shoptype = st.getShopByTypeId(typeId);
			String typeName = shoptype.getTypeName();
			mm.put("typeName", typeName);
			mm.put("shopName", shop.getShopName());
			mm.put("shopPrice", shop.getShopPrice());
			mm.put("shopStock", shop.getStockNum());
			mm.put("shopDesc", shop.getShopDesc());
			map.put(i++,mm);
		}
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
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
