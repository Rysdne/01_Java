
import java.security.Provider.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProc extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) {

		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		System.out.println(id);
		System.out.println(pw);
	}

	

}
