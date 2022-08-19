package jdbc2;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

	public static void main(String[] args) throws SQLException {

		// jdbc에서 context 불러
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc2/dbconfig.xml");

		// JdbcTemplate bean 사용
		JdbcTemplate jtemp = (JdbcTemplate) ctx.getBean("jdbcTemplate");

//		// 1. 템플릿을 사용해 datasource를 정수 형태로 가져옴
//		String sql="select count(*) from member";
//		int count = jtemp.queryForObject(sql, Integer.class);
//		System.out.println(count);
//		// 이걸 또 분리시기키 위해 MyBatis가 나오게 됨

//		// 2. 문자열 형태로 가져옴
//		String sql="select password from member where id='rysdne1'";
//		String password=jtemp.queryForObject(sql, String.class);
//		System.out.println(password);

//		// 3. ? 추가한 SQL
//		// ?의 입력값은 Object 배열 형태로 입력되어야 함
//		String sql="select password from member where id=?";
//		String password=jtemp.queryForObject(sql, new Object[]{"rysdne1"}, String.class);
//		System.out.println(password);

//		// 4. 모든 리스트 출력
//		// 1) 일반 query 형태
//		// ?의 입력값은 Object 배열 형태로 입력되어야 함
//		String sql="select * from member";
//		List<MemberVO> list=jtemp.query(sql, new MemberMapper());
//
//		for(MemberVO m:list) {
//			System.out.println(m.toString());
//		}
//		
		// 2) 배열 형태
		// RowMapper를 구현한 객체는 mapRow() 함수를 구현하면 결과를 받을 수 있음
		// ㄴ> 리스트 형태임에도 for문이 별도 필요 없음
		String sql = "select * from member where id=?";
		MemberVO m = (MemberVO) jtemp.queryForObject(sql, new Object[] {"rysdne1"}, new MemberMapper());
		System.out.println(m.toString());

	}
}
