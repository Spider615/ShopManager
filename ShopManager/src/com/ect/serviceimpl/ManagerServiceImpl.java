package com.ect.serviceimpl;

import com.etc.dao.ManagerDao;

import com.etc.daoimpl.ManagerDaoImpl;
import com.etc.entity.Manager;
import com.etc.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{

	private ManagerDao mg=new ManagerDaoImpl();
	@Override
	public Manager dologin(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return mg.dologin(userName,userPwd);
	}

	@Override
	public boolean register(Manager manager) {
		// TODO Auto-generated method stub
		return mg.register(manager);
	}

}
