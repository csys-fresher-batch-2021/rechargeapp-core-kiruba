package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import in.kiruba.exception.DatabaseException;
import in.kiruba.model.PaymentDetail;
import in.kiruba.utill.ConnectionUtil;

public class PaymentDetailDao {
	private PaymentDetailDao() {

	}

	public static boolean payment(PaymentDetail pay) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		int result = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into payment_Details(user_id,network,amount,validity,mobile_no) values(?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, pay.getUserId());
			pst.setString(2, pay.getNetwork());
			pst.setInt(3, pay.getAmount());
			pst.setInt(4, pay.getValidity());
			pst.setLong(5, pay.getMobileNumber());

			result = pst.executeUpdate();

		} catch (DatabaseException e) {

			throw new DatabaseException("unable to  insert  payment details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}
		return result == 1;

	}

	public static PaymentDetail getTransactionDetail(int userId) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		PaymentDetail detail = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select*from payment_Details where user_id=?";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);

			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("user_id");

				int plans = rs.getInt("amount");

				Date date = (rs.getDate("transaction_date"));
				int validity = rs.getInt("validity");

				String system = rs.getString("network");
				Long mobileNumber = rs.getLong("mobile_no");

				detail = new PaymentDetail(id, system, mobileNumber, plans, validity, date);

			}

		} catch (DatabaseException e) {

			throw new DatabaseException("unable to  insert  payment details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}

		return detail;
	}

}
