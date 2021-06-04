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
	private static final String DRIVER_CLASS_NAME=System.getenv("spring.datasource.driver-class-name");
	private static final String URL=System.getenv("spring.datasource.url");
	private static final String USERNAME=System.getenv("spring.datasource.username");
	private static final String PASSWORD=System.getenv("spring.datasource.password");
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
					
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Can't establish connection");
		}
	}
	public static void close(Connection con,PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
				
			}
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void close(ResultSet rs, PreparedStatement pst, Connection con) {
		if(rs!=null) {
			try {
				rs.close();
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
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	
		
	}

}
