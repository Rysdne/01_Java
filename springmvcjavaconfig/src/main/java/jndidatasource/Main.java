package jndidatasource;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) throws NamingException, SQLException {
		
		// xml 파일을 로드
		Resource resource;
		
		// xml 파일에서 context를 찾음
		// Context initContext=new InitialContext();
		
		// tag의 name에 해당하는 부분을 출력
		DataSource ds = (DataSource) (new InitialContext()).lookup("jdbc/oracle");
		
		System.out.println(ds.getConnection());
		
	}
}
