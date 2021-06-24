package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import in.kiruba.exception.DatabaseException;
import in.kiruba.model.SpecialOffer;
import in.kiruba.utill.ConnectionUtil;

public class SpecialOfferDao {
	private SpecialOfferDao() {

	}

	public static SpecialOffer getOfferDetail(int plan) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		SpecialOffer detail = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select*from special_Offers where plan=?";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, plan);

			rs = pst.executeQuery();
			while (rs.next()) {
				int plans = rs.getInt("plan");

				int offer = rs.getInt("offer");
				String network = rs.getString("network");

				LocalDate date = LocalDate.parse(rs.getString("offer_Date"));
				String validity = rs.getString("validity");

				String data = rs.getString("network_Data");
				String subscription = rs.getString("subscriptions");

				detail = new SpecialOffer(plans, offer, network, validity, data, subscription, date);

			}

		} catch (DatabaseException e) {

			throw new DatabaseException("unable to  get offer details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}

		return detail;
	}

}
