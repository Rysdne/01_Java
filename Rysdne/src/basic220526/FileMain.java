package basic220526;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileMain {

	public static void main(String[] args) throws IOException {
		/* 파일 생성 */
		/*
		 * File file=new File("c.txt"); file.createNewFile(); //file.delete();
		 * 
		 * //File dir=new File("dir"); //dir.mkdir(); //dir.delete();
		 */

		// System.in.read()함수는 메모리에 있는 내용을 읽어오는기능
		// 키보드로부터 메모리에 입력된 상태의 값을 읽어 옮
		// inputStream, OutputStream은 모두 1바이트뿐만 가져옴
		
		
		// System.out.println(System.in.read());
		// System.out.println((char)System.in.read());
		// System.out.println(System.in.read());

		/* 키보드 입력 후 엔터키를 누를 때마다 문자 출력 */
		// 스트림이 비어 있을 때 입력가능상태가 됨
		// 키보드를 누를 때마다 출력하려면 이벤트 사용
		// 키보드입력->stream형태 저장->화면

		while (true) {
			char ch = (char) System.in.read();
			System.out.print(ch);
		}

		// 문자를 모아서 출력하는 방법
		/*
		 * char ch = 0; System.in.read(); while (System.in.available() != 0) { ch =
		 * (char) System.in.read(); } System.out.print(ch);
		 */
		// in.read()는 메모리로부터 값을 읽어오는 함수
		/*
		 * while (true) { ch = (char) System.in.read();
		 * System.out.println(System.in.available()); System.out.print(ch); }
		 */
		/* -------키보드 대신 파일스트림 사용------ */
		/*
		 * File file=new File("c.txt"); if(file.exists()) {
		 * System.out.println("파일이 존재합니다."); }else {
		 * System.out.println("파일이 존재하지 않습니다."); file.createNewFile(); } //메모리와 연결해주는 작업
		 * //read()함수는 정수를 리턴하므로 //char형으로 받아 사용할 경우 파일끝을 확인할 수 없음 //inputstream은 메모리
		 * 기준을 의미하며 //fileinputstream은 파일내용을 메모리로 입력한다는 의미
		 * 
		 * FileInputStream fis=new FileInputStream(file);
		 * 
		 * while(true) { int c=fis.read(); if(c==-1) break; System.out.print((char)c); }
		 * System.out.println("프로그램종료");
		 */

		/* 변수(메모리)->파일에 쓰기 */
		/*
		 * File file = new File("a.txt"); file.createNewFile();
		 * 
		 * FileOutputStream fos = new FileOutputStream(file); // fos.write(97); //
		 * fos.flush(); //socket일때 해줘야하는 함수
		 * 
		 * String data = "hello"; // fos.write(data.getBytes());
		 * fos.write(data.getBytes(), 0, 2); fos.flush();
		 */
	}

}
