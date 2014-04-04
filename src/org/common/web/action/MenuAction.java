package org.common.web.action;

import java.util.List;

import org.common.persistence.domain.SysMenu;
import org.common.web.AuthAction;
import org.common.web.ReplyMessage;
import org.common.web.logic.Tx;
import org.common.web.vo.ExtPagingData;
import org.friut.app.extjs.ExtMessage;
import org.stock.contet.RequiredParams;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Menu Action
 * 
 * @author Tang
 */
public class MenuAction extends AuthAction {
	
	private static final long serialVersionUID = -4354521506922572525L;
	
	/**
	 * Menu tree load
	 * 
	 * @throws Exception
	 */
	public void tree() throws Exception {
		requireParameters(RequiredParams.PARENT_ID);
		
		// Get parameters
		String parentId = getRequest().getParameter(RequiredParams.PARENT_ID);
		
		String json = menuService.menuTree(parentId);
				
		// Send data
		super.sendJsonResponse(json);
	}
	
	/**
	 * Menu load
	 * 
	 * @throws Exception
	 */
	public void load() throws Exception {
		String keyword = getRequest().getParameter("keyword");
		
		String[] propertyNames = {RequiredParams.TEXT, RequiredParams.ICON_CLS};
		List<SysMenu> items = menuService.selectByKeyword(propertyNames, keyword, start, limit);
		int totalCount = menuService.totalCount(propertyNames, keyword);
		
		// Generate paging data
		ExtPagingData<SysMenu> data = new ExtPagingData<SysMenu>(true, totalCount, items);
		String json = new Gson().toJson(data);
				
		// Send data
		super.sendJsonResponse(json);
	}
	
	/**
	 * All combo data
	 * 
	 * @throws Exception
	 */
	public void allCombo() throws Exception {
		String json = menuService.menuCombo();
				
		// Send data
		super.sendJsonResponse(json);
	}
	
	/**
	 * Add
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		requireParameters(RequiredParams.MENU_ID, 
				RequiredParams.PARENT_ID, 
				RequiredParams.TEXT);
		
		// Get parameters
		String menuId = getRequest().getParameter(RequiredParams.MENU_ID);
		String parentId = getRequest().getParameter(RequiredParams.PARENT_ID);
		String text = getRequest().getParameter(RequiredParams.TEXT);
		String iconCls = getRequest().getParameter(RequiredParams.ICON_CLS);
		
		// Check menuId
		SysMenu sysMenu = menuService.selectByMenuId(menuId);
		if (sysMenu != null) {
			ExtMessage message = new ExtMessage(false, ReplyMessage.MENU_ID_EXISTED);
			sendJsonResponse(new Gson().toJson(message));
			return;
		}
		
		// Create
		Tx.INSTANCE.createSysMenu(menuId, parentId, text, iconCls);
		
		// Send data
		ExtMessage message = new ExtMessage(true, ReplyMessage.OPERATE_SUCCESS);
		super.sendJsonResponse(new Gson().toJson(message));
	}
	
	/**
	 * Update edit
	 * 
	 * @throws Exception
	 */
	public void edit() throws Exception {
		requireParameters(RequiredParams.ID);
		
		// Get parameters
		int id = Integer.valueOf(getRequest().getParameter(RequiredParams.ID));
		String menuId = getRequest().getParameter(RequiredParams.MENU_ID);
		String parentId = getRequest().getParameter(RequiredParams.PARENT_ID);
		String text = getRequest().getParameter("text");
		String iconCls = getRequest().getParameter("iconCls");
		
		// Check menuId
		SysMenu sysMenu = menuService.select(id);
		if (sysMenu == null) {
			ExtMessage message = new ExtMessage(false, ReplyMessage.MENU_ID_NOT_EXIST);
			sendJsonResponse(new Gson().toJson(message));
			return;
		}
		
		// Update
		sysMenu.setMenuId(menuId);
		sysMenu.setParentId(parentId);
		sysMenu.setText(text);
		sysMenu.setIconCls(iconCls);
		sysMenu.setQtip(text);
		menuService.saveOrUpdate(sysMenu);
		
		// Send data
		ExtMessage message = new ExtMessage(true, ReplyMessage.OPERATE_SUCCESS);
		super.sendJsonResponse(new Gson().toJson(message));
	}

	/**
	 * Save menus
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception {
		requireParameters(RequiredParams.RECORDS);
		// Get parameters
		String records = getRequest().getParameter(RequiredParams.RECORDS);
		// Decode JSON parameters
		List<SysMenu> menus = new Gson().fromJson(records, new TypeToken<List<SysMenu>>(){}.getType());
		
		// Update menus
		for (SysMenu sysMenu : menus) {
			menuService.saveOrUpdate(sysMenu);
		}
		
		// Send data
		ExtMessage message = new ExtMessage(true, ReplyMessage.OPERATE_SUCCESS);
		super.sendJsonResponse(new Gson().toJson(message));
	}
	
	/**
	 * Delete
	 * 
	 * @throws Exception
	 */
	public void delete() throws Exception {
		requireParameters(RequiredParams.MENU_ID);
		
		// Get parameters
		String menuId = getRequest().getParameter("menuId");
		
		// Check menuId
		SysMenu sysMenu = menuService.selectByMenuId(menuId);
		if (sysMenu == null) {
			ExtMessage message = new ExtMessage(false, ReplyMessage.MENU_ID_NOT_EXIST);
			sendJsonResponse(new Gson().toJson(message));
			return;
		}
		
		// Delete
		menuService.delete(sysMenu);
		
		// Send data
		ExtMessage message = new ExtMessage(true, ReplyMessage.OPERATE_SUCCESS);
		super.sendJsonResponse(new Gson().toJson(message));
	}
}
