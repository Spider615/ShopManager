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

import com.ect.serviceimpl.ShopServiceImpl;
import com.ect.serviceimpl.ShopTypeServiceImpl;
import com.etc.dao.StockDao;
import com.etc.daoimpl.StockDaoImpl;
import com.etc.entity.Shop;
import com.etc.entity.ShopType;
import com.etc.entity.Stock;
import com.google.gson.Gson;

/**
 * Servlet implementation class QueryStockShopServlet
 */
@WebServlet("/QueryStockShopServlet")
public class QueryStockShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStockShopServlet() {
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
		StockDao sdao = new StockDaoImpl();
		Stock stock = new Stock();
		//查询总数
		int countAll = sdao.countAll();
		//获取商品数据
		List<Stock> list = sdao.StockAll();
		Map<Integer,Map> map = new HashMap<Integer, Map>();
		Map<String,Object> m = new HashMap<String, Object>();
		m.put("countAll", countAll);
		map.put(0,m);
		int i=1;
		for (Stock sto:list) {
			Map<String,Object> mm = new HashMap<String, Object>();
			mm.put("stockName", sto.getShopName());
			mm.put("stockNum", sto.getStockNum());
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
