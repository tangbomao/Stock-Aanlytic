package org.stock;

import java.util.List;

import org.friut.util.DateUtils;
import org.stock.util.YahooStockUtils;
import org.stock.vo.YahooStockData;

import com.google.gson.Gson;

public class Test {
	public static void main(String[] args){
		List<YahooStockData> sd = YahooStockUtils.getStockCsvData("000001.sz", "2014-01-01", "2014-02-01");
        System.out.println(new Gson().toJson(sd));
        
//        long now = System.currentTimeMillis();
//		String fromDate = DateUtils.formatTime(now - 86400000L * 20, "yyyy-MM-dd");
//		String toDate = DateUtils.formatTime(now, "yyyy-MM-dd");
//		
//		
//		// 加载沪市数据
//		for (int ss = 600000; ss <= 601999; ss++) {
//			String stockName = ss + ".ss";
//			List<YahooStockData> yahoodata = YahooStockUtils.getStockCsvData(stockName, fromDate, toDate);
//			System.out.println(stockName + " has loaded. contains " + yahoodata.size() + " items.");
//		}
    }
	
	/**
	 * Load stock data
	 */
	public static void load() {
		long now = System.currentTimeMillis();
		String fromDate = DateUtils.formatTime(now - 86400000L * 20, "yyyy-MM-dd");
		String toDate = DateUtils.formatTime(now, "yyyy-MM-dd");
		
		
		// 加载沪市数据
		for (int ss = 600000; ss <= 601999; ss++) {
			String stockName = ss + ".ss";
			List<YahooStockData> yahoodata = YahooStockUtils.getStockCsvData(stockName, fromDate, toDate);
			System.out.println(stockName + " has loaded. contains " + yahoodata.size() + " items.");
		}
	}
}
