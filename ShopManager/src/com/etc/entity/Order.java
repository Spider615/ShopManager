package com.etc.entity;

public class Order {
	private int orderId;//����ID
	private int typeId;//�������Id
	private String receiver;//�ջ���
	private String phone;//�ջ��˵绰
	private String address;//�ջ��˵�ַ
	private String sentMethod;//���͵Ŀ��
	private String orderName;//��������Ʒ����
	private double orderPrice;//������Ǯ
	private String orderDesc;//������ע
	private String time;//�µ�ʱ��
	
	public Order() {
		super();
	}

	public Order(int typeId, String orderName ,String receiver, String phone, String address, String sentMethod, double orderPrice,
			String orderDesc) {
		super();
		this.typeId = typeId;
		this.orderName = orderName;
		this.receiver = receiver;
		this.phone = phone;
		this.address = address;
		this.sentMethod = sentMethod;
		this.orderPrice = orderPrice;
		this.orderDesc = orderDesc;
	}

	public Order(int typeId, String receiver, String phone, String address, String sentMethod, String orderName,
			double orderPrice, String orderDesc, String time) {
		super();
		this.typeId = typeId;
		this.receiver = receiver;
		this.phone = phone;
		this.address = address;
		this.sentMethod = sentMethod;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderDesc = orderDesc;
		this.time = time;
	}

	public Order(int orderId, int typeId, String receiver, String phone, String address, String sentMethod,
			String orderName, double orderPrice, String orderDesc) {
		super();
		this.orderId = orderId;
		this.typeId = typeId;
		this.receiver = receiver;
		this.phone = phone;
		this.address = address;
		this.sentMethod = sentMethod;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderDesc = orderDesc;
	}

	public Order(int orderId, int typeId, String receiver, String phone, String address, String sentMethod,
			String orderName, double orderPrice, String orderDesc, String time) {
		super();
		this.orderId = orderId;
		this.typeId = typeId;
		this.receiver = receiver;
		this.phone = phone;
		this.address = address;
		this.sentMethod = sentMethod;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderDesc = orderDesc;
		this.time = time;
	}

	public Order(int orderId,int typeId, String orderPhone, String orderRecevie, String orderAddress, String orderName, String orderMethod) {
		this.orderId = orderId;
		this.typeId = typeId;
		this.phone = orderPhone;
		this.receiver = orderRecevie;
		this.address = orderAddress;
		this.orderName = orderName;
		this.sentMethod = orderMethod;
	}

	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSentMethod() {
		return sentMethod;
	}


	public void setSentMethod(String sentMethod) {
		this.sentMethod = sentMethod;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public double getOrderPrice() {
		return orderPrice;
	}


	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}


	public String getOrderDesc() {
		return orderDesc;
	}


	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", typeId=" + typeId + ", receiver=" + receiver + ", phone=" + phone
				+ ", address=" + address + ", sentMethod=" + sentMethod + ", orderName=" + orderName + ", orderPrice="
				+ orderPrice + ", orderDesc=" + orderDesc + ", time=" + time + "]";
	}
	

	

	
}
