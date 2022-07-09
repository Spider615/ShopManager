package com.etc.daoimpl;



import com.etc.dao.ManagerDao;
import com.etc.entity.Manager;

import com.etc.util.DBUtil;

public class ManagerDaoImpl implements ManagerDao{
	DBUtil util=new DBUtil();
	//µÇÂ¼
	@Override
	public Manager dologin(String userName, String userPwd) {
		String sql="select * from manager where userName=? and userPwd=?";
		Manager manager=(Manager)DBUtil.getFirst(sql,Manager.class,userName,userPwd);
		return manager;
	}
	

	//×¢²á
	@Override
	public boolean register(Manager manager) {
		String sql="insert into manager values(null,?,?)";
		boolean result=DBUtil.execUpdate(sql,manager.getUserName(),manager.getUserPwd());
		return result;
	}

	
	
}
