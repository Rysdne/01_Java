package w220623;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpinfo")
public class HttpHeader extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 밖에서 들어오는 상대의 접속 정보를 확인할 수 있음
		// 접속자의 정보이기 때문에 내가 남한테 접속한 뒤 호출할 경우엔 내 정보가 표시됨
		System.out.println(req.getRemoteAddr());
		resp.getWriter().println("IP 주소 : "+req.getRemoteAddr());
		System.out.println(":"+req.getRemotePort());
		resp.getWriter().println(":"+req.getRemotePort());
		
		// inputStream 쓰면 접속로그처럼 만들 수도 있음 
	}

}
