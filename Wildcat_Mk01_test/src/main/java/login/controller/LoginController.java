package login.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.service.LoginService;
import login.service.LoginServiceInter;

@WebServlet("/login/*")
public class LoginController extends HttpServlet {

	LoginServiceInter service = new LoginService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] uris = req.getRequestURI().split("/");
		String page = "";
		if (uris.length == 3) {
			page = "login/loginForm.jsp";
		} else {
			if (uris[3].equals("loginForm")) {
				page = "login/loginForm.jsp";
			} else if (uris[3].equals("loginProc")) {
				boolean result = service.login(req, resp);
				if (result) {
					System.out.println("로그인 완료");
					page = "home/main/memo.jsp";
				} else {
					System.out.println("로그인 실패");
					page = "login/loginFailed.jsp";
				}
			}
		}
		req.setAttribute("content", page);
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

	}

}
