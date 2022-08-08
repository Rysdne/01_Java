package basic220526;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderParserMain {

	public static void main(String[] args) throws IOException {
		File f1=new File("phonebook.txt");
		FileReader f2=new FileReader(f1);
		BufferedReader f3=new BufferedReader(f2);
		
		
		// 한 줄씩 받아서 parsing 해야 함
		String txt=null;
		
		// 1) 반복해서 줄 읽기
		while((txt=f3.readLine())!=null) {
			// System.out.println(txt);
			
			// 2) parsing
			String arr[]=txt.split(" ");
			System.out.print(" | name : "+arr[0]);
			System.out.print(" | tel : "+arr[1]);
			System.out.println(" | memo : "+arr[2]);
		}
		
	}

}
