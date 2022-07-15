package db;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

// 서버가 동작하기 위해서는 미리 서블릿 형태로 만들어야 함
public class DBCPInit extends HttpServlet {

	// 설정파일을 가져올 때
	// web.xml에서 드라이버 정보를 문자열로 가지고 옴
	// init으로 만들어줬기 때문에 서버가 시작하자마자 적용됨
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			
			// web.xml에서 정보를 가지고 오는 작업
			String drivers = config.getInitParameter("jdbcdriver");
			// Context에서는 이걸 다 몰아서 한 번에 클래스화시켰음 
			
			// 클래스 로드 1
			Class.forName(drivers);
			// 라이브러리 관련 설정 파일은 src/pool.jocl 파일
			// 이 파일을 활용하여 객체를 업로드
			
			// 클래스 로드 2
			// .class는 빼야 함
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

//	// 가져울 게 없을 때
//	@Override
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//		super.init();
//	}

}
