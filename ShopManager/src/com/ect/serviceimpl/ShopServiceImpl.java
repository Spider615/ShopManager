package com.ect.serviceimpl;

import java.util.List;

import com.etc.dao.ManagerDao;
import com.etc.dao.ShopDao;
import com.etc.daoimpl.ManagerDaoImpl;
import com.etc.daoimpl.ShopDaoImpl;
import com.etc.entity.Shop;
import com.etc.service.ShopService;

public class ShopServiceImpl implements ShopService{

	private ShopDao sp=new ShopDaoImpl();
	@Override
	public boolean addShop(Shop shop) {
		// TODO Auto-generated method stub
		return sp.addShop(shop);
	}

	@Override
	public Shop getShopById(int shopId) {
		// TODO Auto-generated method stub
		return sp.getShopById(shopId);
	}

	@Override
	public boolean modifiShop(Shop shop) {
		// TODO Auto-generated method stub
		return sp.modifiShop(shop);
	}

	@Override
	public boolean deleteShop(int shopId) {
		// TODO Auto-generated method stub
		return sp.deleteShop(shopId);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return sp.countAll();
	}

	//∑÷“≥≤È—Ø
	@Override
	public List<Shop> ListStudentByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return sp.ListStudentByPage(pageIndex, pageSize);
	}

	public List<Shop> ShopAll() {
		// TODO Auto-generated method stub
		return sp.ShopAll();
	}

	@Override
	public List<Shop> getShopByDim(String userName) {
		// TODO Auto-generated method stub
		return sp.getShopByDim(userName);
	}

	@Override
	public Shop getShopIdByName(String shopName) {
		// TODO Auto-generated method stub
		return sp.getShopIdByName(shopName);
	}
}
