package com.etc.entity;

public class SentType {
	private int typeId;
	private String sentName;
	
	public SentType(String sentName) {
		super();
		this.sentName = sentName;
	}
	public SentType() {
		super();
	}
	public SentType(int typeId, String sentName) {
		super();
		this.typeId = typeId;
		this.sentName = sentName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getSentName() {
		return sentName;
	}
	public void setSentName(String sentName) {
		this.sentName = sentName;
	}
	@Override
	public String toString() {
		return "SentType [typeId=" + typeId + ", sentName=" + sentName + "]";
	}
	
}
