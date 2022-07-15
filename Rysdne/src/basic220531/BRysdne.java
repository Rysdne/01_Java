package basic220531;

//=======================================================

//1. implements : 구현하다 
//1) BInter에 있는 인터페이스를 구현하겠다 선언
//implements로 받은 함수는 반드시 구현해야 함
public class BRysdne implements BInter {

	// 2) BInter에서 인터페이스 함수 호출
	// 클래스명에서 Add unimplemented methods 선택

	@Override
	public int damage(int x, int y) {

		// 해당 함수에 대한 구현 작업
		return x - y;
	}

	@Override
	public String status(String x) {
		return x;
	}

}
//...............................................

////2. 결과적으로 이런 식과 같음
//public class Cal {
//
//	int x;
//	int y;
//
//	public Cal() {
//	}
//
//	public Cal(int x, int y) {
//		this.x = x;
//		this.y = y;
//		// ...
//	}
//}

//=======================================================