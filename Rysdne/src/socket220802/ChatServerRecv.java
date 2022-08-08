package socket220802;

import java.io.DataInputStream;
import java.io.IOException;

// 스레드 클래스 상속
public class ChatServerRecv extends Thread {
	
	// in 객체 선언
	DataInputStream in;

	// 생성자 함수에서 in 객체 사용
	public ChatServerRecv(DataInputStream in) {
		this.in = in;
	}

	@Override
	public void run() {

		String recvdata="";
		// 초기화 반드시 하기
		
		try {
			while (true) {
				recvdata = in.readUTF();
				if (recvdata.equals("exit")) {
					break;
				}
				System.out.println("[클라이언트 메시지]:" + recvdata);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
