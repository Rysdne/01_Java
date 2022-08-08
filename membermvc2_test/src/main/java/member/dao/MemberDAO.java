package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.vo.MemberVO;

public class MemberDAO {

	Connection conn;
	PreparedStatement pstmt;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(MemberVO member) {
		String sql = null;
		int rs = 0;
		try {
			sql = "insert into member values(member_idx_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public List findAll() {
		String sql = null;
		ResultSet rs = null;
		List<MemberVO> list = null;
		try {
			sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setIdx(rs.getInt("idx"));
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				list.add(m);
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 전체 출력 오류");
			e.printStackTrace();
		}
		return list;
	}

	public MemberVO findOne(int idx) {

		String sql = null;
		ResultSet rs = null;

		try {
			sql = "select * from member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				MemberVO m = new MemberVO(rs.getInt("idx"), rs.getString("id"), rs.getString("password"));
				return m;
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 단일 출력 오류");
			e.printStackTrace();
		}
		return null;
	}

	public boolean exist(int idx) {

		if (findOne(idx) != null) {
			return true;
		}
		return false;
	}

	// 있을 경우 수정
	public int update(MemberVO member) throws SQLException {

		String sql = null;
		int rs = 0;

		try {
			if (exist(member.getIdx())) {
				sql = "update member set password=? where idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getPassword());
				pstmt.setInt(2, member.getIdx());
				rs = pstmt.executeUpdate();
				return rs;
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 수정 오류");
			e.printStackTrace();
		}

		return 0;
	}

	// 8. 데이터 삭제
	public int delete(int idx) throws SQLException {

		String sql = null;
		int rs = 0;

		if (exist(idx)) {
			sql = "delete from member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeUpdate();
			return rs;
		}
		return 0;

	}

// ===================================================

	public MemberVO findOne(String id) {

		String sql = null;
		ResultSet rs = null;

		try {
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				MemberVO m = new MemberVO(rs.getInt("idx"), rs.getString("id"), rs.getString("password"));
				return m;
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 단일 출력 오류");
			e.printStackTrace();
		}
		return null;
	}

	public boolean exist(String id) {

		if (findOne(id) != null) {
			return true;
		}
		return false;
	}

	// 있을 경우 수정
	public int updateById(MemberVO member) {
		String sql = null;
		int rs = 0;

		try {
			if (exist(member.getIdx())) {
				sql = "update member set password=? where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getPassword());
				pstmt.setString(2, member.getId());
				rs = pstmt.executeUpdate();
				return rs;
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 수정 오류");
			e.printStackTrace();
		}

		return 0;
	}

	// 8. 데이터 삭제
	public int delete(String id) throws SQLException {

		String sql = null;
		int rs = 0;

		if (exist(id)) {
			sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeUpdate();
			return rs;
		}
		return 0;

	}

}
