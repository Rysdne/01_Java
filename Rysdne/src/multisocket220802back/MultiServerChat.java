package multisocket220802back;

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

			// Recv 스레드 생성
			// 계속 동작하는 기능을 스레드로 만들어야 함
			// ㄴ> in 객체가 지속되어야 함
			MultiChatServerRecv serverrecv = new MultiChatServerRecv(clientsocket.cs, clientsocket.cnt);
			// 마우스 호버 후 클래스 생성
			// 마우스 호버 후 생성자 함수 생성

			// ===========================
			// 명령문은 ChatServerRecv에서 확인
			// ===========================

			// Send 스레드 생성
			// ㄴ> out 객체가 지속되어야 함
			MultiChatServerSend serversend = new MultiChatServerSend(clientsocket.cs,clientsocket.cnt);

			// ===========================
			// 명령문은 ChatServerSend에서 확인
			// ===========================

			// Recv와 Send 기능이 별개의 스레드로 구성됨
			// 서로 순서를 기다릴 필요가 없음

			serverrecv.start();
			serversend.start();

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
