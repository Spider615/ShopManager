package com.etc.dao;

import java.util.List;

import com.etc.entity.SentType;

public interface SentTypeDao {
			//��ӿ������
			boolean addSentType(SentType senttype);
			//���ݿ��id��ѯ�������
			SentType getSentByTypeId(int typeId);
			//�޸�
			boolean modifiSentType(SentType senttype);
			//ɾ��
			boolean deleteType(int typeId);
			//��ѯ����
			int countAll();	
			//��ѯȫ���������
			List<SentType> SentTypeAll();
}
