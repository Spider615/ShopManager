package com.etc.service;

import java.util.List;

import com.etc.entity.Shop;

public interface ShopService {
	//�����Ʒ
	boolean addShop(Shop shop);
	//����ID��ѯ��Ʒ
	Shop getShopById(int shopId);
	//�޸�
	boolean modifiShop(Shop shop);
	//ɾ��
	boolean deleteShop(int shopId);
	//��ѯ����
	int countAll();
	//��ҳ��ѯ
	List<Shop> ListStudentByPage(int pageIndex,int pageSize);
	//ģ����ѯ
	List<Shop> getShopByDim(String userName);
	//ͨ����Ʒ���Ʋ�ID
	Shop getShopIdByName(String shopName);
}
