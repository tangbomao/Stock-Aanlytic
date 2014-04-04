package org.common.web.vo;


public class ExtStock {

	private boolean success;
	private int currentCount;
	private int totalCount;

	public ExtStock(boolean success, int currentCount, int totalCount) {
		this.success = success;
		this.currentCount = currentCount;
		this.totalCount = totalCount;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
