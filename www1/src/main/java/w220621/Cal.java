package w220621;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/cal")
public class Cal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 오류사항이 있는 코드
		// int a = Integer.parseInt(req.getParameter("a"));
		// int b = Integer.parseInt(req.getParameter("b"));

		// String을 쓰는 건 이유가 있음
		String _a = req.getParameter("a");
		String _b = req.getParameter("b");
		String op = req.getParameter("op");

		resp.getWriter().println("a : " + _a);
		resp.getWriter().println("op : " + op);
		resp.getWriter().println("b : " + _b);
		
		// 공백인지 아닌지 + 문자로 입력했는지 확인
		int a = 0, b = 0;

		if (!_a.equals("") && _a.matches("-?\\d+(\\.\\d+)?"))
			// if (!_a.equals(""))
			// 이렇게 하면 문자열 입력했을 때 에러남

			a = Integer.parseInt(_a);

		if (!_b.equals("") && _b.matches("-?\\d+(\\.\\d+)?"))
			// if (!_b.equals(""))
			// 이렇게 하면 문자열 입력했을 때 에러남

			b = Integer.parseInt(_b);

		int rs = 0;

		if (op.equals("+")) {
			rs = a + b;
		}
		if (op.equals("-")) {
			rs = a - b;
		}
		if (op.equals("*")) {
			rs = a * b;
		}
		if (op.equals("/")) {
			rs = a / b;
		}
		resp.getWriter().println("result : " + rs);

	}

//	// 참고) 문자열이 숫자인지 확인하는 함수
//	// ㄴ> 아스키 코드 활용
//	public boolean CheckNumber(String str) {
//		char check;
//		if (str.equals("")) {
//			// 문자열이 공백인지 확인
//
//			return false;
//		}
//		for (int i = 0; i < str.length(); i++) {
//			check = str.charAt(i);
//			if (check < 48 || check > 58) {
//				return false;
//			}
//		}
//		return true;
//	}

}
