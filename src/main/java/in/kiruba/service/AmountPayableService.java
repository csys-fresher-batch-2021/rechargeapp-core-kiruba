package in.kiruba.service;

import java.sql.SQLException;

import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.dao.PlanDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.impl.PaymentDetailImp;
import in.kiruba.impl.PlanImp;
import in.kiruba.model.PaymentDetail;
import in.kiruba.model.Plan;

public class AmountPayableService {
	AmountPayableService() {

	}

	/**
	 * this method insert the payment details into database.
	 * 
	 * @param object
	 * @return
	 */

	public static boolean payableService(PaymentDetail object) {

		boolean valid;
		PaymentDetailImp dao=new PaymentDetailDao();

		try {
			valid = dao.payment(object);

			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Try Other Plans");

		}

		return valid;

	}
	/**
	 * this method is used to find validity.
	 * @param amount
	 * @param network
	 * @return
	 */

	public static int getValidity(int amount, String network) {
		PlanImp dao=new PlanDao();
		Plan validity = dao.getExpriyDate(amount, network);
		int conversionInteger;
		String value = validity.getValidity();

		String str = value.replaceAll("[^0-9]", "");

		conversionInteger = Integer.parseInt(str);

		return conversionInteger;
	}
	/**
	 * this method is find the given user id is available or not.
	 * @param userId
	 * @return
	 */
	public static  boolean isUserAlreadyAvailable(int userId) {
		PaymentDetailDao dao = new PaymentDetailDao();
		return dao.findUserAlreadtExistsOrNot(userId);
	}
	
}
