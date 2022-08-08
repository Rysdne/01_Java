package basic220608;

import java.sql.SQLException;

public class T_Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		T_CreateDB create = new T_CreateDB();

		create.createTable();

	}

}
