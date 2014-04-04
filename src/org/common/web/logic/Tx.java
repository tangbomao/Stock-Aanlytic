package org.common.web.logic;

import org.common.persistence.domain.SysMenu;
import org.common.web.service.MenuService;
import org.friut.context.AppContext;
import org.stock.contet.WebContext;

public enum Tx {

	INSTANCE;
	
	protected MenuService menuService = (MenuService) AppContext.getBean(WebContext.MENU_SERVICE);
	
	/**
	 * Create system menu
	 * 
	 * @param menuId
	 * @param parentId
	 * @param text
	 * @param iconCls
	 */
	public void createSysMenu(final String menuId, final String parentId, final String text, final String iconCls) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setMenuId(menuId);
		sysMenu.setParentId(parentId);
		sysMenu.setText(text);
		sysMenu.setQtip(text);
		sysMenu.setIconCls(iconCls);
		menuService.saveOrUpdate(sysMenu);
	}
}
