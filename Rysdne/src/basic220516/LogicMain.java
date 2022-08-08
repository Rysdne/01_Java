package basic220516;

public class LogicMain {

	public static void main(String[] args) {
//입력값 k가 3의 배수이거나 5의 배수일 경우를 찾아라.
		//3의 배수 또는 5의 배수를 찾아라.
		//(ex)and 조건을 모두 만족
		int k = 101;

		// 논리 연산자 or의 사용
		if ((k % 3 == 0) || (k % 5 == 0)) {
			System.out.println("k 값 : " + k + " : 3의 배수이거나 5의 배수입니다.");

		} else {
			System.out.println("k의 값은 3의 배수이거나 5의 배수가 아닙니다.");
		}

	}

}
