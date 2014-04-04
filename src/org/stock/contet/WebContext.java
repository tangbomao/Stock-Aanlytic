package org.stock.contet;

/**
 * Spring context key
 * 
 * @author Tang
 */
public class WebContext {
	
	public static int downloadCount = 0;
	public static int analyticCount = 0;
	public static int downloadTotalCount = 2500;
	public static int analyticTotalCount = 0;
	public static int downloadState = 0;
	
	// Transaction
	public static final String TRANSACTION_MANAGER = "txManager";
	public static final String TRANSACTION_TEMPLATE = "txTemplate";
	
	public static final String TASK_MANAGER_SERVICE = "taskManagerService";
	
	// DAO
	public static final String MENU_DAO = "menuDao";
	public static final String STOCK_DATA_DAO = "stockDataDao";
	public static final String ANALYTIC_DAO = "analyticDao";
	
	// SERVICE
	public static final String MENU_SERVICE = "menuService";
	public static final String STOCK_SERVICE = "stockService";
	public static final String ANALYTIC_SERVICE = "analyticService";
}
