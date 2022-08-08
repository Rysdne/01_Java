package socket220803;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CSThread extends Thread {
	Socket socket;
	MutiChatClientConnection mc;

	public CSThread(Socket socket, MutiChatClientConnection mc) {
		this.socket = socket;
		this.mc = mc;
		System.out.println("cstread:" + mc.cnt);
	}

	@Override
	public void run() {

		// 데이터가 특정 소켓으로 수신되면 모든 클라이언트 소켓에 데이터 전송
		InputStream is = null;
		DataInputStream in = null;
		String recvdata = "";
		while (true) {
			try {
				// 데이터 수신 기능
				is = socket.getInputStream();
				in = new DataInputStream(is);
				recvdata = in.readUTF();
				//////////
				System.out.println("cstread run:" + mc.cnt);

				// 모든 클라이언트 소켓에 데이터 송신 기능
				for (int i = 0; i < mc.cnt; i++) {

					// 자신의 입력 메시지는 나한테는 오면 안됨
					// socket과 mc.cs[i]가 같지 않은 메시지만 수신
					if (socket != mc.cs[i]) {
						OutputStream os = mc.cs[i].getOutputStream();
						DataOutputStream out = new DataOutputStream(os);
						out.writeUTF("[" + socket.getInetAddress() + "]" + recvdata);
					}
				}
				///////
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
