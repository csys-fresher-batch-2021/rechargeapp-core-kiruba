package in.kiruba.main;

import java.time.LocalDate;

import in.kiruba.log.Logger;
import in.kiruba.model.SpecialOffer;
import in.kiruba.service.SpecialOffers;

public class SpecialOfferManager {

	public static void main(String[] args) {

		int plan = 2999;
		LocalDate todayDate = LocalDate.of(2021, 06, 20);
		SpecialOffer offer = SpecialOffers.getOfferService(plan, todayDate);
		Logger.logger(offer);

	}

}
