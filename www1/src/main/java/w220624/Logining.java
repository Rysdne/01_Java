package w220624;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Logining extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		// 로그인이 되어있다면
		if (req.getSession().getAttribute("id") != null) {
			req.getSession().getAttribute("id");
			out.println("[" + req.getSession().getAttribute("id") + " 님 환영합니다]");

		} else {
			out.println("계정 정보를 다시 확인하세요");
			resp.sendRedirect("localhost:8080/login.html");
		}
	}

}
