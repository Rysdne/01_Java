package multisocket220802;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiServerChat {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);

			// 한 번만 만들어지기 때문에 스레드로 할 필요가 없음
			ServerSocket serversocket = new ServerSocket(11111);

			// 여러 사용자의 접속을 구현하기 위해 스레드로 변경
			// 반복할 내용을 함수에 투입
			MultiChatClientConnection clientsocket = new MultiChatClientConnection(serversocket);

			clientsocket.start();

			// @ 클라이언트 끼리의 채팅

			// Recv, Send를 통합한 Proc 스레드 생성
			// 계속 동작하는 기능을 스레드로 만들어야 함
			// ㄴ> in 객체가 지속되어야 함
			MultiChatServerProc serverproc = new MultiChatServerProc(clientsocket.cs, clientsocket.cnt);

			serverproc.start();

			// 순서대로 간다면 아래 close에서 끊김
			// 스레드가 종료되었는지 확인하고 빠져나가는 작업 수행
//			while (true) {
//				if (!serverrecv.isAlive() || !serversend.isAlive()) {
//					break;
//				}
//			}
//
//			// end while : 클라이언트와 채팅 종료
//			out.close();
//			os.close();
//			in.close();
//			is.close();
//
//			client.close();
//			server.close();
//
//			System.out.println("채팅 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
