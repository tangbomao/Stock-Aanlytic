package org.stock.web.service;

import java.util.List;

import org.friut.context.AppContext;
import org.stock.contet.WebContext;
import org.stock.persistence.dao.StockDataDao;
import org.stock.persistence.domain.StockData;

public class StockService {

	protected StockDataDao stockDataDao = (StockDataDao) AppContext.getBean(WebContext.STOCK_DATA_DAO);
	
	public void saveList (List<StockData> list) {
		stockDataDao.saveList(list);
	}
	
	public List<String> selectAllCode () {
		return stockDataDao.selectAllCode();
	}
	
	public List<StockData> selectByCode (String code) {
		return stockDataDao.selectByCode(code);
	}
	
	public void deleteAll() {
		stockDataDao.deleteAll();
	}
}
