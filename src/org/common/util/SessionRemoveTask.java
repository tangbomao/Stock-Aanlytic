package org.common.util;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arthur.app.Task;

/**
 * Session remove task
 * 
 * @author Tang
 */
public class SessionRemoveTask implements Task {

	private static final Logger LOG = LoggerFactory.getLogger(SessionRemoveTask.class);
	
	private String taskId = "session_remove";
	
	private HttpSession session;
	
	public SessionRemoveTask(HttpSession session) {
		this.session = session;
	}
	
	@Override
	public void run() {
		session.removeAttribute("tipMessage");
		
		LOG.info("Session remove.");
	}

	@Override
	public String getTaskId() {
		return taskId;
	}

	@Override
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
}
