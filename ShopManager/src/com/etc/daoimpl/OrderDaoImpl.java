package com.etc.daoimpl;

import java.util.List;

import com.etc.dao.OrderDao;
import com.etc.entity.Order;
import com.etc.entity.Shop;
import com.etc.util.DBUtil;

public class OrderDaoImpl implements OrderDao{

	//添加订单
	@Override
	public boolean addOrder(Order order) {
		String sql="insert into orders(typeId,receiver,phone,address,sentmethod,ordername,orderprice,orderdesc) values(?,?,?,?,?,?,?,?)";
		boolean result=DBUtil.execUpdate(sql,order.getTypeId(),order.getReceiver(),order.getPhone(),order.getAddress(),order.getSentMethod(),order.getOrderName(),order.getOrderPrice(),order.getOrderDesc());
		return result;
	}

	//根据Id查询订单
	@Override
	public Order getOrderById(int orderid) {
		String sql="select * from orders where orderId=?";
		Order order=(Order)DBUtil.getFirst(sql, Order.class, orderid);
		return order;
	}
	
	//查询全部订单
	@Override
	public List<Order> OrderAll() {
		String sql="select * from orders";
		List<Order> list=(List<Order>)DBUtil.selectList(sql, Order.class);
		return list;
	}
	
	//修改
	@Override
	public boolean modifiOrder(Order order) {
		String sql="update orders set receiver=?,phone=?,address=?,sentMethod=? where orderId=?";
		boolean result=DBUtil.execUpdate(sql,order.getReceiver(),order.getPhone(),order.getAddress(),order.getSentMethod(),order.getOrderId());
		return result;
	}

	//删除
	@Override
	public boolean deleteOrder(int orderid) {
		String sql="delete from orders where orderId=?";
		boolean result=DBUtil.execUpdate(sql, orderid);
		return result;
	}
	//查询总数
	@Override
	public int countAll() {
		String sql="select count(1) from orders";
		int result=(int)((long)DBUtil.getFirst(sql,Object.class));
		return result;
	}
	//分页查询
	@Override
	public List<Order> ListOrderByPage(int pageIndex, int pageSize) {
		String sql="select * from orders limit ?,?";
		int limitBegin=(pageIndex-1)*pageSize;
		List<Order> list=(List<Order>)DBUtil.selectList(sql,Order.class,limitBegin,pageSize);
		return list;
	}

}
