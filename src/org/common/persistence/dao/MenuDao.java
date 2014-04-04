package org.common.persistence.dao;

import java.util.List;

import org.common.persistence.domain.SysMenu;
import org.friut.web.persistence.dao.AuthDao;

public class MenuDao extends AuthDao<SysMenu> {
	
	private static final String MENU_ID = "menuId";
	private static final String PARENT_ID = "parentId";
	
	/**
	 * Select menus by parentId
	 * 
	 * @param parentId
	 * @return
	 */
	public List<SysMenu> selectByParentId(String parentId) {
		List<SysMenu> menus = selectListByProperty(PARENT_ID, parentId);
		return menus;
	}
	
	/**
	 * Select menu by menuId
	 * 
	 * @param menuId
	 * @return
	 */
	public SysMenu selectByMenuId(String menuId) {
		List<SysMenu> menus = selectListByProperty(MENU_ID, menuId);
		return menus.isEmpty() ? null : menus.get(0);
	}
}
