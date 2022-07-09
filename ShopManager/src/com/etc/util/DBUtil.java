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
	
	//��ȡ���ݿ�����
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
	
	//Ԥ���뼰��ֵ
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
	
	//ͨ����ɾ�ķ���
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
	
	//��ͨ��ѯ
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
	
	//��ѯ������¼
	public static Object getFirst(String sql,Class clazz,Object...prams) {
		List<Object> list=(List<Object>) selectList(sql, clazz, prams);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	
	//�ͷ���Դ
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
	
	//��ѯ�������ת��(��ϵ�����ݿ�ת����java�е����������)
	public static Object convert(ResultSet rs,Class clazz) {
		try {
			//getName ���� �����˰������Ľṹ����
			if(clazz.getName().equals("java.lang.Object")) {
				return rs.getObject(1);
			}
			//����ʵ�����ʵ��������class�����ķ���������ָ�������ʵ��
			Object obj=clazz.newInstance();
			//��ȡ�����ͷ��Ϣ����
			//rs.getMetaData()�÷������Ի�ȡ��resultSet�Ķ�����б�ţ����ͣ�����
			ResultSetMetaData metaData=rs.getMetaData();
			//ѭ������Ϊʵ�����������Ը�ֵ��getColumnCount��ȡ�����еĸ���
			for(int i=1;i<=metaData.getColumnCount();i++) {
				String name=metaData.getColumnLabel(i);//��ȡ����
				BeanUtils.setProperty(obj, name, rs.getObject(i));//��ֵ
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
