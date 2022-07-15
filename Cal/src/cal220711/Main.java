package cal220711;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
//	// =======================================================
//		
//		// 0. 테스트
//		Cal cal=new Cal();
//		cal.add(10, 20);
//		cal.historyprn();
//		
//		// ...............................................

		// 계산기 프로그램을 만드는데 있어 절차적 사항 확인
		// 1) 두 수 입력받음 (저장 변수 필요)
		// - 입력받을 땐 메시지 필요
		// 2) 연산자 선택 (선택 연산자 저장 변수)
		// 3) 연산 결과 출력 (계산기 클래스 객체변수)
		// 4) 1)번으로 돌아감 (반복문)
		// 순서는 자유롭게, 나라면 1) 입력은 나중에 받을거
		// 아래는 먼저 받는 형태

		Cal cal = new Cal(100);

		// 계속 반복하도록 하는 명령
		while (true) {
			// 1) 두 수 입력
			Scanner sc = new Scanner(System.in);
			int su1 = 0;
			int su2 = 0;

			System.out.println("두 수를 입력하세요");
			su1 = sc.nextInt();
			su2 = sc.nextInt();

			// 연산자 선택
			menu();
			// System.in.read() : 아스키코드 형태로 읽어옴
			// 나중에 case 문에서 1을 불러올 경우 '1'로 불러오면 됨
			// 이걸 아래 switch문에 입력값을 줘도 됨
			// 이럴 땐 menu 자체가 int형으로 변경되어야 함(?)
			// switch(menu()) 이런 식으로

			// 연산 결과 출력
			int m = System.in.read();

			switch (m) {
			// 아스키코드 입력 방지를 위해 따옴표 적음
			case '1':
				System.out.println(cal.add(su1, su2));
				break;
			case '2':
				System.out.println(cal.sub(su1, su2));
				break;
			case '3':
				System.out.println(cal.mux(su1, su2));
				break;
			case '4':
				System.out.println(cal.div(su1, su2));
				break;
			case '5':
				cal.historyprn();
				break;
			case '6':
				System.exit(0);
				break;
			default:
				System.out.println("올바른 번호가 아닙니다");
				break;
			}
		}
	}

	public static void menu() {

		System.out.println("===========");
		System.out.println("1. 덧셈");
		System.out.println("2. 뺄셈");
		System.out.println("3. 곱셈");
		System.out.println("4. 나눗셈");
		System.out.println("5. 기록");
		System.out.println("6. 종료");
		System.out.println("===========");

	}

}
