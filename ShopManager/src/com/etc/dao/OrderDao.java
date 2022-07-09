package com.etc.dao;

import java.util.List;

import com.etc.entity.Order;


public interface OrderDao {
		//��Ӷ���
		boolean addOrder(Order order);
		//����Id��ѯ����
		Order getOrderById(int orderid);
		//��ѯȫ������
		List<Order> OrderAll();
		//�޸�
		boolean modifiOrder(Order order);
		//ɾ��
		boolean deleteOrder(int orderid);
		//��ѯ����
		int countAll();
		//��ҳ��ѯ
		List<Order> ListOrderByPage(int pageIndex,int pageSize);
}	
