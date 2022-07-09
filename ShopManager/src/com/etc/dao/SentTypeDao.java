package com.etc.dao;

import java.util.List;

import com.etc.entity.SentType;

public interface SentTypeDao {
			//添加快递类型
			boolean addSentType(SentType senttype);
			//根据快递id查询快递类型
			SentType getSentByTypeId(int typeId);
			//修改
			boolean modifiSentType(SentType senttype);
			//删除
			boolean deleteType(int typeId);
			//查询总数
			int countAll();	
			//查询全部快递类型
			List<SentType> SentTypeAll();
}
