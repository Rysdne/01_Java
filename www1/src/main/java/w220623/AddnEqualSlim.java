package w220623;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addnEqualSlim")
public class AddnEqualSlim extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 입력한 값이 저장될 변수 선언(로컬값)
		// localhost:8080/cal2?num=<VALUE>&op=<VALUE>
		// ㄴ> 넘어오는 값
		String op = req.getParameter("op");
		String inputNum = req.getParameter("num");

		// 함수 내에서 계산에 사용할 변수 하나를 선언
		int localNum = 0;
		// ServletContext에 값을 저장하는 변수 선언
		int localRs = 0;

		// 입력값이 있을 경우 localNum에 inputNum 값을 int 타입으로 변환하여 저장
		if (!inputNum.equals(""))
			localNum = Integer.parseInt(inputNum);

		// ServletContext에 저장된 "servRs" Attribute 값이 생성되어있는지를 물어보는 것
		// 1) 있을 경우(not null)
		// servRs 값을 불러와(get) localRs에 int 타입으로 저장
		if (!(getServletContext().getAttribute("servRs") == null))
			localRs = (int) getServletContext().getAttribute("servRs");

		// 불러온 servRs 값에 미리 저장한 localNum 값을 누적해서 더해줌
		localRs += localNum;

		// + 버튼을 눌렀을 때의 동작 정의
		if (op.equals("+")) {
			// servRs에 localRs 값(누적 계산값)을 저장
			getServletContext().setAttribute("servRs", localRs);
			System.out.println(localRs);
			// 부가적인 계산을 실행할 수 있도록 메인페이지로 리다이렉션
			resp.sendRedirect("http://localhost:8080/AddnEqualSlim.html");

			// 이외 버튼(=)의 동작 정의
		} else {
			System.out.println("총합 : " + localRs);
			resp.getWriter().println("총합 : " + localRs);

			// 계산 작업이 끝났다고 판단하며 계산값을 초기화함

//			// 1) 저장된 값을 0으로 저장
//			getServletContext().setAttribute("servRs", 0);
//			// 이렇게 하면 이미 ServletContext 자체가 선언되어있는 상태가 됨
//			// 지금은 같은 결과가 나오지만, 만약 Attribute 선언 여부를 묻는 함수가 제대로 동작하지 않음 

			// 2) servRs Attribute 자체를 삭제
			getServletContext().removeAttribute("servRs");
			// 이게 더 깔끔하지

			System.out.println("저장값 초기화 완료");
		}

	}

}
