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

import member.service.MemberServiceInter;
import member.vo.MemberService;
import member.vo.MemberVO;

@WebServlet("/member/*")
public class MemberController3 extends HttpServlet {

	
	// 스프링에서는 객체를 생성하지 않고 어노테이션으로 보내줌
	// @Service
	// MemberService service;
	MemberServiceInter service = new MemberService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("member 진입");
		String[] uris = req.getRequestURI().split("/");
		String page = "member/";

		// 항상 길이 확인이 필요
		if (uris.length == 2) {

		} else {

			if (uris[2].equals("findOne")) {

				// .................................................
				// 서비스 부분
				// 아래 붙여넣으면서 아예 사라짐
				// .................................................
				// 방향 지정(?)
				req.setAttribute("member", service.findOne(req, resp));
				req.setAttribute("page", page+="findOne.jsp");
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
				// .................................................
			} else if (uris[2].equals("findAll")) {

					req.setAttribute("memberlist", service.findAll(req, resp));
					req.setAttribute("page", page+="findAll.jsp");
					req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
					// .................................................

				}
			}
		}
	}
