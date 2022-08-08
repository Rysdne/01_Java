package multisocket220802;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MultiChatServerProc extends Thread {

	// 배열 크기를 설정해줘야 함
	Socket[] cs = new Socket[100];
	int cnt;

	public MultiChatServerProc(Socket[] cs, int cnt) {
		this.cs = cs;
		this.cnt = cnt;
	}

	@Override
	public void run() {
		OutputStream os = null;
		DataOutputStream out = null;

		InputStream is = null;
		DataInputStream in = null;

		while (true) {
			try {
				for (int i = 0; i < cnt - 1; i++) {

					is = cs[i].getInputStream();
					in = new DataInputStream(is);

					String recvdata = in.readUTF();

					for (int j = 0; j < cnt - 1; j++) {
						os = cs[j].getOutputStream();
						out = new DataOutputStream(os);

						out.writeUTF(recvdata);

					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
