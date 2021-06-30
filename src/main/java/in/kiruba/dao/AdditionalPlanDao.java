package in.kiruba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.kiruba.exception.DatabaseException;
import in.kiruba.impl.AdditionalPlanImp;
import in.kiruba.model.AdditionalPlan;
import in.kiruba.utill.ConnectionUtil;

public class AdditionalPlanDao implements AdditionalPlanImp{

	public  void extraPlan(AdditionalPlan plan) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into extra_Plan(plan,network,validity,mobile_data,subscriptions) values(?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, plan.getPlan());
			pst.setString(2, plan.getNetwork());
			pst.setString(3, plan.getValidity());
			pst.setString(4, plan.getData());
			pst.setString(5, plan.getSubscription());

			pst.executeUpdate();

		} catch (DatabaseException e) {

			throw new DatabaseException("unable to  insert  Additional Plan details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}

	}

	public  AdditionalPlan getExtraPlanDetail(int plan) {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultset = null;
		AdditionalPlan object = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from extra_Plan where plan=?";
			pst = connection.prepareStatement(sql);

			pst.setInt(1, plan);
			resultset = pst.executeQuery();
			while (resultset.next()) {
				int scheme = resultset.getInt("plan");

				String name = resultset.getString("network");
				String validity = resultset.getString("validity");
				String data = resultset.getString("mobile_data");

				String subScription = resultset.getString("subscriptions");

				object = new AdditionalPlan(scheme, name, validity, data, subScription);

			}

		} catch (DatabaseException | ClassNotFoundException | SQLException | NullPointerException e) {

			throw new DatabaseException("Cannot get Validity  Details");
		} finally {
			ConnectionUtil.close(resultset, pst, connection);

		}

		return object;
	}

	public  void additionalPlan(AdditionalPlan plan) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into additionalplan_Payment(userId,scheme,network,validity,mobile_data,subscriptions,mobile_Number) values(?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, plan.getUserId());
			pst.setInt(2, plan.getPlan());
			pst.setString(3, plan.getNetwork());
			pst.setString(4, plan.getValidity());
			pst.setString(5, plan.getData());
			pst.setString(6, plan.getSubscription());
			pst.setLong(7, plan.getMobileNumber());

			pst.executeUpdate();

		} catch (DatabaseException e) {

			throw new DatabaseException("unable to  insert  Additional Plan details");

		} finally {
			ConnectionUtil.close(connection, pst);

		}

	}

	public boolean findAdditionalPlanAlreadyExistsOrNot(int plan) {
		String selectSQLQuery = "select exists(select plan from extra_Plan where plan=?)";

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		boolean isExists = false;

		try {

			connection = ConnectionUtil.getConnection();

			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setInt(1, plan);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isExists = resultSet.getBoolean("exists");
			}

		} catch (DatabaseException | ClassNotFoundException | SQLException e) {

			throw new DatabaseException("Cannot get user from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}

		return isExists;
	}

}
