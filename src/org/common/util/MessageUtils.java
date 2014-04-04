package org.common.util;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.friut.context.AppContext;

import com.arthur.service.TaskManagerService;

public class MessageUtils {
	
	private static TaskManagerService taskManagerService = (TaskManagerService) AppContext.getBean("taskManagerService");
	
	public static void sendTipMessage(HttpSession session, String content) {
		session.setAttribute("tipMessage", content);
		taskManagerService.schedule(new SessionRemoveTask(session), 1, TimeUnit.SECONDS);
	}
}


