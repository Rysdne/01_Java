package db;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/datasource")
public class JndiInitDatasource extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Context : 내용물
		// 내부에 들어있는 내용을 가져올 수 있음
		Context initContext=null;
		
		
		try {
			// 초기화 컨텍스트
			initContext=new InitialContext();
			
			// 환경변수를 저장하기 위한 컨텍스트
			Context envContext=
					// Object 형을 Context 형태로 강제 형변환
					// 리턴값이 Context??
					// 경로에 있는 것을 검색??
					(Context) initContext.lookup("java:/comp/env");
			
			// 결국 사용하는 것은 요놈
			// envContext.lookup("jdbc/oracle");
			
			// 위 환경 Context를 DataSourcd 형으로 형변환
			DataSource ds=(DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

}
