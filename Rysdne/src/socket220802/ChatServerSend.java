package socket220802;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ChatServerSend extends Thread{
	DataOutputStream out;

	public ChatServerSend(DataOutputStream out) {
		this.out = out;
	}

	public void run() {

		Scanner scan = new Scanner(System.in);
		String senddata = "";
		while (true) {

			try {
				// System.out.print("[서버 메시지 입력]:");
				senddata = scan.nextLine();
				if (senddata.equals("exit")) {
					break;
				}
				out.writeUTF(senddata);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
