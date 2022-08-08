package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import login.vo.LoginVO;

public class LoginDAO implements LoginDaoInter {

	Connection conn;
	PreparedStatement pstmt;

	public LoginDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean login(LoginVO vo) {

		try {
			String sql = "select * from wTestID where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
