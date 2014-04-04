package org.taobook.web.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Authority intercepter
 * 
 * @author Tang
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2816619466758026932L;

	public String intercept(ActionInvocation invocation) throws Exception {
		return invocation.invoke();
	}
}
