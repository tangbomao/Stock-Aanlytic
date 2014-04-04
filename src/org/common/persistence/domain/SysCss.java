package org.common.persistence.domain;

import java.io.Serializable;

public class SysCss implements Serializable {

	private static final long serialVersionUID = -2305980202145056524L;
	
	private int cssId;
	private int type;
	private String css;
	private String text;

	public int getCssId() {
		return cssId;
	}

	public void setCssId(int cssId) {
		this.cssId = cssId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}