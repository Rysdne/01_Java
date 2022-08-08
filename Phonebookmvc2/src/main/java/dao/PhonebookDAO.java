package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.PhonebookVO;

public class PhonebookDAO implements PhonebookDaoInter {
	Connection conn;
	PreparedStatement pstmt;

	public PhonebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
		} catch (Exception e) {

		}
	}

	public int insert(PhonebookVO pb) {
		try {
			String sql = "insert into phonebook values(phonebook_idx_seq,?,?,?)";
			System.out.println(pb.toString());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pb.getName());
			pstmt.setString(2, pb.getHp());
			pstmt.setString(3, pb.getMemo());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			System.out.println("입력 오류발생");
			e.printStackTrace();
			return 0;
		}

	}

	public List<PhonebookVO> findAll() {
		try {
			String sql = "select * from phonebook";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<PhonebookVO> list = new ArrayList();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String memo = rs.getString("memo");
				PhonebookVO imsi = new PhonebookVO(idx, name, hp, memo);
				list.add(imsi);
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public PhonebookVO findOne(int _idx) {
		try {
			String sql = "select * from phonebook where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _idx);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String memo = rs.getString("memo");
				PhonebookVO imsi = new PhonebookVO(idx, name, hp, memo);
				return imsi;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public int update(PhonebookVO pb) {
		try {
			if (exist(pb.getIdx())) {
				String sql = "update phonebook set name=?,hp=? ,memo=? where idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pb.getName());
				pstmt.setString(2, pb.getHp());
				pstmt.setString(3, pb.getMemo());
				pstmt.setInt(4, pb.getIdx());
				int result = pstmt.executeUpdate();
				return result;
			}
			return 0;
		} catch (Exception e) {
			System.out.println("업데이트 오류발생");
			e.printStackTrace();
			return 0;
		}
	}

	public int delete(int idx) {
		try {
			if (exist(idx)) {
				String sql = "delete from phonebook where idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				int result = pstmt.executeUpdate();
				return result;
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public boolean exist(int idx) {
		try {
			String sql = "select * from phonebook where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	// 글 전체 개수
	public int totalCount() {
		int totalCount = 0;
		String sql = "select count(*) from phonebook";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// 필드명을 이용하는 방법과 필드 순서를 이용하는 방법이 있음
				// totalCount = rs.getInt(1);
				totalCount = rs.getInt("count(*)");
				System.out.println("전체게시물수:" + totalCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	public List pageList(int startRow, int endRow, int totalPage, int currentPage, int totalCount) {
		// 글의 시작범위와 끝범위의 데이터를 가지오는 작업
		String sql = "select rownum,b.* from ";
		sql += "(select rownum rn,a.* from ";
		sql += "(select * from phonebook order by idx)a ";
		sql += "where rownum <=? ";
		sql += "order by rownum desc) b ";
		// sql+="where rownum between 1 and 10 ";
		sql += "where rownum between 1 and ? ";
		sql += "order by b.rn asc";
		List<PhonebookVO> list = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, endRow);
			pstmt.setInt(1, currentPage * 10);
			// 전달받은 페이지 * 10을 조건에 적용하여
			// 마지막 페이지가 10개의 게시물이 아닌 경우 나머지 값을 활용하여 범위확정

			if (totalPage == currentPage) {
				pstmt.setInt(2, totalCount % 10);
			} else {
				pstmt.setInt(2, 10);
			}
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				PhonebookVO pb = new PhonebookVO();
				pb.setIdx(rs.getInt("idx"));
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setMemo(rs.getString("memo"));
				list.add(pb);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int memberCount() {
		int cnt = 0;
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
		}
		return cnt;
	}
}