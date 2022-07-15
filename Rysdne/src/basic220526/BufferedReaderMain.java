package basic220526;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderMain {

	public static void main(String[] args) throws IOException {
		// 문자배열을 문자열로 바로 처리하기 위한 기술
		// File f1 = new File("readfile.txt");
		// FileReader f2 = new FileReader(f1);
		// BufferedReader f3 = new BufferedReader(f2);
		// 얘들도 상호 의존적인 관계
		// >>>
		BufferedReader f3 = new BufferedReader(new FileReader(new File("readfile.txt")));
		// 안에 넣을 땐 new 까지만 붙여서 넣으면 됨
		
		// 한 줄 출력
		// System.out.println(f3.readLine());
		
		// 1) f3으로부터 한 줄을 읽고 그 값을 ex 변수에 저장함
		// 2) ex 변수의 값이 null이 아닌 경우에 출력
		String a=null;
		while((a=f3.readLine())!=null) {
			System.out.println(a);
		}
	}
}
