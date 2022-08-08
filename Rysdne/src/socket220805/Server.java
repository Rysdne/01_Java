package socket220805;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//서버, 클라이언트, 클라이언트가 서버에 접속, 
//서버는 소켓을 생성하고 내보내는 스트림(outputstream)으로 클라이언트에게 데이터 바로 전송

public class Server {

	public static void main(String[] args) throws Exception {
			ServerSocket server=new ServerSocket(11112);
			System.out.println("서버 접속대기중...... ");
			Socket client=server.accept();
			System.out.println("클라이언트 접속 ");

			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			Member member = (Member) ois.readObject();
			String id = member.getId();
			String password = member.getPassword();
			System.out.println("id : " + id + "\npwd : " + password);
			
			// MemberDAO.getInstance().insert(member);
			
			ois.close();
			is.close();
			client.close();
			server.close();
		
	}

}
