package org.common.web.vo;

import org.common.persistence.domain.SysCss;
import org.common.persistence.domain.SysMenu;

public class ExtCombo {

	private Object value;
	private Object display;

	public ExtCombo(SysMenu sysMenu) {
		this.value = sysMenu.getMenuId();
		this.display = sysMenu.getText();
	}
	
	public ExtCombo(SysCss sysCss) {
		this.value = sysCss.getCss();
		this.display = sysCss.getText();
	}
	
	public ExtCombo(String value, String display) {
		this.value = value;
		this.display = display;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getDisplay() {
		return display;
	}

	public void setDisplay(Object display) {
		this.display = display;
	}
}
