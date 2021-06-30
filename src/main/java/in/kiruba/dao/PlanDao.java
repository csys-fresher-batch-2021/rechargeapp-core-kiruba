package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.kiruba.exception.DatabaseException;
import in.kiruba.impl.PlanImp;
import in.kiruba.model.Plan;
import in.kiruba.utill.ConnectionUtil;

public class PlanDao implements PlanImp{
	

	private static final String PROVIDER = "network_name";
	private static final String EXPIRY = "validity";
	private static final String NETBALANCE = "mobile_data";
	private static final String PACKAGES = "subscriptions";

	public  List<Plan> getAllPlanLists() {
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
				String networkName = resultset.getString(PROVIDER);
				String networkValidity = resultset.getString(EXPIRY);
				String mobileData = resultset.getString(NETBALANCE);
				String subscription = resultset.getString(PACKAGES);

				Plan obj = new Plan(plan, networkName, networkValidity, mobileData, subscription);
				lists.add(obj);

			}

		} catch (DatabaseException | ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get All plan Details");
		} finally {
			ConnectionUtil.close(resultset, pstmt, connection);

		}

		return lists;

	}

	public  Plan getExpriyDate(int plan, String network) {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultset = null;
		Plan object = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans where plan=? and network_name=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, plan);
			pst.setString(2, network);
			resultset = pst.executeQuery();
			while (resultset.next()) {
				int scheme = resultset.getInt("plan");

				String name = resultset.getString(PROVIDER);
				String validity = resultset.getString(EXPIRY);
				String data = resultset.getString(NETBALANCE);

				String subScription = resultset.getString(PACKAGES);

				object = new Plan(scheme, name, validity, data, subScription);

			}

		} catch (DatabaseException | ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get Validity  Details");
		} finally {
			ConnectionUtil.close(resultset, pst, connection);

		}

		return object;

	}

	public  List<Integer> getAllPlans() {
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

		} catch (DatabaseException | ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get All plans");
		} finally {
			ConnectionUtil.close(rs, pstmt, conn);

		}

		return plan;
	}

	public  Plan getAllPlanDetails(int plan) {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultset = null;
		Plan object = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from popular_plans where plan=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, plan);

			resultset = pst.executeQuery();
			while (resultset.next()) {
				int idea = resultset.getInt("plan");

				String packName = resultset.getString(PROVIDER);
				String validity = resultset.getString(EXPIRY);
				String data = resultset.getString(NETBALANCE);

				String subscription = resultset.getString(PACKAGES);

				object = new Plan(idea, packName, validity, data, subscription);

			}

		} catch (DatabaseException | ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get Validity  Details");
		} finally {
			ConnectionUtil.close(resultset, pst, connection);

		}

		return object;

	}

	public boolean findPlanAlreadyExistsOrNot(int scheme,String system) {
		String selectSQLQuery = "select exists(select plan,network_name from popular_plans where plan=? and network_name=?)";

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		boolean isExists = false;

		try {

			connection = ConnectionUtil.getConnection();

			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setInt(1, scheme);
			prepareStatement.setString(2,system);
			
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isExists = resultSet.getBoolean("exists");
			}

		} catch (DatabaseException | ClassNotFoundException | SQLException | NullPointerException e) {

			throw new DatabaseException("Cannot get user from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return isExists;
	}

}
