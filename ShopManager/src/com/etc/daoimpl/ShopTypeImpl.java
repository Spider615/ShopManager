package com.etc.daoimpl;

import java.util.List;

import com.etc.dao.ShopTypeDao;
import com.etc.entity.Shop;
import com.etc.entity.ShopType;
import com.etc.util.DBUtil;

public class ShopTypeImpl implements ShopTypeDao{

	//添加商品类型
	@Override
	public boolean addShopType(ShopType shoptype) {
		String sql="insert into shoptype values(null,?)";
		boolean result=DBUtil.execUpdate(sql,shoptype.getTypeName());
		return result;
	}

	//根据商品类型id查询商品
	@Override
	public ShopType getShopByTypeId(int typeId) {
		String sql="select * from shoptype where typeId=?";
		ShopType shoptype=(ShopType)DBUtil.getFirst(sql, ShopType.class, typeId);
		return shoptype;
	}

	//根据商品类别查询商品
	@Override
	public ShopType getShopByTypeName(String typeName) {
		String sql="select * from shoptype where typeName=?";
		ShopType shoptype=(ShopType)DBUtil.getFirst(sql,ShopType.class,typeName);
		return shoptype;
	}

	//修改
	@Override
	public boolean modifiShopType(ShopType shoptype) {
		String sql="update shoptype set typeId=?,typeName=?";
		boolean result=DBUtil.execUpdate(sql,shoptype.getTypeId(),shoptype.getTypeName(),shoptype);
		return result;
	}

	//删除
	@Override
	public boolean deleteType(int typeId) {
		String sql="delete from shoptype where typeId=?";
		boolean result=DBUtil.execUpdate(sql, typeId);
		return result;
	}

	//查询总数
	@Override
	public int countAll() {
		String sql="select count(1) from shoptype";
		int result=(int)((long)DBUtil.getFirst(sql,Object.class));
		return result;
	}

	//分页查询
	@Override
	public List<ShopType> ListShopTypeByPage(int pageIndex, int pageSize) {
		String sql="select * from shoptype limit ?,?";
		int limitBegin=(pageIndex-1)*pageSize;
		List<ShopType> list=(List<ShopType>)DBUtil.selectList(sql,ShopType.class,limitBegin,pageSize);
		return list;
	}
	//查询全部商品类型
	@Override
	public List<ShopType> ShopTypeAll() {
		String sql="select * from shoptype";
		List<ShopType> list=(List<ShopType>)DBUtil.selectList(sql,ShopType.class);
		return list;
	}

}
