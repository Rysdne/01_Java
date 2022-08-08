package basic220526;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExamMain {

	public static void main(String[] args) throws IOException {
		// 문제)콘솔창에 a-h까지 문자를 입력하면
		// 파일에 콘솔창 문자가 입력되는 프로그램을 만드세요.
		// 1-1.콘솔로부터 문자열을 입력받아 변수에 저장


		byte[] bs = new byte[100];
		System.in.read(bs);
		String data = new String(bs);
		System.out.println(data);

		// 1-2.문자하나를 변수에 받아 문자열로 저장하는 방법
		/*
		 * String data="";
		 * 
		 * int d=System.in.read(); //d!=13이 안되면 10으로 변경 while(d!=13) {
		 * data=data+(char)d; d=System.in.read(); } System.out.println(data);
		 */

		// 2. 파일을 생성(File file=new File("data.txt"),create사용)
		File file = new File("data.txt");
		// file.createNewFile();
		// 3.콘솔에서 저장된 변수값을 FileOutputStream을 이용해
		// 파일에 저장
		FileOutputStream fos = new FileOutputStream(file);
		// 파일뒤에 붙여쓰기 할 경우 스트림에 true옵션을 줌
		// FileOutputStream fos=new FileOutputStream(file,true);
		// fos.write(data.getBytes());

		// System.out.println(data.length());//만약4자리 입력했을 경우
		// 4가 결과로 나와야하지만 100이라는 결과가 나옴
		// 이는 바이트크기만큼 변환되어 문자열이 채워짐
		int i = 0;
		while (bs[i++] != 13) {
		} // 라인피드까지 문자열 수를 확인
		System.out.println(i - 1); // 반복문을 돌고나면 마지막 1이 증가하므로 -1
		fos.write(data.getBytes(), 0, i - 1);// 전체데이터 중 문자길이만큼 파일에 씀
		fos.flush();
		fos.close();
	
		// * FileOutputStream(?)은 1바이트만을 읽을 수 있음
		// 따라서 오디오나 그림, 한글 등은 저장이 안됨
		// 이 때는 FileRead(?)를 해야 함

	}

}
