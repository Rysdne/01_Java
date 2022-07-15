package w220624;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notconnect")
public class SessionTest2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("세션 해제 전");
		System.out.println(req.getSession().getAttribute("id"));
		
		// 세션 해제
		req.getSession().invalidate();
		System.out.println("세션 해제 후");
		System.out.println(req.getSession().getAttribute("id"));

	}

}
