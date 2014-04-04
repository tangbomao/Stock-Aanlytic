package org.stock.persistence.domain;

import java.io.Serializable;

public class StockData implements Serializable {

	private static final long serialVersionUID = -4610767244030775513L;
	
	private Integer recordId;
	private String code;
	private Long datetime;
	private Double open;
	private Double close;
	private Double high;
	private Double low;
	private Double adj;
	private Integer volume;			// 成交量（单位：万手）
	private Boolean rise;			// 是否多方占优，1多0空

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getDatetime() {
		return datetime;
	}

	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getAdj() {
		return adj;
	}

	public void setAdj(Double adj) {
		this.adj = adj;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Boolean getRise() {
		return rise;
	}

	public void setRise(Boolean rise) {
		this.rise = rise;
	}
}