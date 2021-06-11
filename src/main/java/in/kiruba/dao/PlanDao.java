package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.kiruba.exception.DatabaseException;
import in.kiruba.model.Plan;
import in.kiruba.utill.ConnectionUtil;

public class PlanDao {
	private PlanDao() {

	}

	public static List<Plan> getAllPlanLists() {
		List<Plan> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				int plan = rs.getInt("plan");
				String name = rs.getString("network_name");
				String validity = rs.getString("validity");
				String data = rs.getString("mobile_data");
				String subscriptions = rs.getString("subscriptions");

				Plan obj = new Plan(plan, name, validity, data, subscriptions);
				list.add(obj);

			}

		} catch (DatabaseException|ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get All plan Details");
		} finally {
			ConnectionUtil.close(rs, pst, con);

		}

		return list;

	}

}
