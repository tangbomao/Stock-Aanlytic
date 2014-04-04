package org.common.persistence.dao;

import java.util.List;

import org.common.persistence.domain.SysCss;
import org.friut.web.persistence.dao.AuthDao;

public class CssDao extends AuthDao<SysCss> {
	
	private static final String CSS = "css";
	
	/**
	 * Select by css
	 * 
	 * @param css
	 * @return
	 */
	public SysCss selectByCss(String css) {
		List<SysCss> list = selectListByProperty(CSS, css);
		return list.isEmpty() ? null : list.get(0);
	}
}
