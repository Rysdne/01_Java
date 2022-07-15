package basic220519;

//
import java.util.Scanner;

public class PhonebookMain {

	public static void main(String[] args) {

		// 기존 방식
		// Phonebook pb = new Phonebook();
		// Phonebook pb = new Phonebook("rysdne", "010-4313-8294", "none");
		// pb.view();

		try (// 스캐너 함수를 객체화할 경우
				// 1) import java.util.Scanner; 선언
				// 2) Scanner(System.in) 형태로 객체화
		Scanner scan = new Scanner(System.in)) {
			// 내용 입력
			System.out.println("이름을 입력하세요");
			String name = scan.next();
			System.out.println("번호를 입력하세요");
			String tel = scan.next();
			System.out.println("메모를 입력하세요");
			String memo = scan.next();

			// 객체를 생성하면서 데이터 저장
			Phonebook pb = new Phonebook(name, tel, memo);

			// 출력 함수 실행
			pb.view();
		};

//		
//		System.out.println("숫자를 입력하세요");
//		
//		// num 변수에 입력한 정수값 저장
//		int num = scan.nextInt();
//		System.out.println("입력한 값 : "+num);
//		
//				

//		System.out.println("문자열을 입력하세요");
//		
//		// str 변수에 입력한 문자열 저장 
//		String str = scan.next();
//		System.out.println("입력한 값 : " + str);


	}

}
