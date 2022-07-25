package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PhonebookService;
import service.PhonebookServiceInter;
import vo.PageList;

@WebServlet("/findAll")
public class PhonebookController extends HttpServlet {

	// 얘는 여따가 선언하는게 더 나음
	// PhonebookService service = new PhonebookService();
	PhonebookServiceInter service = new PhonebookService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 지금은 바로 WebServlet으로 들어오게 할거라서 아래 내용이 필요 없음
		// String[] uris=req.getRequestURI().split("/");

		// PhonebookService service = new PhonebookService();
		PageList pagelist = service.pageList(req, resp);
		// pageList 내부에는 findAll.jsp에 필요한 모든 데이터가 저장됨
		// 이 부분이 중요함, 데이터를 jsp에 넘기려면 반드시 setAttribute를 해줘야 함
		req.setAttribute("pagelist", pagelist);
		req.getRequestDispatcher("/WEB-INF/findAll.jsp").forward(req, resp);

	}

}
