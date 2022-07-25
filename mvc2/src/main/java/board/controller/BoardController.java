package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceInter;
import board.vo.BoardVO;
import board.vo.PageList;
import login.vo.MemberVO;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	BoardServiceInter service = new BoardService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] uris = req.getRequestURI().split("/");
		String page = "board/";

		// 로그인이 되지 않은 경우 login 페이지 이동
		if (req.getSession().getAttribute("id") == null) {
			page = "/login/login.jsp";

			// 아닌 경우 board 관련 명령 처리
		} else {
			if (uris[2].equals("list")) {
				PageList pagelist = service.pageList(req, resp);
				req.setAttribute("pagelist", pagelist);
				page += "pageList.jsp";

			} else if (uris[2].equals("findOne")) {
				BoardVO board = service.findOne(req, resp);
				req.setAttribute("board", board);
				page += "pageList.jsp";
			} else if (uris[2].equals("writeForm")) {
//				String id = (String) req.getSession().getAttribute("id");
//				MemberVO member = service.findOne(id);
//				req.setAttribute("member", member);
				page += "writeForm.jsp";
			}
		}

		req.setAttribute("page", page);
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}
