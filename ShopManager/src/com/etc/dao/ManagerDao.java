package com.etc.dao;

import com.etc.entity.Manager;


public interface ManagerDao {
	//��¼
	public Manager dologin(String userName,String userPwd);
	//ע��
	public boolean register(Manager manager);
}
