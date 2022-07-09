package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class DBUtil {
	private final static String CLASSNAME="com.mysql.cj.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost:3306/my1?serverTimezone=UTC";
	private final static String USERNAME="root";
	private final static String USERPWD="root";
	
	//获取数据库链接
	public static Connection getConn() {
		Connection conn=null;
		try {
			Class.forName(CLASSNAME);
			conn=DriverManager.getConnection(URL,USERNAME,USERPWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//预编译及传值
	public static PreparedStatement setPstmt(Connection conn,String sql,Object...prams) {
		PreparedStatement pstmt =null;
		try {
			pstmt =conn.prepareStatement(sql);
			if(prams!=null) {
				for(int i=0;i<prams.length;i++) {
					pstmt.setObject(i+1, prams[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pstmt;
	}
	
	//通用增删改方法
	public static boolean execUpdate(String sql,Object...prams) {
		Connection conn=getConn();
		PreparedStatement pstmt=setPstmt(conn,sql,prams);
		int result =-1;
		try {
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//普通查询
	public static Object selectList(String sql,Class clazz,Object...prams){
		Connection conn=getConn();
		PreparedStatement pstmt=setPstmt(conn, sql, prams);
		ResultSet rs=null;
		List<Object> list=new ArrayList<Object>();
		try {
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Object obj=convert(rs,clazz);
				list.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	//查询单条记录
	public static Object getFirst(String sql,Class clazz,Object...prams) {
		List<Object> list=(List<Object>) selectList(sql, clazz, prams);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	
	//释放资源
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查询结果集的转换(关系型数据库转换到java中的类面向对象)
	public static Object convert(ResultSet rs,Class clazz) {
		try {
			//getName 类名 包含了包完整的结构类型
			if(clazz.getName().equals("java.lang.Object")) {
				return rs.getObject(1);
			}
			//创建实体类的实力。调用class类对象的方法，创建指定对象的实例
			Object obj=clazz.newInstance();
			//获取结果集头信息对象
			//rs.getMetaData()该方法可以获取到resultSet的对象的列编号，类型，属性
			ResultSetMetaData metaData=rs.getMetaData();
			//循环遍历为实体类对象的属性赋值，getColumnCount获取的是列的个数
			for(int i=1;i<=metaData.getColumnCount();i++) {
				String name=metaData.getColumnLabel(i);//获取列名
				BeanUtils.setProperty(obj, name, rs.getObject(i));//赋值
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
