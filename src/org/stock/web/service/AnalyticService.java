package org.stock.web.service;

import java.util.List;

import org.friut.context.AppContext;
import org.stock.contet.WebContext;
import org.stock.persistence.dao.AnalyticDao;
import org.stock.persistence.domain.StockAnalytic;

public class AnalyticService {

	protected AnalyticDao analyticDao = (AnalyticDao) AppContext.getBean(WebContext.ANALYTIC_DAO);
	
	public void save(StockAnalytic domain) {
		analyticDao.saveOrUpdate(domain);
	}
	
	public List<StockAnalytic> selectByRelative (double relative, double relativePlus, double riseDayPlus) {
		return analyticDao.selectByRelative(relative, relativePlus, riseDayPlus);
	}
	
	public void deleteAll() {
		analyticDao.deleteAll();
	}
}
