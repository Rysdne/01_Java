package test;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import test.Sungjuk;

public class Client {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("127.0.0.1", 23882);
		System.out.println("클라이언트");

		OutputStream os = socket.getOutputStream();

		ObjectOutputStream oos = new ObjectOutputStream(os);

		Sungjuk sj = new Sungjuk();
		sj.setId("rysdne");
		sj.setName("굔욷");
		sj.setKor(80);
		sj.setEng(80);
		sj.setMath(80);
		
		oos.writeObject(sj);
		oos.flush();
		oos.close();
		os.close();
		socket.close();
		
	}
}
