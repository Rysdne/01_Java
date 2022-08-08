
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProc extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// was 콘솔 출력
		// 콘솔로 받을 때 이 코드로 해달라는 것을 알려줌
		// req.setCharacterEncoding("utf-8");
		String message = req.getParameter("message");
		System.out.println(message);

		// 받은 메시지는 "message"
		// 클라이언트에게 보내는 메시지(페이지)
		// 클라이언트가 보낼 때 이 코드로 보내라는 것을 미리 알려줌
		// resp.setCharacterEncoding("utf-8");

		
		// 클라이언트가 해석하기 위한 코드 알려줌 
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("your send message " + message);
		out.println("전달받은 메시지는 " + message + "입니다");

	}

}
