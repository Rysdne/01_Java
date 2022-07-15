package basic220526;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class T_FileReaderMain {

	public static void main(String[] args) throws IOException {

// =======================================================

		File f0=new File("textbox.txt");
		f0.createNewFile();
		// 1. FileReader
		// 줄 단위로 읽어옴(버퍼 단위로 읽어오기 때문)
		// ...............................................
		
		// 1) 한 번에 만들기
		FileReader f = new FileReader("textbox.txt");
		// ...............................................
		
		// 2) 두 번에 만들기
		File f1=new File("textbox.txt");
		FileReader f2=new FileReader(f1);
		// 상호 의존적인 관계
		// ...............................................
		
		// 3) 배열 형태로 저장
		int count;
		char[] buf = new char[100];
		while((count=f.read(buf))!=-1) {
		// read() 메소드는 읽을 글자가 없으면 -1을 출력
			String d=new String(buf,0,count);
			System.out.println(d);
		}
		f.close();
		
// =======================================================		
		
	}

}
