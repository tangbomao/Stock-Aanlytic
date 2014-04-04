package org.stock.web.action;

import java.util.List;

import org.common.web.AuthAction;
import org.common.web.vo.ExtPagingData;
import org.common.web.vo.ExtStock;
import org.stock.contet.WebContext;
import org.stock.logic.StockLogic;
import org.stock.persistence.domain.StockAnalytic;

import com.google.gson.Gson;

/**
 * Stock Action
 * 
 * @author Tang
 */
public class StockAction extends AuthAction {

	private static final long serialVersionUID = 3648341595172075982L;
	
	/**
	 * Download stock data
	 * 
	 * @throws Exception
	 */
	public void download() throws Exception {
		stockService.deleteAll();
		StockLogic.INSTANCE.download();
		
		
		String json = "Begin to dwonload stock data...";
		// Send data
		super.sendJsonResponse(json);
	}
	
	/**
	 * Analytic
	 * 
	 * @throws Exception
	 */
	public void analytic() throws Exception {
		analyticService.deleteAll();
		StockLogic.INSTANCE.analytic();
		
		String json = "Begin to analytic stock data...";
		// Send data
		super.sendJsonResponse(json);
	}
	
	/**
	 * Download state
	 * 
	 * @throws Exception
	 */
	public void downloadState() throws Exception {
		ExtStock extMessage = new ExtStock(true, WebContext.downloadCount, WebContext.downloadTotalCount);
		
		// Send data
		super.sendJsonResponse(new Gson().toJson(extMessage));
	}
	
	/**
	 * Analytic state
	 * 
	 * @throws Exception
	 */
	public void analyticState() throws Exception {
		ExtStock extMessage = new ExtStock(true, WebContext.analyticCount, WebContext.analyticTotalCount);
		
		// Send data
		super.sendJsonResponse(new Gson().toJson(extMessage));
	}
	
	/**
	 * Load stock result data
	 * 
	 * @throws Exception
	 */
	public void result() throws Exception {
		String relative = getRequest().getParameter("relativePlus");
		String rise = getRequest().getParameter("riseDayPlus");
		double relativePlus = Double.parseDouble(relative);
		double riseDayPlus = Double.parseDouble(rise);
		
		List<StockAnalytic> codes = analyticService.selectByRelative(0.0, relativePlus, riseDayPlus);
		ExtPagingData<StockAnalytic> list = new ExtPagingData<StockAnalytic>(true, codes.size(), codes);
		
		// Send data
		String json = new Gson().toJson(list);
		super.sendJsonResponse(json);
	}
	
	/**
	 * Sync stock codes
	 * 
	 * @throws Exception
	 */
	public void syncCode() throws Exception {
		List<String> codes = stockService.selectAllCode();
		String json = new Gson().toJson(codes);
		
		// Send data
		super.sendJsonResponse(json);
	}
}
