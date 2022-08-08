package multisocket220802back;

import java.net.Socket;

public class MultiChatServerRecv extends Thread {

	// 배열 크기를 설정해줘야 함
	Socket[] cs = new Socket[100];
	int cnt;

	public MultiChatServerRecv(Socket[] cs, int cnt) {
		this.cs = cs;
		this.cnt = cnt;
	}

	@Override
	public void run() {
		while (true) {
			
		}
	}

}
