package com.etc.dao;

import java.util.List;

import com.etc.entity.Manager;
import com.etc.entity.Shop;

public interface ShopDao {
	//添加商品
	boolean addShop(Shop shop);
	//根据ID查询商品
	Shop getShopById(int shopId);
	//根据名称查询商品
	Shop getShopByName(String userName);
	//修改
	boolean modifiShop(Shop shop);
	//删除
	boolean deleteShop(int shopId);
	//查询总数
	int countAll();
	//分页查询
	List<Shop> ListStudentByPage(int pageIndex,int pageSize);
	//查询全部
	List<Shop> ShopAll();
	//模糊查询
	List<Shop> getShopByDim(String userName);
	//通过商品名称查ID
	Shop getShopIdByName(String shopName);
	boolean deleteShopByName(String shopName);
}
