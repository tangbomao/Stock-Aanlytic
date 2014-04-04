package org.stock.contet;

/**
 * 这是语言控制，方便进行国际化
 * 
 * @author Tang
 */
public final class Locale {
	
	// 防止被实例化
	private Locale() {

	}
	
	// Error message
	public static final String MsgErrorLogin     = "登录失败";

	// Success message
	public static final String MsgSuccessLogout  = "注销成功";
	public static final String MsgSuccessLogin   = "登录成功";

	// Tip message
	public static final String TipNotLogIntecpt  = "您还没有登录，请登录系统";

}
