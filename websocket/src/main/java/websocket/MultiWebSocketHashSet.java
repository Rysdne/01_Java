package websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// 웹소켓 접근용 서블릿
// @ServerEndpoint("/wsocket")
public class MultiWebSocketHashSet {

	// 세션 저장용 배열 선언
	// 이걸 하나의 클라이언트에서 사용하는 것이 아니기 때문에 static으로 정의해서 어느 클라이언트에서나 변경할 수 있도록 함
	static Set<Session> sessions = new HashSet<Session>();

	// 기본적으로 들어가야 하는 함수가 아래 4개
	@OnOpen
	public void handleOpen(Session session) {
		// 세션 들어올 때마다 세션 정보 저장
		System.out.println("접속자 수 : " + sessions.size());
		sessions.add(session);

		try {
			Iterator<Session> sess = sessions.iterator();
			while (sess.hasNext()) {
				Session s = sess.next();
				s.getBasicRemote().sendText("11:" + sessions.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@OnClose
	public void handleClose(Session session) {
		// 세션 종료할 때마다 세션 정보 저장
		sessions.remove(session);
		try {
			Iterator<Session> sess = sessions.iterator();
			while (sess.hasNext()) {
				Session s = sess.next();
				s.getBasicRemote().sendText("11:" + sessions.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@OnError
	public void handleError(Throwable error) {

	}

	// 메시지를 받을 때 동작할 함수 생성
	@OnMessage
	public void recvMessage(String message) {

		try {

//			//	for (int i = 0; i < cnt; i++) {
//			//		System.out.println("i : " + i);
//			//		sessions[i].getBasicRemote().sendText(message);
//			//	}

			// 메시지 형식(프로토콜)
			// 00:아이디 -> 00:admin / 11:접속자 수 -> 11:100

			Iterator<Session> sess = sessions.iterator();
			while (sess.hasNext()) {
				Session s = sess.next();
				s.getBasicRemote().sendText("00:" + message);
				s.getBasicRemote().sendText("11:" + sessions.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
