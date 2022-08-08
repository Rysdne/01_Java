package basic220526;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class T_BufferedReaderMain {

	public static void main(String[] args) throws IOException {

// =======================================================

		// 0. 파일 생성 및 내용 입력 
		
		
		
		
// =======================================================
		
//		// 1. BufferedReader : 문자배열을 문자열로 바로 처리하기 위한 기술
//		// ...............................................
//		
//		// 1) 한 번에 만들기
//		BufferedReader f=new BufferedReader(new FileReader(new File("textbox.txt")));
//		// ...............................................
//
//		// 2) 세 번에 만들기
//		File f1 = new File("textbox.txt");
//		FileReader f2 = new FileReader(f1);
//		BufferedReader f3 = new BufferedReader(f2);
//		// 상호의존적 관계
//		// ...............................................
		
// =======================================================		
		
		// 2. 저장 내용 출력
		// ...............................................
		
		BufferedReader f1=new BufferedReader(new FileReader(new File("textbox.txt")));
		// ...............................................
		
//		// 1) 한 줄만 출력
//		System.out.println(f.readLine());
//		// 가장 위의 한 줄만 출력
//		// ...............................................
		
		// 2) 여러 줄 출력
		String a=null;
		while((a=f1.readLine())!=null) {
		// 한 줄의 텍스트가 없을 때 멈춤(엔터는 텍스트가 존재함)
			System.out.println(a);
		}
		// ...............................................
		
// =======================================================		

	}

}
