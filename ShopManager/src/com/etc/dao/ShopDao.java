package com.etc.dao;

import java.util.List;

import com.etc.entity.Manager;
import com.etc.entity.Shop;

public interface ShopDao {
	//�����Ʒ
	boolean addShop(Shop shop);
	//����ID��ѯ��Ʒ
	Shop getShopById(int shopId);
	//�������Ʋ�ѯ��Ʒ
	Shop getShopByName(String userName);
	//�޸�
	boolean modifiShop(Shop shop);
	//ɾ��
	boolean deleteShop(int shopId);
	//��ѯ����
	int countAll();
	//��ҳ��ѯ
	List<Shop> ListStudentByPage(int pageIndex,int pageSize);
	//��ѯȫ��
	List<Shop> ShopAll();
	//ģ����ѯ
	List<Shop> getShopByDim(String userName);
	//ͨ����Ʒ���Ʋ�ID
	Shop getShopIdByName(String shopName);
	boolean deleteShopByName(String shopName);
}
