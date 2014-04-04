package org.common.web.action.interceptor;

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
//		ActionContext ctx = invocation.getInvocationContext();
//		String account = (String) ctx.getSession().get(WebContext.SESSION_ACCOUNT);
//		if (account == null || account.equals("")) {
//			LOG.info("Session out.");
//			return "sessionOut";
//		}
		return invocation.invoke();
	}
}
