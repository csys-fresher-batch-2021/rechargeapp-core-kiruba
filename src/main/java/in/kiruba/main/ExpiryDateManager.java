package in.kiruba.main;

import java.util.Date;

import in.kiruba.log.Logger;
import in.kiruba.service.CalculateExpiryDate;
import in.kiruba.service.PlanService;

public class ExpiryDateManager {

	public static void main(String[] args) {
		int plan = 598;
		String network = "jio";
		boolean valid = PlanService.isSchemeAlreadyAvailable(plan, network);
		if (valid) {
			String[] array = PlanService.detials(plan, network);
			for (String i : array) {
				Logger.logger(i);
			}

			String statement1 = "---TODAY DATE-----";
			Logger.logger(statement1);
			Date date = new Date();
			Logger.logger(date);

			String day = PlanService.findDays(plan, network);
			int days = Integer.parseInt(day);
			String expriyDate = CalculateExpiryDate.calculateExpiryDate(days);

			String statement = "----SCHEME EXPIRY DATE----";
			Logger.logger(statement);
			Logger.logger(expriyDate);
		} else {
			String object = "This plan does not exists";
			Logger.logger(object);
		}

	}

}
