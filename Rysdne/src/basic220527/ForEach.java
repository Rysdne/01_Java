package basic220527;

import java.util.ArrayList;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {

// =======================================================

		// 1. forEach 출력
		// 1) 일반 객체 배열에서는 사용할 수 없음
		// 2) 컬렉션 객체에만 사용이 가능한 문법
		List<String> list = new ArrayList<>();
		list.add("hello1");
		list.add("hello2");
		list.add("hello3");
		list.add("hello4");
		list.add("hello5");

		// list 자체가 String형으로 선언되어있기 때문에 내부의 pr변수는 자동으로 String형으로 선언됨
		// 람다식 : (변수->함수에 변수를 투입)
		list.forEach(pr -> System.out.println(pr));
		// 뭔 진 모르지만 위와 동일
		list.forEach(System.out::println);

// =======================================================

	}

}
