package in.kiruba.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.kiruba.exception.DatabaseException;

public class ConnectionUtil {
	private ConnectionUtil() {
		
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(System.getenv("spring.datasource.driver-class-name"));
			return DriverManager.getConnection(System.getenv("spring.datasource.url"),
					System.getenv("spring.datasource.username"), System.getenv("spring.datasource.password"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Can't establish connection");
		}
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
