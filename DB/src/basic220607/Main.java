package basic220607;

import java.sql.SQLException;
import java.util.List;

//===================================================

// 실행 클래스 생성
public class Main {

	// 실행 함수 정의
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ...............................................

//		// 1. insert 함수
//		// 1) insert 이후 개별로 묶어서 보냄 
//		MemberDAO dao = new MemberDAO();
//		dao.insert("rysdne1", "1882");
//		dao.insert("rysdne2", "2882");
//		dao.insert("rysdne3", "3882");
//		dao.insert("rysdne4", "4882");
//		dao.insert("rysdne5", "5882");
//		// ...............................................

//		// 2) 이게 더 많이 쓰임
//		MemberDAO dao = new MemberDAO();
//		MemberVO member = new MemberVO("admin", "1234");
//		dao.insert(member);
//		// ...............................................

//		// 3) 이렇게 쓸 수도 있음
//		MemberDAO dao = new MemberDAO();
//		MemberVO member = new MemberVO("admin", "1234");
//		// get set 함수 사용
//		member.setId("admin1");
//		member.setPw("1234");
//		dao.insert(member);
//		// ...............................................

//		// 2. select 출력
//		// 1) 이후 sqlplus에서 select * from member;
//		MemberDAO dao = new MemberDAO();
//		dao.findAll();
//		// ...............................................

//		// 2) List에서 출력
//
//		MemberDAO dao = new MemberDAO();
//		
//		List list = dao.findAll();
//		// 임시객체 a에 list 값을 대입
//		// Object : 클래스의 최상위 조상
//		// for(MemberVO a : list){~~~} 하면 컴파일이 안되어있다는 에러 남
//		for (Object a : list) {
//			System.out.println(a);
//		}
//		// ...............................................

//		// 3. oneFind 출력(?)
//		MemberDAO dao = new MemberDAO();
//		// MemberVO 형태에 담아주기
//		
//		System.out.println(dao.findOne("rysdne3"));
//		// ...............................................

//		// 4. update 함수 실행
//		MemberDAO dao = new MemberDAO();
//		MemberVO member = new MemberVO("rysdne3", "3333");
//		dao.update(member);
//		System.out.println(dao.findOne(member.getId()));

		// 5. delete 함수 실행
		MemberDAO dao = new MemberDAO();
		dao.delete("rysdne5");

		// 나머지 확인
		List list = dao.findAll();
		for (Object a : list) {
			System.out.println(a);
		}
	}

}
