package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.kiruba.exception.DatabaseException;
import in.kiruba.impl.UserLoginImp;
import in.kiruba.model.User;
import in.kiruba.utill.ConnectionUtil;

public class UserLoginDao implements UserLoginImp {
	public UserLoginDao() {
		// default constructor

	}

	public  User getUserDetailsByUserName(User user) {
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

		} catch (DatabaseException | ClassNotFoundException | SQLException | NullPointerException e) {

			throw new DatabaseException("Cannot get user from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return userDetail;

	}

	public boolean findUserAlreadtExitOrNot(User user) {
		String selectSQLQuery = "select exists(select username from users where username=?)";

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		boolean isExists = false;

		try {

			connection = ConnectionUtil.getConnection();

			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, user.getName());
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isExists = resultSet.getBoolean("exists");
			}

		} catch (DatabaseException | ClassNotFoundException | SQLException | NullPointerException e) {

			throw new DatabaseException("Cannot get user from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return isExists;
	}

}
