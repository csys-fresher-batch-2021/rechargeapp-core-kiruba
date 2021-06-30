package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.kiruba.exception.DatabaseException;
import in.kiruba.impl.RegisterImp;
import in.kiruba.model.User;
import in.kiruba.utill.ConnectionUtil;

public class RegisterDao implements RegisterImp{
	public RegisterDao() {
		//default constructor

	}

	public  void register(User reg) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into users(username,userpassword,email,age,mobile_Number,adhaar_Number) values(?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, reg.getName());
			pst.setString(2, reg.getPassword());
			pst.setString(3, reg.getEmail());
			pst.setInt(4, reg.getAge());
			pst.setLong(5, reg.getMobileNo());
			pst.setLong(6, reg.getAdhaarNo());

			pst.executeUpdate();

		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("unable to  insert  user details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}

	}

	public boolean findUserAlreadtExistsOrNot(User user)  {
		String selectSQLQuery = "select exists(select username,email,mobile_Number,adhaar_Number from users where username=? and email=? and mobile_Number=? and adhaar_Number=?)";
				
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		boolean isExists = false;

		try {

			connection = ConnectionUtil.getConnection();
			Long mobileNumber=user.getMobileNo();
			Long adhaarNumber=user.getAdhaarNo();

			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1,user.getName());
			prepareStatement.setString(2,user.getEmail());
			prepareStatement.setString(3,mobileNumber.toString());
			prepareStatement.setString(4,adhaarNumber.toString());
			
			
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isExists = resultSet.getBoolean("exists");
			}

		} catch (DatabaseException | ClassNotFoundException | SQLException |NullPointerException e) {
			
				throw new DatabaseException("Cannot get user from database");
		     
			
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return isExists;
	}
	

}
