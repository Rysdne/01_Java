package socket220802;

import java.io.DataInputStream;
import java.io.IOException;

public class CharClientRecv extends Thread{

	DataInputStream in;

	public CharClientRecv(DataInputStream in) {
		this.in = in;
	}

	public void run() {
		String recvdata = "";

		while (true) {
			try {
				recvdata = in.readUTF();
				if (recvdata.equals("exit")) {
					break;
				}
				System.out.println("[서버 메시지]:" + recvdata);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}