package com.ect.serviceimpl;

import java.util.List;

import com.etc.dao.StockDao;
import com.etc.daoimpl.StockDaoImpl;
import com.etc.entity.Stock;
import com.etc.service.StockService;

public class StockServiceImpl implements StockService{
	private StockDao sk=new StockDaoImpl();
	@Override
	public boolean addStock(Stock stock) {
		// TODO Auto-generated method stub
		return sk.addStock(stock);
	}

	@Override
	public Stock getStockByName(String shopName) {
		// TODO Auto-generated method stub
		return sk.getStockByName(shopName);
	}

	@Override
	public List<Stock> StockAll() {
		// TODO Auto-generated method stub
		return sk.StockAll();
	}

	@Override
	public boolean modifiSock(Stock stock) {
		// TODO Auto-generated method stub
		return sk.modifiSock(stock);
	}

	@Override
	public boolean deleteStock(String shopName) {
		// TODO Auto-generated method stub
		return sk.deleteStock(shopName);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return sk.countAll();
	}

	@Override
	public List<Stock> ListStockByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return sk.ListStockByPage(pageIndex, pageSize);
	}

}
