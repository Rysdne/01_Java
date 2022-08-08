package basic220607;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// ===================================================

// DAO : Database에 접속한 뒤 처리하는 객체
// 처리 : 입력 / 출력 / 업데이트 / 삭제
public class MemberDAO {

	Connection conn;
	Statement stat;
	// String sql;
	// ResultSet rs;
	// 위 2개는 이번에는 사용 안함

	// ...............................................

	// 1. 생성자 함수 선언
	public MemberDAO() throws ClassNotFoundException, SQLException {

		// 1) 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2) 오라클 접속
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		// 3) 인터페이스 생성
		stat = conn.createStatement();
	}
	// ...............................................

	// 2. 데이터 입력 함수 정의
	// html foam에 있는 내용이 이 쪽으로 전달되어야 함
	public int insert(String id, String password) throws SQLException {
		// 입력 변수 정의
		// 전달받을 내용은 id와 password 변수에 저장되기 때문에 아래처럼 저장
		// * 사실 이렇게 사용 잘 안함
		String sql = "insert into member values('" + id + "','" + password + "')";

		// 1. 뭐시기
		int result = stat.executeUpdate(sql);
		// executeUpdate 설명 보면 int 형으로 전달되기 때문에 int로 형변환 시켜야 함
		// sql 변수는 String
		return result;

	}
	// ...............................................

	// 3. MemberVO에서 함수 불러오기
	public int insert(MemberVO member) throws SQLException {
		// 입력 변수 정의
		// 전달받을 내용은 id와 password 변수에 저장되기 때문에 아래처럼 저장
		// * 사실 이렇게 사용 잘 안함
		String sql = "insert into member values('" + member.getId() + "','" + member.getPw() + "')";

		// 1. 뭐시기
		int result = stat.executeUpdate(sql);
		// executeUpdate 설명 보면 int 형으로 전달되기 때문에 int로 형변환 시켜야 함
		// sql 변수는 String
		return result;
	}
	// ...............................................

//	// 4. 단순 select 출력 -> void
//	public void findAll() throws SQLException {
//		String sql = "select * from member";
//		// ResultSet : list와 비슷
//		ResultSet rs = stat.executeQuery(sql);
//
//		// rs에 다음 라인 데이터가 있는지 질의
//		// 열 번호 사용
//		while (rs.next()) {
//			System.out.println("id : " + rs.getString(1) + ", pw : " + rs.getString(2));
//		}
//		// 속성명 사용
//		while (rs.next()) {
//			
//			System.out.println("id : " + rs.getString("id") + ", pw : " + rs.getString("password"));
//		}
//		// list 배우고 나서는 안씀
//	}
//	// ...............................................

	// 5. MemberVO 내부에 행을 임시저장하고 불러와 List 함수에 저장
	// list에서는 값을 반환하기 때문에 void 형태가 아님
	// MemberVO는 임시저장공간으로, get set 함수에 의해 저장 및 출력됨
	public List findAll() throws SQLException {
		// List로 저장하려는 공간을 먼저 언급해야 함
		// 리스트 자체가 콜렉션 프레임워크
		// MemberVO 형태의 객체(generic)를 list에 여러 개 저장할 수 있는 프레임워크

		String sql = "select * from member";
		// ResultSet : list와 비슷
		ResultSet rs = stat.executeQuery(sql);
		List<MemberVO> list = new ArrayList();

		// rs에 다음 라인 데이터가 있는지 질의
		// 열 번호 사용
		while (rs.next()) {
			// 객체(클래스)를 변수에 저장 : 값과 함수를 모두 저장
			// MemberVO에 toString 함수가 없으면 값이 아닌 객체 값이 출력됨
			// 아래 내용이 while 밖에서 선언되면 마지막 입력값만 출력됨
			MemberVO m = new MemberVO();

			// id 항목에서 문자열을 추출
			m.setId(rs.getString("id"));
			// password 항목에서 문자열을 추출
			m.setPw(rs.getString("password"));

			// 해당 내용을 list에 담음
			list.add(m);
		}
		return list;
	}
	// ...............................................

	// 6. 값에 맞는 데이터만 찾기
	public MemberVO findOne(String id) throws SQLException {
		String sql = "select * from member where id='" + id + "'";
		// ResultSet : list와 비슷
		ResultSet rs = stat.executeQuery(sql);

		// 짜피 찾는 건 한 줄이기 때문에 if 를 사용해도 됨
		if (rs.next()) {
			MemberVO m = new MemberVO(rs.getString("id"), rs.getString("password"));
			return m;
		}
		// return 함수는 그 자체로 함수 종료이기 때문에 흐르지 않음
		return null;
	}
	// ...............................................

//	// 7. 업데이트
//	// 수정 & 삭제 둘 다 있음
//	// ID는 바꿀 수 없음 -> 삭제밖에 못함
//	// PW는 바꿀 수 있음 -> 수정밖에 못함
//	// id만을 별도로 받을지, MemberVO를 실어서 데이터를 한번에 받을지 생각해봐야 함
//	// 시각적으로 보여줄 지, 아님 내용 아는 형태로 한 번에 불러올지
//	public int update(MemberVO member) throws SQLException {
//
//		// id에 대해 데이터베이스에 존재하는지 여부를 확인
//		if (exist(member.getId())) {
//			String sql = "update table set password='" + member.getPw() + "' where id='" + member.getId() + "'";
//			int result = stat.executeUpdate(sql);
//			return result;
//		} else {
//			return 0;
//		}
//	}
//
//	// 1) DB에 id가 있는지 확인하는 함수
//	public boolean exist(String id) throws SQLException {
//		String sql = "select * from member where id='" + id + "'";
//		ResultSet rs = stat.executeQuery(sql);
//
//		// rs.next() = [true|false]
//		if (rs.next()) {
//			return true;
//		}
//		return false;
//	}

	// id 있는지 확인
	public boolean exist(String id) throws SQLException {

		String sql = "select * from member where id='" + id + "'";
		ResultSet rs = stat.executeQuery(sql);
		if (rs.next()) {
			return true;
		}
		return false;
	}

	// 있을 경우 수정
	public int update(MemberVO member) throws SQLException {

		if (exist(member.getId())) {
			String sql = "update member set password='" + member.getPw() + "' where id='" + member.getId() + "'";
			int rs = stat.executeUpdate(sql);
			return rs;
		}

		return 0;
	}

	// 8. 데이터 삭제
	public int delete(String id) throws SQLException {
		if (exist(id)) {
			String sql = "delete from member where id='" + id + "'";
			int rs = stat.executeUpdate(sql);
			return rs;
		}
		return 0;

	}

}

// ===================================================
