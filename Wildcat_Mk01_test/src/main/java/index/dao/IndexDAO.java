package index.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IndexDAO implements IndexDaoInter {

	Connection conn;
	PreparedStatement pstmt;

	public IndexDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tableCheck() {
		try {
			String sql = "select table_name from all_tables where table_name='WTESTID'";
			pstmt = conn.prepareStatement(sql);
			ResultSet exId = pstmt.executeQuery();
			if (!exId.next()) {
				sql = "create table wTestID(uidx number(5) primary key, id varchar2(50) unique not null, password varchar2(20) not null)";
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				System.out.println("wTestID 생성");
			} else {
				System.out.println("계정 테이블 확인");
			}
			sql = "select table_name from all_tables where table_name='WILDCAT_MK01'";
			pstmt = conn.prepareStatement(sql);
			ResultSet exMemo = pstmt.executeQuery();
			if (!exMemo.next()) {
				sql = "create table Wildcat_Mk01(idx number(14) primary key, id varchar2(50) not null, subfolder varchar2(50) not null, title varchar2(50) not null, cdate varchar2(10) not null, ctime varchar2(8) not null)";
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				System.out.println("Wildcat_Mk01 생성");
			} else {
				System.out.println("메모 테이블 확인");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
