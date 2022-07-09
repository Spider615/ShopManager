package com.etc.dao;

import com.etc.entity.Manager;


public interface ManagerDao {
	//µÇÂ¼
	public Manager dologin(String userName,String userPwd);
	//×¢²á
	public boolean register(Manager manager);
}
