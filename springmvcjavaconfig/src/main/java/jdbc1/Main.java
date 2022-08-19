package jdbc1;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws SQLException {

		// jdbc에서 context 불러
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc1/dbconfig.xml");

		// DataSource는 정보가 필요함
		DataSource ds = (DataSource) ctx.getBean("datasource");

		// conn 생성
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}

}
