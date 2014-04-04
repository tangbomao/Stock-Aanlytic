package org.common.web.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.common.persistence.dao.MenuDao;
import org.common.persistence.domain.SysMenu;
import org.common.web.vo.ExtCombo;
import org.common.web.vo.MenuNode;
import org.friut.context.AppContext;
import org.stock.Consts;
import org.stock.contet.WebContext;

import com.google.gson.Gson;

public class MenuService {
	
	protected MenuDao menuDao = (MenuDao) AppContext.getBean(WebContext.MENU_DAO);
	
	/**
	 * Save or update
	 * 
	 * @param sysMenu
	 */
	public void saveOrUpdate(SysMenu sysMenu) {
		menuDao.saveOrUpdate(sysMenu);
	}
	
	/**
	 * Select
	 * 
	 * @param menuId
	 * @return
	 */
	public SysMenu select(Serializable id) {
		return menuDao.select(id);
	}
	
	/**
	 * Select
	 * 
	 * @param menuId
	 * @return
	 */
	public SysMenu selectByMenuId(String menuId) {
		return menuDao.selectByMenuId(menuId);
	}
	
	/**
	 * Select by keyword
	 * 
	 * @param propertyNames
	 * @param value
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<SysMenu> selectByKeyword(String[] propertyNames, Object value, int start, int limit) {
		return menuDao.selectListByKeyword(propertyNames, value, start, limit);
	}
	
	/**
	 * Total count
	 * 
	 * @return
	 */
	public int totalCount(String[] propertyNames, Object keyword) {
		return menuDao.totalCount(propertyNames, keyword);
	}
	
	/**
	 * Delete
	 * 
	 * @param sysMenu
	 */
	public void delete(SysMenu sysMenu) {
		menuDao.delete(sysMenu);
	}
	
	/**
	 * Menu tree
	 */
	public String menuTree(String parentId) {
		List<MenuNode> menus = new ArrayList<MenuNode>();
		List<SysMenu> topSysMenus = menuDao.selectByParentId(parentId);
		for (SysMenu topSysMenu : topSysMenus) {
			MenuNode node = generateNode(topSysMenu);
			menus.add(node);
		}

		return new Gson().toJson(menus);
	}
	
	/**
	 * Menu combo
	 */
	@SuppressWarnings("deprecation")
	public String menuCombo() {
		List<ExtCombo> combos = new ArrayList<ExtCombo>();
		// Add top menu combo data
		combos.add(new ExtCombo(Consts.TOP_MENU_ID, "Top Menu"));
		
		List<SysMenu> allMenus = menuDao.selectAll();
		for (SysMenu sysMenu : allMenus) {
			combos.add(new ExtCombo(sysMenu));
		}

		return new Gson().toJson(combos);
	}

	/**
	 * Get top SysMenus
	 */
	public List<SysMenu> getTopMenus() {
		return menuDao.selectByParentId(Consts.TOP_MENU_ID);
	}
	
	/**
	 * Generate menu node
	 * 
	 * @param sysMenu
	 * @return
	 */
	private MenuNode generateNode(SysMenu sysMenu) {
		MenuNode node = new MenuNode(sysMenu);
		List<SysMenu> childList = menuDao.selectByParentId(sysMenu.getMenuId());
		for (SysMenu childMenu : childList) {
			MenuNode childNode = generateNode(childMenu);
			node.addChildNode(childNode);
		}
		return node;
	}
}
