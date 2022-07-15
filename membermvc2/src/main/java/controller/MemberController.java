package controller;

// localhost:8080/member -> 메인메뉴 클릭 시 전체 리스트
// localhost:8080/member/findAll -> 전체 리스트
// localhost:8080/member/findOne?idx=9 -> 특정 페이지 요청
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.vo.MemberVO;

// @WebServlet("/member/*")
public class MemberController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("member 진입");
		String[] uris = req.getRequestURI().split("/");
		String page="";

		// 항상 길이 확인이 필요
		if (uris.length == 2) {

		} else {
			
			if (uris[2].equals("findOne")) {

				// .................................................
				// 서비스 부분
				int idx=Integer.parseInt(req.getParameter("idx"));
				System.out.println(idx);
				MemberDAO dao=new MemberDAO();
				MemberVO member=dao.findOne(idx);
				System.out.println(member.toString());
				// .................................................
				// 방향 지정(?)
				req.setAttribute("member", member);
				
				// 최종적으로 원하는 것은 idx가 9인 정보
				// Controller에서는 클래스로 반환만 함
				// 모든 정보는 클래스(MemberVO)에 들어있음
				// 객체는 하나의 정보를 통짜로 가지는 모델(Model)
				
				page="member/findOne.jsp";
				req.setAttribute("page", page);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
				// .................................................
			}
		}
	}

}
