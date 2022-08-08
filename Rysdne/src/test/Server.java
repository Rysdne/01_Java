package test;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(23882);
		System.out.println("Server is sleeping....");
		Socket client = server.accept();
		System.out.println("Awaken");

		InputStream is = client.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);

		Sungjuk sj = (Sungjuk) ois.readObject();
		String id = sj.getId();
		String password = sj.getName();
		int kor = sj.getKor();
		int eng = sj.getEng();
		int math = sj.getMath();

		System.out.println(sj.toString());
		
		SungjukDAO.getInstance().insert(sj);

		ois.close();
		is.close();
		client.close();
		server.close();
		
	}

}
