package jsp220621;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String message = req.getParameter("message");
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		System.out.println("'" + message + "' 문자열을 " + cnt + "번 반복");

		PrintWriter out = resp.getWriter();
		for (int i = 0; i < cnt; i++) {
			out.println(message + "<br>");
		}
	}

}
