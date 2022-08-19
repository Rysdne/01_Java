package jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		MemberVO m = new MemberVO();
		m.setId(rs.getNString("id"));
		m.setPassword(rs.getNString("password"));
		return m;
	}

}
