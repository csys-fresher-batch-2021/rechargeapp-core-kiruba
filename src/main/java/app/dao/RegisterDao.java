package app.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.model.User;
import app.utill.ConnectionUtil;



public class RegisterDao {
	private RegisterDao() {

	}

	public static void register1(User reg) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection =  ConnectionUtil.getConnection();

			String sql = "insert into register(username,userpassword,email,age,mobileNo,adhaarNo) values(?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, reg.getName());
			pst.setString(2, reg.getPassword());
			pst.setString(3, reg.getEmail());
			pst.setString(4, reg.getAge());
			pst.setString(5, reg.getMobileNo());
			pst.setString(6, reg.getAdhaarNo());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			

			e.printStackTrace();
			
		} finally {
			ConnectionUtil.close(connection, pst);

		}

	}

}
