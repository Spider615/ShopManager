package com.etc.entity;

public class Stock {
	private  String shopName;
	private int cid;//和商品id连接
	private int importNum;
	private int stockNum;
	
	public Stock() {
		super();
	}

	public Stock(String shopName, int importNum, int stockNum) {
		super();
		this.shopName = shopName;
		this.importNum = importNum;
		this.stockNum = stockNum;
	}

	public Stock(int cid, int importNum, int stockNum) {
		super();
		this.cid = cid;
		this.importNum = importNum;
		this.stockNum = stockNum;
	}

	public Stock(String shopName, int cid, int importNum, int stockNum) {
		super();
		this.shopName = shopName;
		this.cid = cid;
		this.importNum = importNum;
		this.stockNum = stockNum;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getImportNum() {
		return importNum;
	}

	public void setImportNum(int importNum) {
		this.importNum = importNum;
	}

	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	@Override
	public String toString() {
		return "Stock [shopName=" + shopName + ", cid=" + cid + ", importNum=" + importNum + ", stockNum=" + stockNum
				+ "]";
	}

	
	
	
	
	
	
	
}
