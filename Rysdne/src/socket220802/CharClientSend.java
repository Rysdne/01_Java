package socket220802;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CharClientSend extends Thread {

	DataOutputStream out;

	public CharClientSend(DataOutputStream out) {
		this.out = out;
	}

	public void run() {
		String senddata = "";
		Scanner scan = new Scanner(System.in);

		while (true) {
			try {
				// System.out.print("[클라이언트 메시지 입력]:");
				senddata = scan.nextLine();
				out.writeUTF(senddata);
				if (senddata.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
