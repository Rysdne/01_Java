package w220622;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputProc
 */
@WebServlet("/inputProc")
public class InputProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		// 1. Checkbox
//		String[] hobby = request.getParameterValues("hobby");
//
//		request.setCharacterEncoding("UTF-8");
//		// 이게 필터랑 해서 두 번 들어가야 하는지는 의문
//		
//		response.setContentType("text/html;charset=utf-8");
//
//		PrintWriter out = response.getWriter();
//
//		for (String a : hobby) {
//			System.out.println(a);
//			out.println("취미 : " + a + "<br>");
//		}

//		// 2. Select
//		String cars = request.getParameter("cars");
//		System.out.println(cars);
//		PrintWriter out = response.getWriter();
//		out.println(cars);

//		// 3. Radio
//		String sel=request.getParameter("sel");
//		System.out.println(sel);
//		PrintWriter out=response.getWriter();
//		out.println(sel);
		

		// 9. test
		// html에서 name 값을 test로 변경하면서 하나씩 실행해보기 
		String test=request.getParameter("test");
		System.out.println(test);
		PrintWriter out=response.getWriter();
		out.println(test);

		
	}

}
