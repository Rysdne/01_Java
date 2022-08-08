package w220623;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/datashare1")
public class DataShare1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		// String title = "study servlet";
		// out.println(title + "<br>");
		ServletContext application=req.getServletContext();
		out.println(application.getAttribute("title")+"<br>");
		
		out.println("datashare1");

		// DataShareFile을 한 번 실행시킨 후에는 데이터 공유
		
	}

}
