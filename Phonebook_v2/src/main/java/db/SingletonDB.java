package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 개선 필요
public class SingletonDB {

	// private : 반드시 함수를 통해 호출해야 확인할 수 있
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		} else {
			Context initContext = null;

			try {

				initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comm");
				DataSource ds = (DataSource) envContext.lookup("jdbc:oracle");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return conn;

	}
}
