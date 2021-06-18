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
		List<Plan> lists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans";
			pstmt = connection.prepareStatement(sql);

			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				int plan = resultset.getInt("plan");
				String networkName = resultset.getString("network_name");
				String networkValidity = resultset.getString("validity");
				String mobileData = resultset.getString("mobile_data");
				String subscription = resultset.getString("subscriptions");

				Plan obj = new Plan(plan, networkName, networkValidity, mobileData, subscription);
				lists.add(obj);
				

			}

		} catch (DatabaseException|ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get All plan Details");
		} finally {
			ConnectionUtil.close(resultset, pstmt, connection);

		}

		return lists;
		

	}
	
	public static Plan getExpriyDate(int plan,String network) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultset = null;
		Plan object=null;
		

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans where plan=? and network_name=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,plan);
			pst.setString(2,network);
			resultset = pst.executeQuery();
			while (resultset.next()) {
				int scheme = resultset.getInt("plan");
				
				String name = resultset.getString("network_name");
				String validity = resultset.getString("validity");
				String data = resultset.getString("mobile_data");
				String subScription = resultset.getString("subscriptions");

				 object = new Plan(scheme, name, validity,data, subScription);
			
			}

		} catch (DatabaseException|ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get Validity  Details");
		} finally {
			ConnectionUtil.close(resultset, pst, connection);

		}

		return object;
		

	}
	public static List<Integer> getAllPlans() {
		List<Integer> plan = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			conn = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int schemes = rs.getInt("plan");
				
				plan.add(schemes);
				

			}

		} catch (DatabaseException|ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get All plans");
		} finally {
			ConnectionUtil.close(rs, pstmt, conn);

		}

		return plan;
	}


}
