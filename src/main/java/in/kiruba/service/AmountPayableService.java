package in.kiruba.service;

import java.sql.SQLException;

import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.dao.PlanDao;
import in.kiruba.exception.ServiceException;
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

		try {
			valid = PaymentDetailDao.payment(object);

			
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
		Plan validity = PlanDao.getExpriyDate(amount, network);
		int conversionInteger;
		String value = validity.getValidity();

		String str = value.replaceAll("[^0-9]", "");

		conversionInteger = Integer.parseInt(str);

		return conversionInteger;
	}
	
}
