package socket220804;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPfileSend {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream dis = null;
		
		System.out.print("전송대상 = "); //파일을 전송하려는 곳의 IP 주소를 기재한다.
		String ip = in.readLine(); 
		System.out.print("전송파일 = "); 
		//전송하려는 파일명을 기재한다. 만약 다른경로에 있는 파일을 전송하려면 전체 경로를 적어야한다
		// ex) C:\java\eclipse\workspace\Round25_Ex03.java
		// String filename = in.readLine();
		String filename = "C:\\Users\\Rysdne\\Desktop\\test.txt";
		
		File file = new File(filename); //파일 객체 생성
		if (!file.exists()) { // 파일이 존재하는지 그 유무를 먼저 판단.
			System.err.println("파일이 존재하지 않습니다");
			System.exit(-1);//파일이 없으면 송신프로그램 종료
		}
		DatagramSocket ds = new DatagramSocket(); //파일을 전송할 소켓 객체를 생성 
		InetAddress ia = InetAddress.getByName(ip); //전송받을 곳의 IP주소를 InetAddress 객체로 생성
		//'start' 라는 글자를 먼저 전송하여 파일의 전송 시작을 목적지 컴퓨터에게 알려준다. 이것이 전송되면 목적지 컴퓨터에서는 
		// 임의의 이름으로 파일을 생성하고 입력받을 준비를 한다.
		String str = "start";
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 7777);
		ds.send(dp);
		
		//실제 파일의 내용을 읽어 목적지 컴퓨터로 전송한다. 일반적으로 전송하는 단위는 512byte 나 1,024byte로 전송하는 것이 가장 효율적
		//그러나 여기에서는 최대 byte 수인 65,508byte로 전송하였다.
		dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		byte[] by = new byte[65508]; // 실무에서는 주로 256 byte, 512 byte 단위로 보냄
		
		while(true) {
			int xx = dis.read(by, 0, by.length);
			if (xx == -1)break;
			dp = new DatagramPacket(by, xx, ia, 7777);
			ds.send(dp);
		}
		
		//end라는 글자를 전송하여 모든 파일이 전송되었음을 알려준다. 그럼 목적지 컴퓨터에서는 해당파일을 닫을 것 이다.
		str = "end";
		dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 7777);
		ds.send(dp);
		ds.close();
		System.out.print("전송완료~!!");
	}
}
