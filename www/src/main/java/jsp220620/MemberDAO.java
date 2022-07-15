package jsp220620;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {

	Connection conn;
	PreparedStatement pstat;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

		} catch (Exception e) {
		}
	}

	public int insert(MemberVO vo) {
		try {
			String sql = "insert into member values(?,?,?)";
			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, vo.getNo());
			pstat.setString(2, vo.getId());
			pstat.setString(3, vo.getPw());

			int rs = pstat.executeUpdate();

			return rs;

		} catch (Exception e) {
			return 0;
		}
	}

}
