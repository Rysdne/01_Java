package basic220526;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T_FileMain {

	public static void main(String[] args) throws IOException {

// =======================================================
		
//		// 1. 파일 생성 및 삭제
//		File f=new File("textbox.txt");
//
//		f.createNewFile();
//		f.delete();
//
//		 File d=new File("dir");
//		 d.mkdir();
//		 d.delete();
		 
// =======================================================
		 
//		// 2. 문자를 하나씩 출력
//
//		while(true) {
//			char ch= (char) System.in.read();
//			System.out.print(ch);
//		}

// =======================================================

//		// 3. 문자를 모아서 출력
//
//		char ch = 0;
//		System.in.read();
//		// 입력받은 문자를 하나씩 저장한 뒤 해당 배열의 위치를 반환
//		while (System.in.available() != 0) {
//			ch = (char) System.in.read();
//			System.out.print(ch);
//			System.out.println(System.in.available());
//		}

// =======================================================

//		// 4. 파일스트림으로 파일에 메시지 저장
//		// ...............................................		
//		
//		// 1) 파일 생성
//		File f = new File("FileStreamBox.txt");
//		f.createNewFile();
//		// ...............................................
//		
//		// 2) 파일스트림을 통해 파일 내부 텍스트 수정
//		
//		// 2-1) 스트림에 저장된 텍스트를 파일에 저장하는 아웃풋 스트림 객체 생성
//		FileOutputStream fos = new FileOutputStream("FileStreamBox.txt");
//		// 아스키코드 기반의 문자를 파일로 출력 
//		fos.write(82);
//		fos.write(121);
//		fos.write(115);
//		fos.write(100);
//		fos.write(110);
//		fos.write(101);
//		fos.flush();
//
//		// 2-2) 객체의 파일로부터 텍스트를 저장하는 인풋 스트림 객체 생성
//		FileInputStream fis = new FileInputStream(f);
//		while (true) {
//			int c = fis.read();
//			if (c == -1)
//				break;
//			System.out.print((char) c);
//		}
//		fis.close();
//		f.delete();
//		// ...............................................		
		
// =======================================================
		
	}
}
