package w220623;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addnEqualSession")
public class AddnEqualSession extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 1. 세션 간 데이터 공유 제한
		// getServletContext() -> req.getSession()
		String op = req.getParameter("op");
		String inputNum = req.getParameter("num");
		int localNum = 0;
		int localRs = 0;

		if (!inputNum.equals(""))
			localNum = Integer.parseInt(inputNum);

		if (!(req.getSession().getAttribute("servRs") == null))
			localRs = (int) req.getAttribute("servRs");

		localRs += localNum;

		if (op.equals("+")) {
			req.getSession().setAttribute("servRs", localRs);
			System.out.println(localRs);
			resp.sendRedirect("http://localhost:8080/AddnEqualSession.html");

		} else {
			System.out.println("총합 : " + localRs);
			resp.getWriter().println("총합 : " + localRs);

			req.getSession().removeAttribute("servRs");
			System.out.println("저장값 초기화 완료");
		}

		// 세션 내용 삭제
		// req.getSession().removeAttribute("servRs");
		
		// 세션 유지 시간
		// req.getSession().setMaxInactiveInterval(20);
		
		// 세션 해제
		// req.getSession().invalidate();
		
	}

}
