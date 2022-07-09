package com.etc.daoimpl;

import java.util.List;

import com.etc.dao.ShopTypeDao;
import com.etc.entity.Shop;
import com.etc.entity.ShopType;
import com.etc.util.DBUtil;

public class ShopTypeImpl implements ShopTypeDao{

	//�����Ʒ����
	@Override
	public boolean addShopType(ShopType shoptype) {
		String sql="insert into shoptype values(null,?)";
		boolean result=DBUtil.execUpdate(sql,shoptype.getTypeName());
		return result;
	}

	//������Ʒ����id��ѯ��Ʒ
	@Override
	public ShopType getShopByTypeId(int typeId) {
		String sql="select * from shoptype where typeId=?";
		ShopType shoptype=(ShopType)DBUtil.getFirst(sql, ShopType.class, typeId);
		return shoptype;
	}

	//������Ʒ����ѯ��Ʒ
	@Override
	public ShopType getShopByTypeName(String typeName) {
		String sql="select * from shoptype where typeName=?";
		ShopType shoptype=(ShopType)DBUtil.getFirst(sql,ShopType.class,typeName);
		return shoptype;
	}

	//�޸�
	@Override
	public boolean modifiShopType(ShopType shoptype) {
		String sql="update shoptype set typeId=?,typeName=?";
		boolean result=DBUtil.execUpdate(sql,shoptype.getTypeId(),shoptype.getTypeName(),shoptype);
		return result;
	}

	//ɾ��
	@Override
	public boolean deleteType(int typeId) {
		String sql="delete from shoptype where typeId=?";
		boolean result=DBUtil.execUpdate(sql, typeId);
		return result;
	}

	//��ѯ����
	@Override
	public int countAll() {
		String sql="select count(1) from shoptype";
		int result=(int)((long)DBUtil.getFirst(sql,Object.class));
		return result;
	}

	//��ҳ��ѯ
	@Override
	public List<ShopType> ListShopTypeByPage(int pageIndex, int pageSize) {
		String sql="select * from shoptype limit ?,?";
		int limitBegin=(pageIndex-1)*pageSize;
		List<ShopType> list=(List<ShopType>)DBUtil.selectList(sql,ShopType.class,limitBegin,pageSize);
		return list;
	}
	//��ѯȫ����Ʒ����
	@Override
	public List<ShopType> ShopTypeAll() {
		String sql="select * from shoptype";
		List<ShopType> list=(List<ShopType>)DBUtil.selectList(sql,ShopType.class);
		return list;
	}

}
