package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class IndexController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] uris = req.getRequestURI().split("/");
		if (uris.length < 2) {
			req.setAttribute("page", "home/main.jsp");
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		} else {
			if (uris[1].equals("index")) {
				req.setAttribute("page", "home/main.jsp");
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
			}
		}
	}

}
