package org.stock;

public interface Consts {

	public static final String TOP_MENU_ID = "top";
		
	public static final String SS_SUFFIX = ".ss";	// 上市
	public static final String SZ_SUFFIX = ".sz";	// 深市
	
	public static final int ANALYTIC_DAY = 15;		// 分析天数
	public static final int SS_MAX = 601999;		// 沪市最大股票代码
	public static final int SZ_MAX = 1002566;		// 深市最大股票代码
	public static final int SBM_MAX = 300187;		// 创业板最大股票代码
	
	public static final int GAP = 30;				// 并发间隙
}
