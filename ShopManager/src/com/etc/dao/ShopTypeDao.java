package com.etc.dao;

import java.util.List;

import com.etc.entity.Shop;
import com.etc.entity.ShopType;

public interface ShopTypeDao {
	   //�����Ʒ����
		boolean addShopType(ShopType shoptype);
		//������Ʒ����id��ѯ��Ʒ
		ShopType getShopByTypeId(int typeId);
		//������Ʒ����ѯ��Ʒ
		ShopType getShopByTypeName(String typeName);
		//�޸�
		boolean modifiShopType(ShopType shoptype);
		//ɾ��
		boolean deleteType(int typeId);
		//��ѯ����
		int countAll();
		//��ҳ��ѯ
		List<ShopType> ListShopTypeByPage(int pageIndex,int pageSize);
		//��ѯȫ����Ʒ����
		List<ShopType> ShopTypeAll();
}
