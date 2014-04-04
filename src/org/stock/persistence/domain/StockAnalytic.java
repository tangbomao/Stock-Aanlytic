package org.stock.persistence.domain;

import java.io.Serializable;

public class StockAnalytic implements Serializable{

	private static final long serialVersionUID = -7007027900534052796L;
	
	private String stockName;		// 股票代码
	private Integer volume;			// 成交量
	private Integer totalVolume;	// 总成交量
	private Double relative;		// 昨日量比
	private Double relativePlus;	// 平均量量比系数
	private Integer riseDay;		// 多方占优天数
	private Integer analyticDay;	// 总分析天数
	private Double riseDayPlus;		// 平均多方占比系数

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}

	public Double getRelative() {
		return relative;
	}

	public void setRelative(Double relative) {
		this.relative = relative;
	}

	public Double getRelativePlus() {
		return relativePlus;
	}

	public void setRelativePlus(Double relativePlus) {
		this.relativePlus = relativePlus;
	}

	public Integer getRiseDay() {
		return riseDay;
	}

	public void setRiseDay(Integer riseDay) {
		this.riseDay = riseDay;
	}

	public Integer getAnalyticDay() {
		return analyticDay;
	}

	public void setAnalyticDay(Integer analyticDay) {
		this.analyticDay = analyticDay;
	}

	public Double getRiseDayPlus() {
		return riseDayPlus;
	}

	public void setRiseDayPlus(Double riseDayPlus) {
		this.riseDayPlus = riseDayPlus;
	}

}