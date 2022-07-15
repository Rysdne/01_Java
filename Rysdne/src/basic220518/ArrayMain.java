package basic220518;

public class ArrayMain {

	public static void main(String[] args) {

//		1. 가변길이 이후 없는 공간에 데이터를 넣으려 할 경우 오류
//		int w[] = { 10, 20, 30 };
//		for (int i = 0; i < w.length; i++) {
//			System.out.println(w[i]);
//
//		}
//		오류 발생
//		w[3] = 40;
//		System.out.println(w[3]);
//		=====================================
//		2. 공간 정의 후 데이터 수정 시 가능
//		int w[] = new int[4];
//		for (int i = 0; i < w.length; i++) {
//			System.out.println(w[i]);
//
//		}
//		가변일 경우 오류 발생, 배열을 생성하면 오류 없음
//		w[3] = 40;
//		System.out.println(w[3]);
//		
//		=====================================
//		3. C언어 형태도 가능
//		int[] w = new int[4];
//
//		for (int i = 0; i < w.length; i++) {
//			System.out.println(w[i]);
//
//		}
//
//		=====================================
//		4. 가변길이로 선언한 뒤 가변길이로 객체화시켜야 가능 
		int w[] = new int[] {10,20,30,40};
		
		for (int i = 0; i < w.length; i++) {
			System.out.println(w[i]);

		}
		
	}

}
