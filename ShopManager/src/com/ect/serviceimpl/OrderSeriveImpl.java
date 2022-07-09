package com.ect.serviceimpl;

import java.util.List;

import com.etc.dao.OrderDao;
import com.etc.daoimpl.OrderDaoImpl;
import com.etc.entity.Order;
import com.etc.service.OrderService;

public class OrderSeriveImpl implements OrderService{
	private OrderDao od=new OrderDaoImpl();
	//添加订单
	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		return od.addOrder(order);
	}

	//根据Id查询订单
	@Override
	public Order getOrderById(int orderid) {
		// TODO Auto-generated method stub
		return od.getOrderById(orderid);
	}

	//查询全部订单
	@Override
	public List<Order> OrderAll() {
		// TODO Auto-generated method stub
		return od.OrderAll();
	}

	//修改
	@Override
	public boolean modifiOrder(Order order) {
		// TODO Auto-generated method stub
		return od.modifiOrder(order);
	}

	//删除
	@Override
	public boolean deleteOrder(int orderid) {
		// TODO Auto-generated method stub
		return od.deleteOrder(orderid);
	}

	//查询总数
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return od.countAll();
	}

	//分页查询
	@Override
	public List<Order> ListOrderByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return od.ListOrderByPage(pageIndex, pageSize);
	}

}
