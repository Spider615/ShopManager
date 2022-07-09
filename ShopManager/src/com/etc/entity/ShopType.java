package com.etc.entity;

public class ShopType {
	private int typeId;
	private String typeName;
	
	public ShopType(String typeName) {
		super();
		this.typeName = typeName;
	}
	public ShopType() {
		super();
	}
	public ShopType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "ShopType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
	
}
