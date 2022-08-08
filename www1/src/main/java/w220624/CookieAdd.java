package w220624;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieAdd")
public class CookieAdd extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("op");
		String inputNum = req.getParameter("num");
		int localNum = 0;
		int localRs = 0;

		// 클라이언트 쿠키를 모두 내려받고 서버에 결과값을 저장한 후 사용할 배열 선언
		Cookie[] cookies = req.getCookies();

		// 쿠키값이 있으면(not null)
		if (cookies != null) {
			// Cookie 배열 c에 cookies 내용을 넣고
			for (Cookie c : cookies) {
				// 받은 내용이 servRs에 저장된 내용이면
				if (c.getName().equals("servRs")) {
					// localRs에 숫자형으로 저장함
					localRs = Integer.parseInt(c.getValue());
				}
			}
		}

		if (!inputNum.equals(""))
			localNum = Integer.parseInt(inputNum);

		localRs += localNum;

		if (op.equals("+")) {

			// 서블릿에서 받은 쿠키 값을 cRs에 저장(servRs에는 문자열만 받을 수 있기 때문에 localRs를 문자열 형태로 변환)
			Cookie cookieRs = new Cookie("servRs", String.valueOf(localRs));
			// cookieRs에 저장된 데이터를 출력
			resp.addCookie(cookieRs);
			System.out.println(localRs);
			resp.sendRedirect("http://localhost:8080/cookieAdd.html");

		} else {
			System.out.println("총합 : " + localRs);
			resp.getWriter().println("총합 : " + localRs);

			// 쿠키값을 초기화(?)
			Cookie cookieRs = new Cookie("servRs", "0");
			resp.addCookie(cookieRs);
			System.out.println("저장값 초기화 완료");
		}

	}

}
