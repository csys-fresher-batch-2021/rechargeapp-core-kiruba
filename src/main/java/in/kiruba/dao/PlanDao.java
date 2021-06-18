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
				int scheme = resultset.getInt("plan");
				String networkName = resultset.getString("network_name");
				String networkValidity = resultset.getString("validity");
				String mobileData = resultset.getString("mobile_data");
				String subscription = resultset.getString("subscriptions");

				Plan obj = new Plan(scheme, networkName, networkValidity, mobileData, subscription);
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
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		Plan object=null;
		

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans where plan=? and network_name=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,plan);
			pstmt.setString(2,network);
			resultset = pstmt.executeQuery();
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
			ConnectionUtil.close(resultset, pstmt, connection);

		}

		return object;
		

	}
	public static List<Integer> getAllPlans() {
		List<Integer> lists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans";
			pstmt = connection.prepareStatement(sql);
			
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				int scheme = resultset.getInt("plan");
				
				lists.add(scheme);
				

			}

		} catch (DatabaseException|ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get All plans");
		} finally {
			ConnectionUtil.close(resultset, pstmt, connection);

		}

		return lists;
	}


}
