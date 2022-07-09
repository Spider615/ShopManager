package com.ect.serviceimpl;

import java.util.List;

import com.etc.dao.ShopTypeDao;
import com.etc.daoimpl.ShopTypeImpl;
import com.etc.entity.ShopType;
import com.etc.service.ShopTypeService;

public class ShopTypeServiceImpl implements ShopTypeService{
	private ShopTypeDao st=new ShopTypeImpl();
	//�����Ʒ����
	@Override
	public boolean addShopType(ShopType shoptype) {
		// TODO Auto-generated method stub
		return st.addShopType(shoptype);
	}
	//������Ʒ����id��ѯ��Ʒ
	@Override
	public ShopType getShopByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return st.getShopByTypeId(typeId);
	}
	//������Ʒ����ѯ��Ʒ
	@Override
	public ShopType getShopByTypeName(String typeName) {
		// TODO Auto-generated method stub
		return st.getShopByTypeName(typeName);
	}
	//�޸�
	@Override
	public boolean modifiShopType(ShopType shoptype) {
		// TODO Auto-generated method stub
		return st.modifiShopType(shoptype);
	}
	//ɾ��
	@Override
	public boolean deleteType(int typeId) {
		// TODO Auto-generated method stub
		return st.deleteType(typeId);
	}
	//��ѯ����
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return st.countAll();
	}
	//��ҳ��ѯ
	@Override
	public List<ShopType> ListShopTypeByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return st.ListShopTypeByPage(pageIndex, pageSize);
	}
	//��ѯȫ����Ʒ����
	@Override
	public List<ShopType> ShopAll() {
		// TODO Auto-generated method stub
		return st.ShopTypeAll();
	}

}
