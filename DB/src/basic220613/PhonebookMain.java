package basic220613;

import java.util.List;

public class PhonebookMain {

	public static void main(String[] args) {

//		// 1. 만들어진 클래스를 이용하여 객체 생성
//		// 객체 자체를 만들어서 객체 생성
//		PhonebookDAOv1 dao = new PhonebookDAOv1();

		// 2. 인터페이스를 활용
		// 버전별로 DAO를 바꿀 수 있음, 단순히 불러오기만 하면 됨
		// 함수 업그레이드 관리가 편해짐
		// 스프링 부분에서 다시 배울 예정
		// 새로 dao를 만들 경우, 인터페이스 자체를 불러와서 항수들 자동 등록됨

		// PhonebookInter dao = new PhonebookDAOv1();
		PhonebookInter dao = new PhonebookDAOv2();
		// DAO의 ClassNotFoundException, SQLException이 선언되어있으면 위처럼 객체화할 수 없음
		List<PhonebookVO> list = dao.findAll();
		for (PhonebookVO pb : list) {
			System.out.println(pb);
		}

	}

}
