package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member/*")
//@WebServlet("/*")
public class MbController2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member all 접근");
		String uri=req.getRequestURI();
		String [] uris=uri.split("/");
		
//		// /member/test.do에 접속한다고 가정한 뒤 실습
//		// test.do가 배열의 세번째, 인덱스(??)는 두번째를 의미(???)
//		System.out.println(uris[2].indexOf('.'));
//		System.out.println(uris[2].lastIndexOf('.'));
		
	}
}
