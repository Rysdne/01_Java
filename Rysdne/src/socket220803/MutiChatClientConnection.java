package socket220803;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MutiChatClientConnection extends Thread{
	ServerSocket serversocket;
	
	// 정보를 저장하기 위한 공간(클라이언트 소켓의 정보를 배열로 가지고 있다)
	Socket[] cs=new Socket[100];
	int cnt=0;
	// 접속된 수
	public MutiChatClientConnection(ServerSocket serversocket) {
		this.serversocket=serversocket;
	}

	@Override
	public void run() {
		
		while(true) {
		try {
		System.out.println("서버프로그램[클라이언트 접속 대기중]");

		// 접속한 클라이언트에 대한 스레드 실행
		cs[cnt]=serversocket.accept();
		
		// 특정 소켓에 데이터를 송수신하는 역할
		System.out.println("cnt:"+cnt);
 		CSThread cst=new CSThread(cs[cnt],this);
 		// this : 현재 클래스
 		// Socket[] cs와 int cnt 정보가 담긴 현재 클래스 전체를 보내줌
 		
		cst.start();
		
		OutputStream os=cs[cnt].getOutputStream();
		DataOutputStream out=new DataOutputStream(os);
		out.writeUTF("서버에 접속하신 것을 환영합니다.");
		
		System.out.println(cs[cnt].getInetAddress()+"클라이언트가 접속했습니다.");
		cnt++;
		System.out.println("현재접속자수:"+cnt);
		
		//out.close();
		//os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
}
