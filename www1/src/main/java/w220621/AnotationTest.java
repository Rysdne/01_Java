package w220621;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml에서 설정했던 것들이 이걸로 끝남..
// ㄴ> 서블릿 등록 + 매핑 작업
@WebServlet("/test")
public class AnotationTest extends HttpServlet {
	
	// init() -> service() -> [doGet()|doPost()]
	// ㄴ> 서블릿의 생명주기(동작순서)

	int count = 0;

	// 1. init()
	// - 1번만 실행됨
	// - 다른 애들은 새로고침할 때마다 증가하지만 init은 증가하지 않음
	@Override
	public void init() throws ServletException {
		System.out.println("init function" + (count++));
	}

	// 2. service()
	// - 새로고침할 때마다 실행됨
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("anotation test");
		// resp.getWriter().println("anotation test");
		System.out.println("exe service");
		out.println("exe service" + (count++));

		// super : 부모 클래스 호출
		//
		// super.service(req, resp);
	}

	// 3. GET or POST

	// 1) doGet()
	// - 보이지 않음
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		System.out.println("exe doGet");
		out.println("exe doGet" + (count++));

	}

	// 2) doPost()
	// - 보이지 않음
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		System.out.println("exe doPost");
		out.println("exe doPost" + (count++));

	}
}
