package basic220526;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) throws IOException {

		// =============== 파일리더 ===============
		// FileReader는 줄 단위로 읽어옴(버퍼 단위로 읽어오기 때문)
		// 아직 해결하지 못한 건 char로 받아온 뒤에 String으로 변환했다는 것
		// 첫 번째 방법
		FileReader f = new FileReader("readfile.txt");

		// 두 번째 방법
		// File f1=new File("readfile.txt");
		// FileReader f2 = new FileReader(f1);
		// File인 f1을 객체화
		// FileReader는 변수로 File이 필요함(상호 의존적인 관계)

		int count;
		char[] buf=new char[100];
		while((count=f.read(buf))!=-1) {
			// 괄호 내부의 값은 count임 -> 결국 count != -1 식이 되는겨
			String data=new String(buf,0,count);
			System.out.println(data);
		}
		f.close();
		System.out.println("===================");
		// read() 메소드는 줄단위로 읽고 더이상 읽을 글자가 없으면 -1 출력
		
//		//Q) read() 마지막에 -1이 나오는가
//		int count;
//		char[] buf=new char[100];
//		count=f.read(buf);
//		System.out.println(count);
//		
//		f.close();
//		System.out.println("===================");

	}

}
