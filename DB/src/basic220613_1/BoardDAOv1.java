package basic220613_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BoardDAOv1 implements BoardInter {

	Connection conn;
	PreparedStatement pstat;

	public BoardDAOv1() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

		} catch (Exception e) {
		}
	}

	public int insert(BoardVO bv) {
		try {
			String sql = "insert into board values(?,?,?,?,?)";
			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, bv.getNum());
			pstat.setString(2, bv.getTitle());
			pstat.setString(3, bv.getContent());
			pstat.setString(4, bv.getName());
			pstat.setString(5, bv.getPass());

			int rs = pstat.executeUpdate();

			return rs;
		} catch (Exception e) {
			System.out.println("입력 오류 발생");
			e.printStackTrace();
			return 0;
		}

	}

	public List<BoardVO> findAll() {
		try {
			String sql = "select * from board";
			pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();

			List<BoardVO> list = new ArrayList();

			while (rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setNum(rs.getInt("num"));
				bv.setTitle(rs.getString("title"));
				bv.setContent(rs.getString("content"));
				bv.setName(rs.getString("name"));
				bv.setPass(rs.getString("pass"));
				list.add(bv);
			}

			return list;
		} catch (Exception e) {
			System.out.println("입력 오류 발생");
			e.printStackTrace();
			return null;
		}
	}

	public BoardVO findOne(int num) {
		try {

			String sql = "select * from board where num=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, num);
			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setNum(rs.getInt("num"));
				bv.setTitle(rs.getString("title"));
				bv.setContent(rs.getString("content"));
				bv.setName(rs.getString("name"));
				bv.setPass(rs.getString("pass"));
				return bv;
			}
			return null;
		} catch (Exception e) {
			System.out.println("입력 오류 발생");
			e.printStackTrace();
			return null;
		}

	}

	public boolean exist(int num) {
		try {
			String sql = "select * from board where num=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, num);
			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public int update(BoardVO bv) {
		try {
			if (exist(bv.getNum())) {
				String sql = "update board set title=?,content=?,name=?,pass=? where num=?";
				pstat = conn.prepareStatement(sql);

				pstat.setString(1, bv.getTitle());
				pstat.setString(2, bv.getContent());
				pstat.setString(3, bv.getName());
				pstat.setString(4, bv.getPass());
				pstat.setInt(5, bv.getNum());

				int rs = pstat.executeUpdate();
				return rs;
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}

	}

	public int delete(int num) {
		try {
			if (exist(num)) {
				String sql = "delete from board where num=?";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, num);

				int rs = pstat.executeUpdate();
				return rs;
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}

	}

}
