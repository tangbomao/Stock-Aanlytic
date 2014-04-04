package org.common.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebInitServlet extends HttpServlet {

	private static final long serialVersionUID = 2301969456004930999L;

	private static final Logger LOG = LoggerFactory.getLogger(WebInitServlet.class);
	
	public void init() throws ServletException {
		
		LOG.info("Web initializing success.");
	}
}
