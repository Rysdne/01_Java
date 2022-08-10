package socket220810;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(11112);
		System.out.println("서버 접속대기중...... ");
		Socket client = server.accept();
		System.out.println("클라이언트 접속 ");

		InputStream is = client.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);

		DataInputStream in = new DataInputStream(is);
		String recvTime = in.readUTF();
		long beforeTime = Long.valueOf(recvTime);

		long afterTime = System.currentTimeMillis();
		long diffTime = afterTime - beforeTime;
		System.out.println("전송시간 : " + diffTime + "ms");

		ClassInfo ci = (ClassInfo) ois.readObject();

		String id = ci.getId();
		String password = ci.getName();
		int kor = ci.getKor();
		int eng = ci.getEng();
		int math = ci.getMath();
		System.out.println("id : " + id + "\npwd : " + password);

		ClassInfoDAO.getInstance().insert(ci);

		ois.close();
		is.close();
		client.close();
		server.close();

	}

}
