package socket220805;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("192.168.0.51", 11112);
		System.out.println("클라이언트 ");

		OutputStream os = socket.getOutputStream();
		// ObjectOutputStream으로 객체 자체를 전송
		ObjectOutputStream oos = new ObjectOutputStream(os);

		Member member = new Member();
		member.setId("rysdne");
		member.setPassword("3882");

		long beforeTime = System.currentTimeMillis();
		System.out.println("before : " + beforeTime);

		DataOutputStream out = new DataOutputStream(os);
		out.writeUTF(String.valueOf(beforeTime));
		out.flush();

		// 객체 전송
		oos.writeObject(member);
		oos.flush();
		oos.close();
		os.close();
		socket.close();

	}

}
