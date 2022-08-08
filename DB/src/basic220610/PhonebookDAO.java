package basic220610;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// ===================================================

// # 쉽게 하기!
// @ PreparedStatement 사용
// 1. 생성자에서 Connection 객체만을 생성
// 2. sql 문을 문자열로 만들고, 입력값은 물음표(?)로 구성
// 3. conn.prepareStatement(sql);을 이용하여 sql문에 들어갈 내용을 준비함
// 4. 미완성된 입력값의 수 만큼 setInt, setString 함수를 이용하여 입력
// 5. 완성된 문장을 실행

//...............................................

public class PhonebookDAO {
	// 얘는 그대로
	Connection conn;

	// PreparedStatement로 바꾸기
	// 원래는 여기 없어도 됨
	PreparedStatement pstat;
	// 이후 생성자 함수에 있는 stat 인터페이스를 삭제함

	// 1. 생성자 함수 설정
	public PhonebookDAO() throws ClassNotFoundException, SQLException {

		// 1) 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2) 오라클 연결
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

		// 3) 인터페이스 설정
		// 인터페이스는 함수 내부에서 만들어줌
	}

//	// 연결 확인
//	public void create() throws SQLException {
//		String sql = "create table test(id varchar2(10),pw varchar2(14))";
//		ResultSet result = stat.executeQuery(sql);
//
//	}

	// 2.입력 함수 정의
	public int insert(PhonebookVO vo) throws SQLException {

		// 안에 들어갈 내용을 물음표로 채우기
		String sql = "insert into phonebook values(?,?,?,?)";
		// 여기서 conn과 연결
		pstat = conn.prepareStatement(sql);
		// 여기서 sql 문자열 호출, prepareStatement에 내용이 등록됨
		pstat.setInt(1, vo.getId());
		pstat.setString(2, vo.getName());
		pstat.setString(3, vo.getHp());
		pstat.setString(4, vo.getMemo());

		int rs = pstat.executeUpdate();
		// 이미 한 번 sql이 호출되었기 때문에 이걸 다시 넣지 않아도 됨
		
		return rs;
	}
	// ...............................................

	// 3. 전체 출력 함수 정의
	public List findAll() throws SQLException {

		String sql = "select * from phonebook";
		// 여기서 인터페이스 선언
		pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		List<PhonebookVO> list = new ArrayList();

		while (rs.next()) {
			PhonebookVO vo = new PhonebookVO();
			vo.setId(rs.getInt("id"));
			vo.setName(rs.getString("name"));
			vo.setHp(rs.getString("hp"));
			vo.setMemo(rs.getString("memo"));
			list.add(vo);
		}
		return list;
	}

	// 4. 특정 데이터 쿼리 함수 정의
	// _id : 전달받은 -> id가 중복되어서 그럼
	public PhonebookVO findOne(int _id) throws SQLException {
		String sql = "select * from phonebook where id=?";
		pstat = conn.prepareStatement(sql);
		pstat.setInt(1, _id);
		ResultSet rs = pstat.executeQuery();

		if (rs.next()) {
			PhonebookVO vo = new PhonebookVO(rs.getInt("id"), rs.getString("name"), rs.getString("hp"),
					rs.getString("memo"));
			return vo;
		}
		return null;
	}
	// ...............................................

	// 5. 특정 데이터 수정 함수 정의
	// 1) 해당 데이터가 있는지 확인
	public boolean exist(int id) throws SQLException {
		String sql = "select * from phonebook where id=?";
		pstat = conn.prepareStatement(sql);
		pstat.setInt(1, id);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			// System.out.println("해당 이름의 데이터가 존재합니다");
			return true;
		}
		return false;
	}

	// 2) 데이터 수정 함수 정의
	public int update(PhonebookVO vo) throws SQLException {

		if (exist(vo.getId())) {
			String sql = "update phonebook set name=?,hp=?,memo=? where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, vo.getName());
			pstat.setString(2, vo.getHp());
			pstat.setString(3, vo.getMemo());
			pstat.setInt(4, vo.getId());

			int rs = pstat.executeUpdate();
			return rs;
		}
		return 0;
	}
	// ...............................................

	// 6. 특정 데이터 삭제 함수 정의
	public int delete(int id) throws SQLException {

		if (exist(id)) {
			String sql = "delete from phonebook where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			int rs = pstat.executeUpdate();
			return rs;
		}
		return 0;
	}
	// ...............................................

}
