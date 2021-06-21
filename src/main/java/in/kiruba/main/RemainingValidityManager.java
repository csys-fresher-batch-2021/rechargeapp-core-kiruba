package in.kiruba.main;

import java.sql.SQLException;
import in.kiruba.exception.ServiceException;
import in.kiruba.log.Logger;
import in.kiruba.service.ValidityRemainder;

public class RemainingValidityManager {

	public static void main(String[] args) {

		int plan = 598;
		String network = "jio";

		try {
			long validityDays = ValidityRemainder.remainingValidity(plan, network);
			if (validityDays != 0) {
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
