package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import login.dao.MemberDAO;
import login.vo.MemberVO;

public class MemberDAOTest {

	public MemberDAOTest() {
	}

	//@Test
	public void insertTest() {
		assertEquals(1, new MemberDAO().insert(new MemberVO("aaaa", "1111")));
	}
	@Test
	public void updateTest() throws SQLException{
		assertEquals(1, new MemberDAO().update(new MemberVO()));
	}


	// @Test
	public void deleteTest() throws SQLException {
		assertEquals(1, new MemberDAO().delete(121));
	}

	// @Test
	public void existTest() {
		assertTrue(new MemberDAO().exist("rysdne1"));
	}

	// @Test
	public void findOneTest() {
		assertNotNull(new MemberDAO().findOne("rysdne1"));
	}

	//@Test
	public void memberCountTest() throws ClassNotFoundException, SQLException {
		
		Connection conn;
		PreparedStatement pstmt;
		
		int cnt = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
		try {
			String sql = "select count(*) from member";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("count(*)");
			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
		}finally {
			System.out.println(cnt);
		}
		assertNotEquals(0,new MemberDAO().memberCount());
	}


}
