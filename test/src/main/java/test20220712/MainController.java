package test20220712;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		String[] uriValues = uri.split("/");

		String page = "main.jsp";

		if (uriValues.length < 2) {
			// 이게 필요해..?
			// req.setAttribute("page", "main.jsp");
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		} else {

			if (uriValues[1].equals("home")) {
				if (uriValues[2].equals("main1")) {
					page = "main1.jsp";
				}
				if (uriValues[2].equals("main2")) {
					page = "main2.jsp";
				}
				if (uriValues[2].equals("main3")) {
					page = "main3.jsp";
				}
				if (uriValues[2].equals("main4")) {
					page = "main.jsp";
				}
				req.setAttribute("page", page);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

			} else if (uriValues[1].equals("login")) {
			} else if (uriValues[1].equals("board")) {
			}

		}

	}

}
