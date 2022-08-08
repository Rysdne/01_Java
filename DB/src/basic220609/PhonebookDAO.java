package basic220609;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhonebookDAO {
	Connection conn;
	Statement stat;

	// 1. 생성자 함수 설정
	public PhonebookDAO() throws ClassNotFoundException, SQLException {

		// 1) 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2) 오라클 연결
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

		// 3) 인터페이스 설정
		stat = conn.createStatement();
	}

//	// 연결 확인
//	public void create() throws SQLException {
//		String sql = "create table test(id varchar2(10),pw varchar2(14))";
//		ResultSet result = stat.executeQuery(sql);
//
//	}

	// 2.입력 함수 정의
	public int insert(int id, String name, String hp, String memo) throws SQLException {

		String sql = "insert into phonebook values('" + id + "','" + name + "','" + hp + "','" + memo + "')";
		int rs = stat.executeUpdate(sql);
		return rs;
	}

	// 3. 전체 출력 함수 정의
	public List findAll() throws SQLException {

		String sql = "select * from phonebook";
		ResultSet rs = stat.executeQuery(sql);
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
	}

	// 4. 특정 데이터 쿼리 함수 정의
	public PhonebookVO findOne(int id) throws SQLException {
		String sql = "select * from phonebook where id=" + id;
		ResultSet rs = stat.executeQuery(sql);

		if (rs.next()) {
			PhonebookVO pb = new PhonebookVO(rs.getInt("id"), rs.getString("name"), rs.getString("hp"),
					rs.getString("memo"));
			return pb;
		}
		return null;
	}

	// 5. 특정 데이터 수정 함수 정의
	// 1) 해당 데이터가 있는지 확인
	public boolean exist(int id) throws SQLException {
		String sql = "select * from phonebook where id=" + id;
		ResultSet rs = stat.executeQuery(sql);
		if (rs.next()) {
			// System.out.println("해당 이름의 데이터가 존재합니다");
			return true;
		}
		return false;
	}

	// 2) 데이터 수정 함수 정의
	public int update(PhonebookVO pb) throws SQLException {

		if (exist(pb.getId())) {
			String sql = "update phonebook set name='" + pb.getName() + "',hp='" + pb.getHp() + "',memo='"
					+ pb.getMemo() + "' where id=" + pb.getId();
			int rs = stat.executeUpdate(sql);
			return rs;
		}
		return 0;
	}

	// 6. 특정 데이터 삭제 함수 정의
	public int delete(int id) throws SQLException {

		if (exist(id)) {
			String sql = "delete from phonebook where id=" + id;
			int rs = stat.executeUpdate(sql);
			return rs;
		}
		return 0;
	}

}
