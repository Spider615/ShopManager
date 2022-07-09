package com.etc.daoimpl;

import java.util.List;

import com.etc.dao.StockDao;
import com.etc.entity.Shop;
import com.etc.entity.ShopType;
import com.etc.entity.Stock;
import com.etc.util.DBUtil;

public class StockDaoImpl implements StockDao{

	 //��ӿ��
	@Override
	public boolean addStock(Stock stock) {
		String sql="insert into stock values(?,?,?)";
		boolean result=DBUtil.execUpdate(sql,stock.getShopName(),stock.getImportNum(),stock.getStockNum());
		return result;
	}

	//�������Ʋ�ѯ��Ʒ���
	@Override
	public Stock getStockByName(String shopName) {
		String sql="select * from stock where shopName=?";
		Stock stock=(Stock)DBUtil.getFirst(sql,Stock.class,shopName);
		return stock;
	}
	
	//��ѯȫ����Ʒ���
	@Override
	public List<Stock> StockAll() {
		String sql="select * from stock";
		List<Stock> list=(List<Stock>)DBUtil.selectList(sql,Stock.class);
		return list;
	}

	//�޸�
	@Override
	public boolean modifiSock(Stock stock) {
		String sql="update stock set importNum=?,stockNum=? where shopName=?";
		boolean result=DBUtil.execUpdate(sql,stock.getImportNum(),stock.getStockNum(),stock.getShopName());
		return result;
	}

	//ɾ��
	@Override
	public boolean deleteStock(String shopName) {
		String sql="delete from stock where ShopName=?";
		boolean result=DBUtil.execUpdate(sql, shopName);
		return result;
	}

	//��ѯ����
	@Override
	public int countAll() {
		String sql="select count(1) from stock";
		int result=(int)((long)DBUtil.getFirst(sql,Object.class));
		return result;
	}
	
	//��ҳ��ѯ
	@Override
	public List<Stock> ListStockByPage(int pageIndex, int pageSize) {
		String sql="select * from stock limit ?,?";
		int limitBegin=(pageIndex-1)*pageSize;
		List<Stock> list=(List<Stock>)DBUtil.selectList(sql,Stock.class,limitBegin,pageSize);
		return list;
	}



}
