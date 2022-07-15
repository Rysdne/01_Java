package basic220622;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		
		
		// 1. Try & Catch 구문 
		int a = 10;
		int b = 0;

		// 예외 발생할 법한 구문
		try {
			int rs = a / b;

			System.out.println(rs);
		}
		
		// 예외 발생 시 실행할 코드
		
		// 수학적인 예외
		catch (ArithmeticException e) {
			System.out.println("오류가 떴네요");
			e.printStackTrace();
		}
		
		// 일반적인 에러
		// 이걸 위에 써버리면 수학적인 예외도 미리 다루는게 되어서 위 예외상황을 못씀
		catch (Exception e) {
			System.out.println("오류가 떴어요");
			e.printStackTrace();
		}
		
		
		// 아무튼 실행할 코드
		finally {
			System.out.println("프로그램 종료");
		}

//		// 2. throw 구문
//		// 차례차례 에러가 올라옴
//		// main 까지도 에러를 던지니 그냥 실행(?) 
//		One one=new One();
//		System.out.println(one.two.three.c);
		
	}

}
