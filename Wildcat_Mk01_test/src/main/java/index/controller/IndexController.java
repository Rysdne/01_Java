package index.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import index.service.IndexService;
import index.service.IndexServiceInter;

@WebServlet("/")
public class IndexController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IndexServiceInter indexService = new IndexService();
		indexService.init();
		String id = null;
		if (req.getSession().getAttribute("id") == null) {
			req.setAttribute("content", "login/loginForm.jsp");
		} else {
			req.setAttribute("content", "home/main/memo.jsp");
		}
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

	}
}
