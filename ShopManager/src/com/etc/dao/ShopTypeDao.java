package com.etc.dao;

import java.util.List;

import com.etc.entity.Shop;
import com.etc.entity.ShopType;

public interface ShopTypeDao {
	   //添加商品类型
		boolean addShopType(ShopType shoptype);
		//根据商品类型id查询商品
		ShopType getShopByTypeId(int typeId);
		//根据商品类别查询商品
		ShopType getShopByTypeName(String typeName);
		//修改
		boolean modifiShopType(ShopType shoptype);
		//删除
		boolean deleteType(int typeId);
		//查询总数
		int countAll();
		//分页查询
		List<ShopType> ListShopTypeByPage(int pageIndex,int pageSize);
		//查询全部商品类型
		List<ShopType> ShopTypeAll();
}
