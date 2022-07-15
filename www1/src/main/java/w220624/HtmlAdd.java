package w220624;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/htmlAdd")
public class HtmlAdd extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 화면에 내용 출력
		PrintWriter out = resp.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/htmlAdd\" method=\"post\">");
		out.println("값 입력 : <input type=\"text\" name=\"num\"><br>");
		out.println("<input type=\"submit\" name=\"op\" value=\"+\">");
		out.println("<input type=\"submit\" name=\"op\" value=\"=\">");
		out.println("</form>");
		
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

		} else {
			req.getSession().removeAttribute("servRs");
		}
		out.println("총합 : " + localRs);

		// 세션 내용 삭제
		// req.getSession().removeAttribute("servRs");
		
		// 세션 유지 시간
		// req.getSession().setMaxInactiveInterval(20);
		
		// 세션 해제
		// req.getSession().invalidate();

		out.println("</body>");
		out.println("</html>");

	}

}
