package com.ect.serviceimpl;

import java.util.List;

import com.etc.dao.OrderDao;
import com.etc.daoimpl.OrderDaoImpl;
import com.etc.entity.Order;
import com.etc.service.OrderService;

public class OrderSeriveImpl implements OrderService{
	private OrderDao od=new OrderDaoImpl();
	//��Ӷ���
	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		return od.addOrder(order);
	}

	//����Id��ѯ����
	@Override
	public Order getOrderById(int orderid) {
		// TODO Auto-generated method stub
		return od.getOrderById(orderid);
	}

	//��ѯȫ������
	@Override
	public List<Order> OrderAll() {
		// TODO Auto-generated method stub
		return od.OrderAll();
	}

	//�޸�
	@Override
	public boolean modifiOrder(Order order) {
		// TODO Auto-generated method stub
		return od.modifiOrder(order);
	}

	//ɾ��
	@Override
	public boolean deleteOrder(int orderid) {
		// TODO Auto-generated method stub
		return od.deleteOrder(orderid);
	}

	//��ѯ����
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return od.countAll();
	}

	//��ҳ��ѯ
	@Override
	public List<Order> ListOrderByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return od.ListOrderByPage(pageIndex, pageSize);
	}

}
