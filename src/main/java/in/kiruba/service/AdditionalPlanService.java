package in.kiruba.service;

import java.sql.SQLException;
import in.kiruba.dao.AdditionalPlanDao;
import in.kiruba.dao.PlanDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.impl.AdditionalPlanImp;
import in.kiruba.impl.PlanImp;
import in.kiruba.log.Logger;
import in.kiruba.model.AdditionalPlan;
import in.kiruba.model.Plan;

public class AdditionalPlanService {
	private AdditionalPlanService() {

	}

	public static boolean extraPlan(AdditionalPlan object) {
		boolean valid;
		AdditionalPlanImp dao=new AdditionalPlanDao();
		try {
			dao.extraPlan(object);
			valid = true;
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Cannot Added");
		}
		return valid;

	}
	/**
	 * this method is get additional plans.
	 * @param plan
	 * @param object
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static boolean additionalPlan(int plan, AdditionalPlan object) throws ClassNotFoundException, SQLException {
		boolean valid = false;
		AdditionalPlanImp dao=new AdditionalPlanDao();
		AdditionalPlan obj = dao.getExtraPlanDetail(plan);
		PlanImp daoObject=new PlanDao();

		Plan add = daoObject.getAllPlanDetails(plan);

		if ((obj == null && add == null)) {
			String statement = "This Plan is Unavailable";
			Logger.logger(statement);
			valid = true;

		}

		else if (add == null && (obj.getValidity().equals(object.getValidity()))) {
			

			dao.additionalPlan(object);
			String string = "RECHARGE SUCCESSFULL";
			Logger.logger(string);
			valid = true;

		} else if (add != null && obj != null) {
			if (add.getscheme() == object.getPlan() && (obj.getData().equals(add.getData()))
					&& obj.getValidity().equals(add.getValidity())) {
				String statement = "This is one of the Popular Plan..So You Can Select Additional Plan";
				Logger.logger(statement);
				valid = true;

			} else {
				try {
					dao.additionalPlan(object);
				} catch (SQLException e) {
					throw new ServiceException("Unable to add details");

					
				}
				String string = "RECHARGE SUCCESSFULL";
				Logger.logger(string);

			}
		} else {
			String stringObject = "Plan is Unavailable";
			Logger.logger(stringObject);
		}

		return valid;

	}
	/**
	 * this method is find validity.
	 * @param amount
	 * @return
	 */

	public static int getValidity(int amount) {
		AdditionalPlanImp dao=new AdditionalPlanDao();
		AdditionalPlan validity = dao.getExtraPlanDetail(amount);

		int conversionInteger;
		String value = validity.getValidity();

		String str = value.replaceAll("[^0-9]", "");

		conversionInteger = Integer.parseInt(str);

		return conversionInteger;
	}
	/**
	 * find additional plan is already available.
	 * @param plan
	 * @return
	 */

	public static boolean isAdditionalPlanAlreadyAvailable(int plan) {
		AdditionalPlanImp dao = new AdditionalPlanDao();
		return dao.findAdditionalPlanAlreadyExistsOrNot(plan);

	}

	public static void isValidAdditionalPlan(int scheme, AdditionalPlan object) {
		String statement = "Process is going on ";
		Logger.logger(statement);
		try {
			if (AdditionalPlanService.additionalPlan(scheme, object)) {
				String string="Process  Done";
				Logger.logger(string);

			} else {
				String string = "TRANSACTION IS FAILED";
				Logger.logger(string);
			}
		} catch (NullPointerException | ClassNotFoundException | SQLException e) {
			Logger.logger(e.getMessage());
		}
	}

}
