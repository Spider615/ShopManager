package com.etc.service;

import java.util.List;

import com.etc.entity.Order;

public interface OrderService {
			//添加订单
			boolean addOrder(Order order);
			//根据Id查询订单
			Order getOrderById(int orderid);
			//查询全部订单
			List<Order> OrderAll();
			//修改
			boolean modifiOrder(Order order);
			//删除
			boolean deleteOrder(int orderid);
			//查询总数
			int countAll();
			//分页查询
			List<Order> ListOrderByPage(int pageIndex,int pageSize);
}
