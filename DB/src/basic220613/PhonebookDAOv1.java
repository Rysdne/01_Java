package basic220613;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhonebookDAOv1 implements PhonebookInter {
	Connection conn;
//	// # PreparedStatememt 사용
//	// 기존 Statement를 PreparedStatememt로
//	Statement stat;
//	//원래는 여기 없고 각자 들어가도 됨
	PreparedStatement pstat;
//	// 이후 생성자 함수 내에 있는 stat 인터페이스 삭제
	// 나중에 함 해보기

	public PhonebookDAOv1() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
//			stat = conn.createStatement();
		} catch (Exception e) {
		}

	}

	public int insert(PhonebookVO pb) {
		try {
			String sql = "insert into phonebook values(" + pb.getId() + ",'" + pb.getName() + "','" + pb.getHp() + "','"
					+ pb.getMemo() + "')";
			pstat = conn.prepareStatement(sql);
			int rs = pstat.executeUpdate();
			return rs;
		} catch (Exception e) {
			System.out.println("입력 오류발생");
			e.printStackTrace();
			return 0;
		}
	}

	public List<PhonebookVO> findAll() {
		try {
			String sql = "select * from phonebook";
			pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			List<PhonebookVO> list = new ArrayList();

			while (rs.next()) {
				PhonebookVO pb = new PhonebookVO();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setMemo(rs.getString("memo"));
				list.add(pb);
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public PhonebookVO findOne(int id) {
		try {
			String sql = "select * from phonebook where id=" + id;
			pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery(sql);

			if (rs.next()) {
				PhonebookVO pb = new PhonebookVO(rs.getInt("id"), rs.getString("name"), rs.getString("hp"),
						rs.getString("memo"));
				return pb;
			}
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	public boolean exist(int id) {
		try {
			String sql = "select * from phonebook where id=" + id;
			pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				return true;
			}

			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public int update(PhonebookVO pb) {
		try {
			if (exist(pb.getId())) {
				String sql = "update phonebook set name='" + pb.getName() + "',hp='" + pb.getHp() + "',memo='"
						+ pb.getMemo() + "' where id=" + pb.getId();
				pstat = conn.prepareStatement(sql);
				int rs = pstat.executeUpdate();
				return rs;
			}
			System.out.println("해당 데이터가 존재하지 않습니다");
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public int delete(int id) {
		try {
			if (exist(id)) {
				String sql = "delete from phonebook where id=" + id;
				pstat = conn.prepareStatement(sql);
				int rs = pstat.executeUpdate();
				return rs;
			}
			System.out.println("해당 데이터가 존재하지 않습니다");
			return 0;
		} catch (Exception e) {
			return 0;
		}

	}
}
