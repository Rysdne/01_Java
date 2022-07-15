package basic220609;

import java.sql.SQLException;
import java.util.List;

public class PhonebookMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		PhonebookDAO dao = new PhonebookDAO();

//		// 1. 입력함수 실행
//		dao.insert(1, "rysdne1", "01011111111", "none");
//		dao.insert(2, "rysdne2", "01022222222", "none");
//		dao.insert(3, "rysdne3", "01033333333", "none");
//		dao.insert(4, "rysdne4", "01044444444", "none");
//		dao.insert(5, "rysdne5", "01055555555", "none");

//		// 2. 출력함수 실행
//		List list = dao.findAll();
//		for (Object a : list) {
//			System.out.println(a);
//		}

//		// 3. 쿼리함수 실행
//		System.out.println(dao.findOne(3));

//		// 4. 데이터 존재여부 확인함수 실행
//		System.out.println(dao.exist(3));

//		// 5. 수정함수 실행
//		PhonebookVO pb = new PhonebookVO(3, "굔욷", "01043138294", "없음");
//		dao.update(pb);
//		System.out.println(dao.findOne(pb.getId()));

//		// 6. 제거 함수 실행
//		dao.delete(5);

	}

}
