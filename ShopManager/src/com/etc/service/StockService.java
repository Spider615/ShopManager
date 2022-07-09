package com.etc.service;

import java.util.List;

import com.etc.entity.Stock;

public interface StockService {
			//��ӿ��
			boolean addStock(Stock stock);
			//�������Ʋ�ѯ��Ʒ���
			Stock getStockByName(String shopName);
			//��ѯȫ����Ʒ���
			List<Stock> StockAll();
			//�޸�
			boolean modifiSock(Stock stock);
			//ɾ��
			boolean deleteStock(String shopName);
			//��ѯ����
			int countAll();
			//��ҳ��ѯ
			List<Stock> ListStockByPage(int pageIndex,int pageSize);
}
