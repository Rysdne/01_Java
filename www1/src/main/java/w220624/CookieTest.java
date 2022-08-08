package w220624;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookietest")
public class CookieTest extends HttpServlet {

	// 쿠키 만들기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 쿠키 : 서버에서 생성되어 클라이언트의 웹 브라우저에 저장
		// 클라이언트에게 보낸 후 서버에서 쿠키는 소멸
		// 세션과의 차이점
		// 1) 세션 : 서버에 값을 저장
		// 2) 쿠키 : 클라이언트에 저장

		// 쿠키 생성
		Cookie cookie1 = new Cookie("id", "rysdne");

		// 클라이언트의 웹 브라우저에 쿠키를 전송
		resp.addCookie(cookie1);
		
		// 쿠키 내용 변경(?)
		// 쿠키 객체 자체는 이미 생성되어있기 때문에 이를 그냥 재사용하면 됨
		cookie1=new Cookie("id2", "test");
		resp.addCookie(cookie1);
				
		Cookie cookie2 = new Cookie("pw", "3882");
		resp.addCookie(cookie2);
				
				
	}

}
