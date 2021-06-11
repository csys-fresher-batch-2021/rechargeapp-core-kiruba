package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.kiruba.exception.DatabaseException;
import in.kiruba.model.User;
import in.kiruba.utill.ConnectionUtil;

public class UserLoginDao {
	private UserLoginDao() {
		// default constructor

	}

	public static User getUserDetailsByUserNameAndUserPassword(User user) {
		String selectSQLQuery = " select * from users where username=?";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		User userDetail = null;
		List<User> list = new ArrayList<>();
		try {

		
				connection = ConnectionUtil.getConnection();

				prepareStatement = connection.prepareStatement(selectSQLQuery);
				prepareStatement.setString(1, user.getName());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					String userName = resultSet.getString("username");
					String password = resultSet.getString("userpassword");
					userDetail = new User(userName, password);
					list.add(userDetail);
					
				}
			
		} catch (DatabaseException|ClassNotFoundException |SQLException e) {
			
			throw new DatabaseException("Cannot get user from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return userDetail;

	}

}
