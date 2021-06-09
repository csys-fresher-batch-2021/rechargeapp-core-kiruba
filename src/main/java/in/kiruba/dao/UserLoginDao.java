package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.kiruba.exception.DatabaseException;
import in.kiruba.utill.ConnectionUtil;

public class UserLoginDao {
	private UserLoginDao() {
		// default constructor

	}

	public static Map<String, String> getAllUserDetails() {
		final Map<String, String> userListMap = new HashMap<>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = ConnectionUtil.getConnection();

			String sql = "select * from users";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {

				String userName = rs.getString("username");
				String passWord = rs.getString("userpassword");

				userListMap.put(userName, passWord);

			}
		} catch (DatabaseException | SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			throw new DatabaseException("Invalid credentials");

		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return userListMap;
	}

}
