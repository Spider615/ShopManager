package com.etc.entity;

public class Shop {
	private int shopId;
	private String shopName;
	private int typeId;	//商品类型
	private double shopPrice;//商品价格
	private int stockNum;//库存(进口减出口)
	private String shopDesc;	//商品描述
	
	public Shop(String shopName, int typeId, double shopPrice, int stockNum, String shopDesc) {
		super();
		this.shopName = shopName;
		this.typeId = typeId;
		this.shopPrice = shopPrice;
		this.stockNum = stockNum;
		this.shopDesc = shopDesc;
	}

	public Shop(int shopId, String shopName, int typeId, double shopPrice, int stockNum, String shopDesc) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.typeId = typeId;
		this.shopPrice = shopPrice;
		this.stockNum = stockNum;
		this.shopDesc = shopDesc;
	}

	public Shop() {
		super();
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", typeId=" + typeId + ", shopPrice=" + shopPrice
				+ ", stockNum=" + stockNum + ", shopDesc=" + shopDesc + "]";
	}
	
	
	


	
	
}
