package in.kiruba.main;

import java.sql.SQLException;
import java.util.Date;
import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.log.Logger;
import in.kiruba.model.PaymentDetail;
import in.kiruba.service.ValidityRemainder;

public class RemainingValidityManager {

	public static void main(String[] args) {
		int userId = 299;

		try {
			long validityDays = ValidityRemainder.remainingValidity(userId);
			if (validityDays != 0) {
				PaymentDetail detail = PaymentDetailDao.getTransactionDetail(userId);
				int amount = detail.getPlan();
				String network = detail.getNetwork();
				Date date = detail.getDate();
				String string = "PLAN: " + amount + " NETWORK: " + network + " DATE: " + date;
				Logger.logger(string);
				String statement = "YOUR PLAN VALIDITY IS GOING TO EXPIRED SOON";
				Logger.logger(statement);
				String object = "YOU HAVE ONLY";
				Logger.logger(object);
				Logger.logger(validityDays);
				String days = "DAYS";
				Logger.logger(days);
			} else {

				String statement = "YOUR PLAN VALIDITY PERIOD IS GOING TO EXPIRED SOON";
				Logger.logger(statement);

			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Cannot get Validity");

		}
	}

}
