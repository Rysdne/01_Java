package www;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProc extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("www package");
		String message = req.getParameter("message");
		System.out.println(message);
	}

}
