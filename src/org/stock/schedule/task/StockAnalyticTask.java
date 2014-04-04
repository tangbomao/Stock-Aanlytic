package org.stock.schedule.task;

import java.util.List;

import org.friut.context.AppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stock.contet.WebContext;
import org.stock.persistence.domain.StockAnalytic;
import org.stock.persistence.domain.StockData;
import org.stock.web.service.AnalyticService;
import org.stock.web.service.StockService;

import com.arthur.app.Task;

public class StockAnalyticTask implements Task {
	
	private static final Logger LOG = LoggerFactory.getLogger(StockAnalyticTask.class);
	
	private static StockService stockService = (StockService) AppContext.getBean(WebContext.STOCK_SERVICE);
	private static AnalyticService analyticService = (AnalyticService) AppContext.getBean(WebContext.ANALYTIC_SERVICE);
	
	private String taskId = "stock_analytic_task";
	
	public StockAnalyticTask() {
		
	}
	
	@Override
	public void run() {
		List<String> codes = stockService.selectAllCode();
		WebContext.analyticTotalCount = codes.size();
		
		LOG.info("Begin to analytic... total codes count {}", codes.size());
		for (String code : codes) {
			// Select data by code
			List<StockData> list = stockService.selectByCode(code);
			if (list.isEmpty()) {
				LOG.info("Empty of stock data {}", code);
				continue;
			}
			
			// Analytic data
			int totalDay = list.size();
			int riseDay = 0;
			int totalVolume = 0;
			
			long maxTime = 0L;
			StockData currentData = null;
			for (StockData data : list) {
				if (data.getRise()) {
					riseDay++;
				}
				// Total volume
				totalVolume += data.getVolume();
				
				maxTime = Math.max(maxTime, data.getDatetime());
				if (maxTime <= data.getDatetime()) {
					currentData = data;
				}
			}
			
			double relativePlus = (currentData.getVolume() * 1.0) / (totalVolume * 1.0 / totalDay  * 1.0);
			double riseDayPlus = (riseDay * 1.0) / (totalDay * 1.0);
			
			if (currentData.getVolume() == 0) {
				relativePlus = 0.0;
			}
			
			if (riseDay == 0) {
				riseDayPlus = 0.0;
			}
			
			StockAnalytic analytic = new StockAnalytic();
			analytic.setStockName(code);
			analytic.setRelative(0.0);
			analytic.setAnalyticDay(totalDay);
			analytic.setRelativePlus(relativePlus);
			analytic.setRiseDay(riseDay);
			analytic.setRiseDayPlus(riseDayPlus);
			analytic.setTotalVolume(totalVolume);
			analytic.setVolume(currentData.getVolume());
			analyticService.save(analytic);
			
			LOG.info("Stock of {} analyticed, {}", code, (riseDayPlus + ", " + relativePlus));
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
