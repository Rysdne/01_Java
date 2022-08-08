package pb220526;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneBookMain {

	public static void main(String[] args) throws IOException {
//
//		PhoneBook pb=new PhoneBook("rysdne","010-1111-1111","none");
//		System.out.println(pb.toString());

// =======================================================
//		
//		// 배열 객체 생성 : 데이터는 PhoneBook에 있음
//		PhoneBook pb[] = new PhoneBook[4];
//
//		// 아래 식을 반복해야 함
//		// pb[0]=new PhoneBook("rysdne","010-1111-1111","none");
//		for(int i=0;i<pb.length;i++) {
//		
//			pb[i]=new PhoneBook("rysdne","010-1111-1111","none");
//		}

		// =======================================================

		// 배열 객체 생성 : 데이터는 PhoneBook에 있음
		PhoneBook pb[] = new PhoneBook[10];

		// 파일로부터 데이터 불러와 폰북에 넣음
		// BufferedReader 선언
		File f00 = new File("phonebook.txt");
		FileReader f01 = new FileReader(f00);
		BufferedReader f02 = new BufferedReader(f01);

		// txt 변수 선언
		String txt = null;

		// 인덱스 할 i를 0으로 초기화
		// readLine() 함수에서는 i를 초기화할 수 없기 때문에 별도로 선언
		int i = 0;

		// 파일로부터 반복해서 줄 읽기
		while ((txt = f02.readLine()) != null) {

			// 문자를 parsing하여 배열에 저장
			String arr[] = txt.split(" ");
			// ...............................................

			// 배열에 parsing한 데이터를 저장
			pb[i] = new PhoneBook(arr[0], arr[1], arr[2]);

			// i를 1씩 증가시켜 저장 공간마다 데이터 입력
			i++;
		}
		// 입력값 확인
		for (int c = 0; c < i; c++) {
			System.out.println(pb[c].toString());
		}
		// ...............................................

		// 임의적으로 메모리에 객채를 한 개 입력하는 함수 생성

		// @ 현재 "phonebook.txt" 자체는 입력 스트림에서 사용중임
		// 해당 스트림을 해제(close())시켜야 "phonebook.txt."에 입력 가능
		pb[i] = new PhoneBook("isaac", "010-5555-5555", "none");
		i++;

		// f02, f01 닫음
		// f00은 닫는게 없음
		f02.close();
		f01.close();

		// txt 파일로 출력하는 FileWriter, BufferedWriter 함수를 사용
		FileWriter f11 = new FileWriter(f00);
		BufferedWriter f12 = new BufferedWriter(f11);

		// 메모리에서 파일로 저장하는 반복문 생성
		for (int c = 0; c < i; c++) {
			// str 변수를 선언하여 입력할 라인 생성
			// str 변수를 밖에 선언하고 +=로 중첩시키는 방법도 있음, 그러나 결과적으로는 안됨
			String str = pb[c].name + " " + pb[c].tel + " " + pb[c].memo + "\n";
			// 마지막에 줄바꿈이 꼭 있어야 함
			System.out.println(str);
			// str 저장 : 줄 단위로 쓰기 때문에 +=로 데이터를 중첩시켜놔도 한 줄만 입력됨 
			f12.write(str);
			// flush : 밀어넣기, 이 놈이 있어야 이전 데이터가 사라지지 않음
			f12.flush();
		}
		// 마지막에 스트림을 닫아도 됨, close 함수에 flush가 포함되어 있음 
		// f12.close();
		// f11.close();
		
	}
}
