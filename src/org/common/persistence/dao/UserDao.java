package org.common.persistence.dao;

import java.util.List;

import org.common.persistence.domain.User;
import org.friut.web.persistence.dao.AuthDao;

public class UserDao extends AuthDao<User> {
	
	private static final String ACCOUNT = "account";
	private static final String PASSWORD = "password";
	
	/**
	 * Login by account and password. </br>
	 * If login success return {@link User}
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public User login(String account, String password) {
		String[] propertyNames = {ACCOUNT, PASSWORD};
		String[] values = {account, password};
		List<User> users = selectListByPropertys(propertyNames, values);
		return users.isEmpty() ? null : users.get(0);
	}
	
	/**
	 * Check account contains. </br>
	 * If contains return true, else false.
	 * 
	 * @param account
	 * @return
	 */
	public boolean checkAccountContains(String account) {
		List<User> users = selectListByProperty(ACCOUNT, account);
		return !users.isEmpty();
	}
	
	/**
	 * Select. 
	 * 
	 * @param account
	 * @return
	 */
	public User selectByAccount(String account) {
		List<User> users = selectListByProperty(ACCOUNT, account);
		return users.isEmpty() ? null : users.get(0);
	}
}
