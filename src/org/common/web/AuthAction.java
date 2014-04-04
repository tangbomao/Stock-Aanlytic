package org.common.web;

import org.common.persistence.dao.MenuDao;
import org.common.web.service.MenuService;
import org.friut.app.extjs.ExtMessage;
import org.friut.context.AppContext;
import org.friut.web.action.AbstractAuthAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stock.contet.WebContext;
import org.stock.web.service.AnalyticService;
import org.stock.web.service.StockService;

import com.google.gson.Gson;

/**
 * Auth action
 * 
 * @author Tang
 * @since 2013.10.31
 * @version 1.0 beta
 */
public abstract class AuthAction extends AbstractAuthAction{
	
	private static final long serialVersionUID = 5713979089850405834L;
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthAction.class);
	
	protected MenuService menuService = (MenuService) AppContext.getBean(WebContext.MENU_SERVICE);
	protected StockService stockService = (StockService) AppContext.getBean(WebContext.STOCK_SERVICE);
	protected AnalyticService analyticService = (AnalyticService) AppContext.getBean(WebContext.ANALYTIC_SERVICE);
	protected MenuDao menuDao = (MenuDao) AppContext.getBean(WebContext.MENU_DAO);
	
	/**
	 * Require parameters
	 * 
	 * @param args
	 */
	@Override
	protected boolean requireParameters(String... args) {
		for (String parameter : args) {
			if (!getRequest().getParameterMap().containsKey(parameter)) {
				LOG.error("Required parameter invalid. {}", parameter);
				// Send data
				ExtMessage message = new ExtMessage(true, "Required parameter invalid : " + parameter);
				super.sendJsonResponse(new Gson().toJson(message));
				return false;
			}
		}
		return true;
	}
	
	protected int page = 1;
	protected int start = 0;
	protected int limit = 10;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
