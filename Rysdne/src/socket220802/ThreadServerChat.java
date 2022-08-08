package socket220802;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadServerChat {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);

			ServerSocket server = new ServerSocket(11111);

			while (true) {
				System.out.println("서버프로그램[대기중]");
				Socket client = server.accept();
				System.out.println("클라이언트가 접속했습니다.");

				OutputStream os = client.getOutputStream();
				DataOutputStream out = new DataOutputStream(os);
				out.writeUTF("서버에 접속하신 것을 환영합니다.");

				InputStream is = client.getInputStream();
				DataInputStream in = new DataInputStream(is);

				// @ 서버와 클라이언트와의 채팅
								
				// Recv 스레드 생성
				// 계속 동작하는 기능을 스레드로 만들어야 함
				// ㄴ> in 객체가 지속되어야 함
				ChatServerRecv serverrecv = new ChatServerRecv(in);
				// 마우스 호버 후 클래스 생성
				// 마우스 호버 후 생성자 함수 생성

				// ===========================
				// 명령문은 ChatServerRecv에서 확인
				// ===========================

				// Send 스레드 생성
				// ㄴ> out 객체가 지속되어야 함
				ChatServerSend serversend = new ChatServerSend(out);

				// ===========================
				// 명령문은 ChatServerSend에서 확인
				// ===========================

				// Recv와 Send 기능이 별개의 스레드로 구성됨
				// 서로 순서를 기다릴 필요가 없음

				serverrecv.start();
				serversend.start();

				// 순서대로 간다면 아래 close에서 끊김
				// 스레드가 종료되었는지 확인하고 빠져나가는 작업 수행
				while (true) {
					if (!serverrecv.isAlive()||!serversend.isAlive()) {
						break;
					}
				}

				// end while : 클라이언트와 채팅 종료
				out.close();
				os.close();
				in.close();
				is.close();

				client.close();
				server.close();

				System.out.println("채팅 종료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
