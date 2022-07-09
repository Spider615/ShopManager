package com.ect.serviceimpl;

import java.util.List;

import com.etc.dao.ShopTypeDao;
import com.etc.daoimpl.ShopTypeImpl;
import com.etc.entity.ShopType;
import com.etc.service.ShopTypeService;

public class ShopTypeServiceImpl implements ShopTypeService{
	private ShopTypeDao st=new ShopTypeImpl();
	//添加商品类型
	@Override
	public boolean addShopType(ShopType shoptype) {
		// TODO Auto-generated method stub
		return st.addShopType(shoptype);
	}
	//根据商品类型id查询商品
	@Override
	public ShopType getShopByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return st.getShopByTypeId(typeId);
	}
	//根据商品类别查询商品
	@Override
	public ShopType getShopByTypeName(String typeName) {
		// TODO Auto-generated method stub
		return st.getShopByTypeName(typeName);
	}
	//修改
	@Override
	public boolean modifiShopType(ShopType shoptype) {
		// TODO Auto-generated method stub
		return st.modifiShopType(shoptype);
	}
	//删除
	@Override
	public boolean deleteType(int typeId) {
		// TODO Auto-generated method stub
		return st.deleteType(typeId);
	}
	//查询总数
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return st.countAll();
	}
	//分页查询
	@Override
	public List<ShopType> ListShopTypeByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return st.ListShopTypeByPage(pageIndex, pageSize);
	}
	//查询全部商品类型
	@Override
	public List<ShopType> ShopAll() {
		// TODO Auto-generated method stub
		return st.ShopTypeAll();
	}

}
