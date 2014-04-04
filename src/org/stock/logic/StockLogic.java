package org.stock.logic;

import java.util.concurrent.TimeUnit;

import org.friut.context.AppContext;
import org.friut.util.DateUtils;
import org.stock.Consts;
import org.stock.contet.WebContext;
import org.stock.schedule.task.StockAnalyticTask;
import org.stock.schedule.task.StockSingleLoadTask;

import com.arthur.service.TaskManagerService;

/**
 * Stock logic
 * 
 * @author Tang
 */
public enum StockLogic {
	
	INSTANCE;
	
	private TaskManagerService taskManagerService = (TaskManagerService) AppContext.getBean(WebContext.TASK_MANAGER_SERVICE);
	
	/**
	 * Load entrance
	 */
	public void download() {
		// Calculate need download date
		long now = System.currentTimeMillis();
		String fromDate = DateUtils.formatTime(now - 86400000L * Consts.ANALYTIC_DAY, "yyyy-MM-dd");
		String toDate = DateUtils.formatTime(now, "yyyy-MM-dd");
		
		taskManagerService.schedule(new StockSingleLoadTask(300000, Consts.SZ_SUFFIX, fromDate, toDate), 0, TimeUnit.SECONDS);
	}
	
	/**
	 * Analytic stock data
	 */
	public void analytic() {
		taskManagerService.schedule(new StockAnalyticTask(), 0, TimeUnit.SECONDS);
	}
}
