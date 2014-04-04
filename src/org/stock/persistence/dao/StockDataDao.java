package org.stock.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.friut.web.persistence.dao.AuthDao;
import org.hibernate.Session;
import org.stock.persistence.domain.StockData;

public class StockDataDao extends AuthDao<StockData> {
	
	private static final String CODE = "code";
	
	/**
	 * Select by stock code. </br>
	 * 
	 * @param code
	 * @return {@link StockData} list
	 */
	public List<StockData> selectByCode(String code) {
		String[] propertyNames = {CODE};
		Object[] values = {code};
		List<StockData> list = selectListByPropertys(propertyNames, values);
		return list;
	}
	
	/**
	 * Select all distinct codes
	 * 
	 * @return
	 */
	public List<String> selectAllCode() {
		String SQL = "SELECT DISTINCT CODE FROM stock_data ORDER BY code ASC";

		Session session = super.getSession();
		Connection connection = session.connection();
		Statement statement;
		ResultSet rs = null;
		
		List<String> codes = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			connection.commit();
			while (rs.next()) {
				codes.add(rs.getString(1));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return codes;
	}
	
	/**
	 * Delete all data
	 */
	public void deleteAll() {
		String SQL = "DELETE FROM stock_data";

		Session session = super.getSession();
		Connection connection = session.connection();
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(SQL);
			connection.commit();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
