package socket220804;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class RecvUDP {

	public static void main(String args[]) throws IOException {

		DatagramSocket ds = new DatagramSocket(6999);
		while (true) {
			byte[] data = new byte[65508];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			ds.receive(dp);
			System.out.println(dp.getAddress().getHostAddress() + " >> " + new String(dp.getData()).trim());
		}
	}

}
