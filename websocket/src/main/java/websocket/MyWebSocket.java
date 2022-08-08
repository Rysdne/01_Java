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
public class MyWebSocket {

	// 세션을 생성하는 클라이언트 정보 저장할 변수 선언
	// 다른 함수도 사용할 수 있도록 필드에 선언
	// 배열로 저장할 경우 여러 클라이언트 정보 저장 가능
	Session session;

	// 기본적으로 들어가야 하는 함수가 아래 4개
	@OnOpen
	public void handleOpen(Session session) {
		this.session = session;
	}

	@OnClose
	public void handleClose() {

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
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
