package com.etc.service;

import com.etc.entity.Manager;

public interface ManagerService {
	//µÇÂ¼
		public Manager dologin(String userName,String userPwd);
		//×¢²á
		public boolean register(Manager manager);
}
