package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.kiruba.exception.DatabaseException;
import in.kiruba.model.AdminLogin;
import in.kiruba.utill.ConnectionUtil;

public class AdminLoginDao {

	public static void admin(AdminLogin admin) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into admin(admin_Name,admin_Password) values(?,?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, admin.getAdminName());
			pst.setString(2, admin.getAdminPassword());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		} finally {
			ConnectionUtil.close(connection, pst);

		}
	}

	public static AdminLogin getUserDetailsByUserName(AdminLogin admin) throws ClassNotFoundException, SQLException {
		String selectSQLQuery = " select * from admin where admin_Name=? ";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		AdminLogin userDetail = null;
		List<AdminLogin> list = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();

			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, admin.getAdminName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String userName = resultSet.getString("admin_Name");
				String password = resultSet.getString("admin_password");
				userDetail = new AdminLogin(userName, password);
				list.add(userDetail);

			}

		} catch (DatabaseException e) {

			throw new DatabaseException("Can't get user  from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return userDetail;

	}

	public static Map<String, String> getAllAdminDetails() throws SQLException, ClassNotFoundException {
		String selectSQLQuery = " select * from admin ";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		final Map<String, String> list = new HashMap<>();

		try {

			connection = ConnectionUtil.getConnection();

			prepareStatement = connection.prepareStatement(selectSQLQuery);

			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String userName = resultSet.getString("admin_Name");
				String password = resultSet.getString("admin_password");

				list.put(userName, password);
			}

		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Can't get user  from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return list;

	}

	public boolean findAdminAlreadtExistsOrNot(AdminLogin admin) {
		String selectSQLQuery = "select exists(select admin_name from admin where admin_name=?)";

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		boolean isExists = false;

		try {

			connection = ConnectionUtil.getConnection();

			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, admin.getAdminName());
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
