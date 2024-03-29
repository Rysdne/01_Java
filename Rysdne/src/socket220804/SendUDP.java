package socket220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendUDP {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket ds = new DatagramSocket();

		// 우체통 - 이 소켓을 통해 데이터가 전송된다
		while (true) {
			// 데이터를 계속 반복하기 위해 무한 루프
			System.out.print(" 보낼 물건  = ");
			String msg = in.readLine();
			for (int i = 2; i < 254; i++) {
				// 다중의 사용자에게 메시지를 무작위로 발송하기 위한 방식으로 현재 IP 주소의 네트워크 그룹에 속한 모든 사용자에게 메시지 발송
				InetAddress ia = InetAddress.getByName("192.168.0." + i);
				// 앞자리 세군데는 고정시키고 마지막자리수만 바꿔주면서 발송
				// 1번 IP주소는 일반적으로 게이트웨이용으로 많이 사용하고 255번 IP주소는 브로드캐스트용으로 사용하기 떄문에 발송 하지 않음
				// 소포를 포장하면서 보내는 내용의 크기, 도착할 주소와 포트를 기재
				DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, 6999);

				ds.send(dp); // 패킷 전송
			}
			System.out.println("전송완료~!!");
		}
	}

}
