package org.stock.schedule.task;

import java.util.ArrayList;
import java.util.List;

import org.friut.context.AppContext;
import org.friut.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stock.contet.WebContext;
import org.stock.persistence.domain.StockData;
import org.stock.util.YahooStockUtils;
import org.stock.vo.YahooStockData;
import org.stock.web.service.StockService;

import com.arthur.app.Task;

public class StockLoadTask implements Task {
	
	private static final Logger LOG = LoggerFactory.getLogger(StockLoadTask.class);
	
	private static StockService stockService = (StockService) AppContext.getBean(WebContext.STOCK_SERVICE);
	
	private String taskId = "stock_load_task";
	
	private final String suffix;
	private final int startCode;
	private final int endCode;
	private final String fromDate;
	private final String toDate;
	
	public StockLoadTask(final int startCode, final int endCode, final String suffix, final String fromDate, final String toDate) {
		this.suffix = suffix;
		this.startCode = startCode;
		this.endCode = endCode;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	@Override
	public void run() {
		LOG.info("Begin to loading stock data. form {} to {}", startCode, endCode);
		
		// Data list
		List<StockData> list = new ArrayList<StockData>();
		
		// For each code
		for (int code = startCode; code <= endCode; code++) {
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
			
			LOG.info("{} has loaded. contains {} items.", stockName, yahoodata.size());
		}
		
		// Save data
		stockService.saveList(list);
		LOG.info("End of loading stock data. form {} to {}", startCode, endCode);
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
