package com.ect.serviceimpl;

import java.util.List;

import com.etc.dao.SentTypeDao;
import com.etc.daoimpl.SentTypeDaoImpl;
import com.etc.entity.SentType;
import com.etc.service.SentTypeService;

public class SentTypeServiceImpl implements SentTypeService{
	private SentTypeDao st=new SentTypeDaoImpl();
	@Override
	public boolean addSentType(SentType senttype) {
		// TODO Auto-generated method stub
		return st.addSentType(senttype);
	}

	@Override
	public SentType getSentByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return st.getSentByTypeId(typeId);
	}

	@Override
	public boolean modifiSentType(SentType senttype) {
		// TODO Auto-generated method stub
		return st.modifiSentType(senttype);
	}

	@Override
	public boolean deleteType(int typeId) {
		// TODO Auto-generated method stub
		return st.deleteType(typeId);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return st.countAll();
	}

	@Override
	public List<SentType> SentTypeAll() {
		// TODO Auto-generated method stub
		return st.SentTypeAll();
	}

}
