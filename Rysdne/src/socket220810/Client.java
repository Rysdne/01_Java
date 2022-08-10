package socket220810;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("192.168.0.54", 11112);
		System.out.println("클라이언트 ");

		OutputStream os = socket.getOutputStream();
		// ObjectOutputStream으로 객체 자체를 전송
		ObjectOutputStream oos = new ObjectOutputStream(os);

		ClassInfo ci = new ClassInfo();
		ci.setId("rysdne");
		ci.setName("굔욷");
		ci.setKor(80);
		ci.setEng(90);
		ci.setMath(100);

		long beforeTime = System.currentTimeMillis();
		System.out.println("before : " + beforeTime);

		DataOutputStream out = new DataOutputStream(os);
		out.writeUTF(String.valueOf(beforeTime));
		out.flush();

		// 객체 전송
		oos.writeObject(ci);
		oos.flush();
		oos.close();
		os.close();
		socket.close();

	}

}
