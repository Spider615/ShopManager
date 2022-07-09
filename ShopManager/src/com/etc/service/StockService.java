package com.etc.service;

import java.util.List;

import com.etc.entity.Stock;

public interface StockService {
			//添加库存
			boolean addStock(Stock stock);
			//根据名称查询商品库存
			Stock getStockByName(String shopName);
			//查询全部商品库存
			List<Stock> StockAll();
			//修改
			boolean modifiSock(Stock stock);
			//删除
			boolean deleteStock(String shopName);
			//查询总数
			int countAll();
			//分页查询
			List<Stock> ListStockByPage(int pageIndex,int pageSize);
}
