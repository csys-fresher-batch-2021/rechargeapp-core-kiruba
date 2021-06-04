package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.kiruba.exception.DatabaseException;
import in.kiruba.model.User;
import in.kiruba.utill.ConnectionUtil;

public class RegisterDao {
	private RegisterDao() {

	}

	public static void register(User reg) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into user_table(username,userpassword,email,age,mobileNumber,adhaarNo) values(?,?,?,?,?,?)";

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

}
