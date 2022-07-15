package basic220607;

import java.util.ArrayList;
import java.util.List;

public class ListMain {

	public static void main(String[] args) {

		// 리스트 함수 객체화
		// ArrayList list = new ArrayList();

		// list : 인터페이스(?)
		List list = new ArrayList();
		// 둘이 결과는 같았음
		
		// generic : 
		// 프레임워크는 객체를 저장하는 공간,
		// 일반적인
		
		
		// 리스트에 데이터 추가
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("c");
		// 저장공간 순서 존재, 중복 가능

		// 데이터 제거 가능
		// 1) 배열 위치로 삭제
		// list.remove(2);

		// 2) 문자열 색인 후 삭제
		list.remove(list.indexOf("c"));
		// 이러면 처음에 나오는 애만 삭제

		// 3) 리스트 삭제
		// list.clear();

		// size는 일반적으로 숫자를 다루는 객체는 아님(?)
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

//		// ???
//		for (String ex : list) {
//			System.out.println(ex);
//		}

	}

}
