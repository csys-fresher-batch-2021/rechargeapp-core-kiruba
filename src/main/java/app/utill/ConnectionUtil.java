package app.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	private ConnectionUtil() {
		
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection=null;
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/finapp_db";
		String username = "postgres";
		String password = "Livith1999";
		// Step 1: Load the jdbc driver in memory
		Class.forName(driverClass);
		// Step 2: Get the connection
		 connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}
	public static void close(Connection con,PreparedStatement pst) {
		try {
			if (con != null) {
				con.close();
				
			}
			if(pst!=null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void close(ResultSet rs, PreparedStatement pst, Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	
		
	}

}
