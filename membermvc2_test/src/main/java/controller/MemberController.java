package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.vo.MemberVO;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("member 진입");

		String[] uris = req.getRequestURI().split("/");
		String page = "";

		if (uris.length == 2) {
		} else {
			if (uris[2].equals("findOne")) {

				int idx = Integer.parseInt(req.getParameter("idx"));
				System.out.println(idx);
				MemberDAO dao = new MemberDAO();
				MemberVO member = dao.findOne(idx);
				req.setAttribute("member", member);
				System.out.println(member);
				
				page = "member/findOne.jsp";
				req.setAttribute("page", page);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

			}
		}

	}

}
