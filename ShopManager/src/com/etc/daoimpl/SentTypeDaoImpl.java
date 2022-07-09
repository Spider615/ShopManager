package com.etc.daoimpl;

import java.util.List;

import com.etc.dao.SentTypeDao;
import com.etc.entity.SentType;
import com.etc.entity.ShopType;
import com.etc.util.DBUtil;

public class SentTypeDaoImpl implements SentTypeDao{

	//添加快递类型
	@Override
	public boolean addSentType(SentType senttype) {
		String sql="insert into senttype values(null,?)";
		boolean result=DBUtil.execUpdate(sql,senttype.getSentName());
		return result;
	}

	//根据快递id查询快递类型
	@Override
	public SentType getSentByTypeId(int typeId) {
		String sql="select * from senttype where typeId=?";
		SentType senttype=(SentType)DBUtil.getFirst(sql, SentType.class, typeId);
		return senttype;
	}

	//修改
	@Override
	public boolean modifiSentType(SentType senttype) {
		String sql="update senttype set typeId=?,sentName=?";
		boolean result=DBUtil.execUpdate(sql,senttype.getTypeId(),senttype.getSentName(),senttype);
		return result;
	}

	//删除
	@Override
	public boolean deleteType(int typeId) {
		String sql="delete from senttype where typeId=?";
		boolean result=DBUtil.execUpdate(sql, typeId);
		return result;
	}

	//查询总数
	@Override
	public int countAll() {
		String sql="select count(1) from senttype";
		int result=(int)((long)DBUtil.getFirst(sql,Object.class));
		return result;
	}

	//查询全部快递类型
	@Override
	public List<SentType> SentTypeAll() {
		String sql="select * from senttype";
		List<SentType> list=(List<SentType>)DBUtil.selectList(sql,SentType.class);
		return list;
	}

}
