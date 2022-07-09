package com.etc.controller;

import com.etc.dao.ManagerDao;
import com.etc.daoimpl.ManagerDaoImpl;
import com.etc.entity.Manager;

public class test {
public static void main(String[] args) {
	ManagerDao manager=new ManagerDaoImpl();
//	Manager m = manager.dologin("zch","123");
//	System.out.println(m.toString());
	Manager m = new Manager("rr","qrrwe");
	boolean re = manager.register(m);
	System.out.println(re);
}
}
