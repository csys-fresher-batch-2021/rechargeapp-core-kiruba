package in.kiruba.main;

import java.time.LocalDate;

import in.kiruba.log.Logger;
import in.kiruba.model.SpecialOffer;
import in.kiruba.service.PlanService;
import in.kiruba.service.SpecialOffers;

public class SpecialOfferManager {

	public static void main(String[] args) {

		int plan = 2999;
		String network="Airtel";
		boolean valid=PlanService.isSchemeAlreadyAvailable(plan,network);
		if(valid) {
		LocalDate todayDate = LocalDate.of(2021, 06, 25);
		SpecialOffer offer = SpecialOffers.getOfferService(plan, todayDate);
		Logger.logger(offer);
		}else {
			String statement="This Plan Does not Exists";
			Logger.logger(statement);
		}

	}

}
