package jsp220620;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumProc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String _first = req.getParameter("first");
		String _second = req.getParameter("second");
		int first = Integer.parseInt(_first);
		int second = Integer.parseInt(_second);
		int sum = first + second;

		System.out.println(sum);

		resp.setContentType("text/html;charset=utf-8");

		PrintWriter printout = resp.getWriter();
		printout.print("결과값 : " + sum);

	}

}
