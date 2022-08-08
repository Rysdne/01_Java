package w220624;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookierecv")
public class CookieRecv extends HttpServlet {

	// 쿠키 받아오기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 쿠키 받아오기
		// 장바구니 원리임
		// 모든 쿠키값을 배열 형태로 받아오기
		// getCookies() 자체가 배열 형태
		Cookie[] cookies = req.getCookies();

		// 생성된 쿠키가 있는지 없는지 확인
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println(c.getName() + " : " + c.getValue());
			}
			
		}

	}

}
