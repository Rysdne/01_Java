package w220624;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginProc")
public class LoginProc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		PrintWriter out = resp.getWriter();

		if (id.equals("admin") && pw.equals("1234")) {
			req.getSession().setAttribute("id", id);
			out.println("[" + req.getSession().getAttribute("id") + " 님 환영합니다]");

		} else {
			System.out.println("해당 계정은 존재하지 않습니다");
			resp.sendRedirect("localhost:8080/login.html");

		}

	}

}
