package com.etc.service;

import com.etc.entity.Manager;

public interface ManagerService {
	//��¼
		public Manager dologin(String userName,String userPwd);
		//ע��
		public boolean register(Manager manager);
}
