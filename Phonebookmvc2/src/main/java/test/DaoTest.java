package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import dao.PhonebookDAO;
import vo.PhonebookVO;

public class DaoTest {

	//@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass() 함수 호출");
	}

	//@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass() 함수 호출");
	}

	//@Before
	public void setUp() throws Exception {
		System.out.println("test() 실행 전 호출");
	}

	//@After
	public void tearDown() throws Exception {
		System.out.println("test() 실행 후 호출");
	}

	//@Test
	public void test() {
		PhonebookDAO dao = new PhonebookDAO();
		PhonebookVO vo = new PhonebookVO();
//		// vo.setIdx(110);
//		vo.setName("Rysdne");
//		vo.setHp("01043138294");
//		vo.setMemo("테스트");

		// 성공했을 경우(1) -> insert 함수가 int형을 반환하기 때문
		// 만약 insert가 여러번 일어나게 된다면 숫자가 바뀔 수 있음
		// 0일 경우는 입력은 되나 실패가 나옴
		// dao.insert(vo) 실행
		// assertEquals(1, dao.insert(vo));
		// assertEquals(1, dao.insert(null));
		
		// assertThrows(null, NullPointerException, null);
		// exception 오류를 내기 위한 테스트

		// 문자열, 정수형, 객체형, 불린형
		// 1) 문자열 -> Equals
		// assertEquals(0, 0);
		// 2) 객체형 -> Same
		// 값을 비교하는게 아니라 같은 주소를 바라보는가를 비교
		// PhonebookVO vo1=dao.findOne(24);
		// PhonebookVO vo2=vo1;
		// assertSame(vo2, vo1);
		// 3) 불린형 -> True
		// assertNotNull(dao.findOne(24));
		// assertTrue(false);
		
		// 4) 범위 확인
		// System.out.println(dao.totalCount());
		// assertEquals(80, dao.totalCount(),10);
		// 마지막에 허용 오차를 줌
		
		
	}
	@Test
	public void memberCountTest() throws ClassNotFoundException, SQLException {
		PhonebookDAO dao=new PhonebookDAO();
		int cnt=dao.totalCount();
		assertEquals(0,new PhonebookDAO().memberCount());
	}

	// @Test
	public void test1() {
		System.out.println("test1() 함수 호출");
	}

}
