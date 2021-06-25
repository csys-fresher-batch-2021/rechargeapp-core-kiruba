package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.kiruba.exception.DatabaseException;
import in.kiruba.utill.ConnectionUtil;

public class LoanProvisionDao {
	private LoanProvisionDao() {
		
	}
	
	public static boolean loanPayment(int userId) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		int result = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into loan(user_id) values(?)";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			

			result = pst.executeUpdate();

		} catch (DatabaseException e) {

			throw new DatabaseException("unable to  insert loan payment details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}
		return result == 1;

	}

	public static boolean isValidUserForLoan(int userId) {
		
		
			String selectSQLQuery = "select exists(select user_Id from loan where user_Id=?)";

			Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet resultSet = null;

			boolean isExists = false;

			try {

				connection = ConnectionUtil.getConnection();

				prepareStatement = connection.prepareStatement(selectSQLQuery);
				prepareStatement.setInt(1,userId);
				resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					isExists = resultSet.getBoolean("exists");
				}

			} catch (DatabaseException | ClassNotFoundException | SQLException | NullPointerException e) {

				throw new DatabaseException("Cannot get user from Loan database");
			} finally {
				ConnectionUtil.close(resultSet, prepareStatement, connection);
			}
			return isExists;
		
	}

}
