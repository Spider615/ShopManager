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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.ect.serviceimpl.ShopServiceImpl;
import com.ect.serviceimpl.ShopTypeServiceImpl;
import com.etc.dao.StockDao;
import com.etc.daoimpl.StockDaoImpl;
import com.etc.entity.Shop;
import com.etc.entity.ShopType;
import com.etc.entity.Stock;
import com.etc.service.ShopTypeService;
import com.google.gson.Gson;

/**
 * Servlet implementation class QueryShopServlet
 */
@WebServlet("/QueryShopServlet")
public class QueryShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryShopServlet() {
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
		ShopTypeServiceImpl st = new ShopTypeServiceImpl();
		ShopServiceImpl s = new ShopServiceImpl();
		StockDao sdao = new StockDaoImpl();
		//查询总数
		int countAll = s.countAll();
		//获取商品数据
		List<Shop> list = s.ShopAll();
		Map<Integer,Map> map = new HashMap<Integer, Map>();
		Map<String,Object> m = new HashMap<String, Object>();
		m.put("countAll", countAll);
		map.put(0,m);
		int i=1;
		for (Shop shop:list) {
			Map<String,Object> mm = new HashMap<String, Object>();
			mm.put("Id", shop.getShopId());
			int typeId = shop.getTypeId();
			ShopType shoptype = st.getShopByTypeId(typeId);
			String name = shoptype.getTypeName();
			mm.put("typeName", name);
			mm.put("shopName", shop.getShopName());
			Stock stock = sdao.getStockByName(shop.getShopName());
			mm.put("shopPrice", shop.getShopPrice());
			mm.put("shopStock", stock.getStockNum());
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
