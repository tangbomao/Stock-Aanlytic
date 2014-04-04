package org.stock.schedule.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.friut.context.AppContext;
import org.friut.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stock.Consts;
import org.stock.contet.WebContext;
import org.stock.persistence.domain.StockData;
import org.stock.util.YahooStockUtils;
import org.stock.vo.YahooStockData;
import org.stock.web.service.StockService;

import com.arthur.app.Task;
import com.arthur.service.TaskManagerService;

public class StockSingleLoadTask implements Task {
	
	private static final Logger LOG = LoggerFactory.getLogger(StockSingleLoadTask.class);
	
	private TaskManagerService taskManagerService = (TaskManagerService) AppContext.getBean(WebContext.TASK_MANAGER_SERVICE);
	
	private static StockService stockService = (StockService) AppContext.getBean(WebContext.STOCK_SERVICE);
	
	private String taskId = "stock_single_load_task";
	
	private final String suffix;
	private final int code;
	private final String fromDate;
	private final String toDate;
	
	public StockSingleLoadTask(final int code, final String suffix, final String fromDate, final String toDate) {
		this.suffix = suffix;
		this.code = code;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	@Override
	public void run() {
		// Data list
		List<StockData> list = new ArrayList<StockData>();
		
		// For each code
		String stockName = code + suffix;
		if (code >= 1000000) {
			stockName = stockName.substring(1, stockName.length());
		}
		
		List<YahooStockData> yahoodata = YahooStockUtils.getStockCsvData(stockName, fromDate, toDate);
		
		// Add to list
		for (YahooStockData data : yahoodata) {
			StockData stockData = new StockData();
			stockData.setOpen(data.getOpen());
			stockData.setClose(data.getClose());
			stockData.setLow(data.getLow());
			stockData.setHigh(data.getHigh());
			stockData.setAdj(data.getAdj());
			stockData.setCode(stockName);
			stockData.setDatetime(DateUtils.parseTime(data.getDate()));
			stockData.setVolume(data.getVolume() / 100);
			stockData.setRise(data.getClose() > data.getOpen());
			
			list.add(stockData);
		}
		
		// Count++
		if (!list.isEmpty()) {
			WebContext.downloadCount++;
		}
		
		// Save data
		stockService.saveList(list);
		LOG.info("{} has loaded. contains {} items.", stockName, yahoodata.size());
		
		if (code < Consts.SBM_MAX) {
			taskManagerService.schedule(new StockSingleLoadTask(code + 1, Consts.SZ_SUFFIX, fromDate, toDate), 0, TimeUnit.SECONDS);
		} else if (code < Consts.SS_MAX) {
			if (code < 600000) {
				taskManagerService.schedule(new StockSingleLoadTask(600000, Consts.SS_SUFFIX, fromDate, toDate), 0, TimeUnit.SECONDS);
			} else {
				taskManagerService.schedule(new StockSingleLoadTask(code + 1, Consts.SS_SUFFIX, fromDate, toDate), 0, TimeUnit.SECONDS);
			}
		} else if (code < Consts.SZ_MAX) {
			if (code < 1000000) {
				taskManagerService.schedule(new StockSingleLoadTask(1000000, Consts.SZ_SUFFIX, fromDate, toDate), 0, TimeUnit.SECONDS);
			} else {
				taskManagerService.schedule(new StockSingleLoadTask(code + 1, Consts.SZ_SUFFIX, fromDate, toDate), 0, TimeUnit.SECONDS);
			}
		} else {
			// END...
			WebContext.downloadState = 0;
		}
	}
	
	@Override
	public String getTaskId() {
		return taskId;
	}
	
	@Override
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
}
