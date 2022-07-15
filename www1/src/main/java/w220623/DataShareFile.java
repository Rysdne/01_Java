package w220623;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.ApplicationBufferHandler;

@WebServlet("/datasharefile")
public class DataShareFile extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 공통적으로 사용할 데이터를 세팅
		// String title = "study servlet";
		
		// ServletContext : web.xml 파일에 데이터를 저장
		ServletContext application=req.getServletContext();
		// ServletContext application=getServletContext(); 형태도 테스트 필요
		
		// title 문자열을 호출 시 study servlet이 입력(?)되도록 데이터 저장 
		// application.setAttribute("title", "study servlet");
		
		getServletContext().setAttribute("title", "study servlet");
		// 등록된 데이터를 다른 시트에서 사용하고 싶으면 최초 한 번 실행해줘야 함
		
		
	}
	
	
}
