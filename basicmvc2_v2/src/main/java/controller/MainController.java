package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		// 종류
//		String realpath = req.getRealPath("/home");
//		System.out.println("realpath : " + realpath);
//
//		String uri = req.getRequestURI();
//		System.out.println("uri : " + uri);
//
//		StringBuffer url = req.getRequestURL();
//		System.out.println("url : " + url);
//
//		String contextpath = req.getContextPath();
//		System.out.println("contextpath : " + contextpath);

//		// 1. URI
//		// 1) 해석
//		String uri = req.getRequestURI();
//		// uri="/home/header"
//		
//		// Split 함수를 이용하여 "/" 기준으로 분리 가능
//		String[] uris=uri.split("/");
//		for(String s:uris) {
//			System.out.println(s);
//		}

//		// 2) 길이 확인 
//		String uri = req.getRequestURI();
//		String[] uris=uri.split("/");
//		int length=uris.length;
//		System.out.println(length);
//		
//		// uri="/" -> 0
//		// "/" 자체를 디렉터리로 치질 않아서 0(?)
//		// uri="/index" -> 2
//		// "/" + "index"
//		// uri="/home/login" -> 3
//		// uri="/home/member" -> 3
//		// uri="/board/findAll" -> 3
//
//		// 뭔가 여기부터 명령어가 동작하지 않음
//		// 처음 호출한 게 uris[] 배열인데..
//		System.out.println("uris[0] : "+uris[0]);
//		// 공란 저장
//		System.out.println("uris[1] : "+uris[1]);
//		System.out.println("uris[2] : "+uris[2]);
//		// 다음부터 저장

//		// 3) 서블릿 해석
//		// 배열로 저장된 uris[]를 바탕으로 경로 명령어 생성 가능
//		String uri = req.getRequestURI();
//		String[] uris = uri.split("/");
//		String page="";
//
//		if (uris[2].equals("main1")) {
//			page="main1.jsp";
//		}else if (uris[2].equals("main2")) {
//			page="main2.jsp";
//		}else if (uris[2].equals("main3")) {
//			page="main3.jsp";
//		}
//		req.getRequestDispatcher("/WEB-INF/home/"+page).forward(req, resp);
//		

//		// 3-1) 한 번에 한 페이지밖에 표현할 수 없는 코드
//		// ㄴ> jsp:include를 사용하여 페이지 포함 시 문제 발생
//		// 3-1) uris의 길이가 2보다 작을 때는 localhost:8080/ -> index.jsp로 가도록 설정
//		// 3-2) uris의 길이가 2일 때

//		// 3-1) 모델
//		// page를 모델로 생각(처리 및 저장)
//		String uri = req.getRequestURI();
//		String[] uris = uri.split("/");
//		String page="";
//
//		if (uris[2].equals("main1")) {
//			page="main1.jsp";
//		}else if (uris[2].equals("main2")) {
//			page="main2.jsp";
//		}else if (uris[2].equals("main3")) {
//			page="main3.jsp";
//		}
//
//		// key와 value로 모델을 전달
//		// index.jsp의 jsp:include main 부분에서 page를 전달받도록 함 
//		req.setAttribute("page", page);
//		// 이렇게 되면 header, main, footer 모두 표현 가능 
//		
//		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

		// 3-2) 배열 길이 설정
		String uri = req.getRequestURI();
		String[] uris = uri.split("/");

		if (uris.length < 2) {
			// resp.sendRedirect("/");
			req.setAttribute("page", "main.jsp");
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		} else {
			
			// 첫 번째 항목에 카테고리가 세분화되어있을 경우를 상정
			// /home /login /board
			// 근데 사실 이렇게 하는 것보다 그냥 부분 부분으로 나눠서 page를 받아오는게 더 나을 듯
			if (uris[1].equals("home")) {
				
				String page = "main.jsp";
				
				if (uris[2].equals("main1")) {
					page = "main1.jsp";
				} else if (uris[2].equals("main2")) {
					page = "main2.jsp";
				} else if (uris[2].equals("main3")) {
					page = "main3.jsp";
				}
				req.setAttribute("page", page);
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);


			} else if (uris[1].equals("login")) {

			} else if (uris[1].equals("board")) {

			}
		}
		

	}

}
