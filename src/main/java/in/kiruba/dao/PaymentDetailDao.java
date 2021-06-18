package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.kiruba.exception.DatabaseException;
import in.kiruba.model.PaymentDetail;
import in.kiruba.utill.ConnectionUtil;

public class PaymentDetailDao {
	private PaymentDetailDao() {
		
	}
	
	public static boolean payment(PaymentDetail pay) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		int result=0;
		

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into payment_Details(user_id,network,amount,mobile_no) values(?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, pay.getUserId());
			pst.setString(2, pay.getNetwork());
			pst.setInt(3, pay.getAmount());
			pst.setLong(4, pay.getMobileNumber());
			

			result=pst.executeUpdate();

		} catch (DatabaseException e) {
			
			throw new DatabaseException("unable to  insert  payment details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}
		return result==1;

	}

}
