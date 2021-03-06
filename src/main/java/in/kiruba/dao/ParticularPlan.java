package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.kiruba.exception.DatabaseException;
import in.kiruba.impl.ParticularPlanImp;
import in.kiruba.model.Plan;
import in.kiruba.utill.ConnectionUtil;

public class ParticularPlan implements ParticularPlanImp{
	
	
	public  List<Plan> getParticularNetworkList(String network) {
		List<Plan> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.getConnection();

			String sql = "select network.network_name,popular_plans.plan,popular_plans.validity,popular_plans.mobile_data,popular_plans.subscriptions from network inner join popular_plans on network.network_name=popular_plans.network_name where network.network_name=?;";
			pst = con.prepareStatement(sql);

			pst.setString(1, network);

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
             throw new DatabaseException("Can't get particulatr network plan");
		} finally {
			ConnectionUtil.close(rs, pst, con);

		}

		return list;

	}

}
