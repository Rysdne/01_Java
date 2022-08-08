package jsp220620;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(Integer.parseInt(req.getParameter("cnt")));
		int cnt = Integer.parseInt(req.getParameter("cnt"));

		resp.setContentType("text/html;charset=utf-8");
		// 'UTF-8'일 경우 자동 줄바꿈 안됨
		// ㄴ> <br> 태그로 줄바꿈
		PrintWriter out = resp.getWriter();
		for (int i = 0; i < cnt; i++) {
			out.println("안녕하세요<br>");
		}

	}

}
