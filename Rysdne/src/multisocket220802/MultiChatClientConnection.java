package multisocket220802;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatClientConnection extends Thread {

	ServerSocket serversocket;
	// 소켓을 배열 형태로 생성
	Socket[] cs = new Socket[100];
	int cnt = 0;

	public MultiChatClientConnection(ServerSocket serversocket) {
		this.serversocket = serversocket;

	}

	@Override
	public void run() {
		OutputStream os = null;
		DataOutputStream out=null;
		while (true) {
			try {
				System.out.println("서버프로그램[Client 접속 대기중]");
				// 소켓 배열에 사용자 소켓 저장
				// 이때 접속이 너무 빈번하면 에러가 날 수도 있음 
				cs[cnt++] = serversocket.accept();

				// 클라이언트 환영 메시지 송신
				os = cs[cnt - 1].getOutputStream();
				out = new DataOutputStream(os);
				out.writeUTF("서버에 접속하신 것을 환영합니다.");

				System.out.println(cs[cnt - 1].getInetAddress() + "클라이언트가 접속했습니다.");
				System.out.println("현재 접속자 수 : " + cnt);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
