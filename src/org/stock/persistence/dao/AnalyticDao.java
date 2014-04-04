package org.stock.persistence.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.friut.web.persistence.dao.AuthDao;
import org.hibernate.Session;
import org.stock.persistence.domain.StockAnalytic;

public class AnalyticDao extends AuthDao<StockAnalytic> {
	
	/**
	 * 根据量比分析
	 * 
	 * @return
	 */
	public List<StockAnalytic> selectByRelative(double relative, double relativePlus, double riseDayPlus) {
		String SQL = "FROM StockAnalytic as s WHERE s.relativePlus > " + relativePlus
				+ " AND s.riseDayPlus > " + riseDayPlus + " ORDER BY s.riseDay DESC";
		List<StockAnalytic> list = super.selectListByHSQL(SQL);
		return list;
	}
	
	/**
	 * Delete all analytic data
	 */
	public void deleteAll() {
		String SQL = "DELETE FROM stock_analytic";

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
