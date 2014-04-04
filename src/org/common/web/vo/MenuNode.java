package org.common.web.vo;

import java.util.ArrayList;
import java.util.List;

import org.common.persistence.domain.SysMenu;

public class MenuNode {

	private String id;
	private String parentId;
	private String text;
	private String iconCls;
	private String qtip;
	private boolean leaf;
	private List<MenuNode> children = new ArrayList<MenuNode>();

	public MenuNode(SysMenu sysMenu) {
		this.id = sysMenu.getMenuId();
		this.parentId = sysMenu.getParentId();
		this.text = sysMenu.getText();
		this.iconCls = sysMenu.getIconCls();
		this.qtip = sysMenu.getQtip();
		this.leaf = true;
	}
	
	public void addChildNode(MenuNode childNode) {
		children.add(childNode);
		this.leaf = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getQtip() {
		return qtip;
	}

	public void setQtip(String qtip) {
		this.qtip = qtip;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public List<MenuNode> getChildren() {
		return children;
	}

	public void setChildren(List<MenuNode> children) {
		this.children = children;
	}
}
