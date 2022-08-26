package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttribute;

import login.vo.LoginVO;

@Repository
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

	@Override
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

	@Override
	public LoginVO findId(String email) {

		try {
			String sql = "select * from wTestID where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet exist = pstmt.executeQuery();
			LoginVO result = new LoginVO();
			if (exist.next()) {
				result.setId(exist.getString("id"));
			} else {
				result.setId("");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LoginVO findPw(String id, String email) {

		try {
			String sql = "select * from wTestID where id=? and email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			ResultSet exist = pstmt.executeQuery();
			LoginVO result = new LoginVO();
			if (exist.next()) {
				result.setId(exist.getString("id"));
			} else {
				result.setId("");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int pwReset(String id, String password) {
		try {
			String sql = "update wTestID set password=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int regId(String id, String password, String email) {
		int result = 0;
		try {
			String sql = "select * from wTestID where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet exist = pstmt.executeQuery();

			if (exist.next()) {
				result = 0;
			} else {
				sql = "insert into wTestID values(wTestID_uidx_seq.nextval,?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				pstmt.setString(3, email);
				result = pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
