package datawebsocket;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;

@ServerEndpoint("/datawsocket")
public class DataWebsocket3 {
	static Set<Session> sessions = new HashSet<Session>();
	static int[] arr = { 0, 0, 0, 0 };

	@OnOpen
	public void handleOpen(Session session) {
		sessions.add(session);
		
		// 아래 부분을 JSON 형태로 바꿔서 전송
		
//		StringBuffer msg = new StringBuffer("");
//		for (int i : arr) {
//			// 정수형을 문자형으로 형변환
//			msg.append(String.valueOf(i) + ":");
//		}
//		msg.delete(msg.length() - 1, msg.length());
//		
//		try {
//			session.getBasicRemote().sendText(msg.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}


		
		
		
	}

	@OnClose
	public void handleClose(Session session) {
		sessions.remove(session);
	}

	@OnError
	public void handleError(Throwable th) {

	}

	@OnMessage
	public void handleMessage(String message) {
		System.out.println("신호보냄");
		// String[] data = { "1", "2", "3", "4" };

		try {
			// sendText는 문자열만 들어감
			// session.getBasicRemote().sendText("문자열");
			// session.getBasicRemote().sendObject(data);
			// session.getBasicRemote().sendText(arr.toString());
			for (int c = 0; c < arr.length; c++) {
				if (Integer.parseInt(message) == (c + 1)) {
					arr[c]++;
				}
			}
			StringBuffer msg = new StringBuffer("");
			for (int i : arr) {
				// 정수형을 문자형으로 형변환
				msg.append(String.valueOf(i) + ":");
			}
			msg.delete(msg.length() - 1, msg.length());

			// ----- 데이터 송신-------------------------------------------
			Iterator<Session> sess = sessions.iterator();
			while (sess.hasNext()) {
				Session s = sess.next();
				s.getBasicRemote().sendText(msg.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
