package websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// 웹소켓 접근용 서블릿
// @ServerEndpoint("/wsocket")
public class MultiWebSocket {

	// 세션 저장용 배열 선언
	// 이걸 하나의 클라이언트에서 사용하는 것이 아니기 때문에 static으로 정의해서 어느 클라이언트에서나 변경할 수 있도록 함
	static Session[] sessions = new Session[100];
	static int cnt = 0;

	// 기본적으로 들어가야 하는 함수가 아래 4개
	@OnOpen
	public void handleOpen(Session session) {
		// 세션 들어올 때마다 세션 정보 저장
		System.out.println(session);
		sessions[cnt++] = session;
		System.out.println("cnt : " + cnt);

	}

	@OnClose
	public void handleClose(Session session) {
		// 세션 종료할 때마다 세션 정보 저장
		System.out.println(session);
	}

	@OnError
	public void handleError(Throwable error) {

	}

	// 메시지를 받을 때 동작할 함수 생성
	@OnMessage
	public void recvMessage(String message) {
		System.out.println(message);

		// 메시지에 대한 답변 송신을 위해 전송 스레드 생성
		// Answer answer = new Answer(message, session);
		// answer.start();
		// 문제는 질문 하나에 한 답변밖에 못함

		try {
			// 세션에서 받아온 텍스트를 반환
			for (int i = 0; i < cnt; i++) {
				System.out.println("i : " + i);
				sessions[i].getBasicRemote().sendText(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
