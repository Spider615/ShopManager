package com.etc.service;

import java.util.List;

import com.etc.entity.Shop;

public interface ShopService {
	//添加商品
	boolean addShop(Shop shop);
	//根据ID查询商品
	Shop getShopById(int shopId);
	//修改
	boolean modifiShop(Shop shop);
	//删除
	boolean deleteShop(int shopId);
	//查询总数
	int countAll();
	//分页查询
	List<Shop> ListStudentByPage(int pageIndex,int pageSize);
	//模糊查询
	List<Shop> getShopByDim(String userName);
	//通过商品名称查ID
	Shop getShopIdByName(String shopName);
}
