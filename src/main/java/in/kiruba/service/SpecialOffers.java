package in.kiruba.service;

import java.sql.SQLException;
import java.time.LocalDate;
import in.kiruba.dao.SpecialOfferDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.log.Logger;
import in.kiruba.model.SpecialOffer;

public class SpecialOffers {
	private SpecialOffers() {

	}

	public static SpecialOffer getOfferService(int plan, LocalDate todayDate) {
		SpecialOffer dao = null;
		try {
			dao = SpecialOfferDao.getOfferDetail(plan);
			LocalDate date = dao.getDate();
			LocalDate beforeTwoDays = date.minusDays(2);
			LocalDate beforeOneDay = beforeTwoDays.plusDays(1);

			if (todayDate.isBefore(beforeTwoDays)) {
				String object = "This Plan Active From "+beforeTwoDays +" To " +date;
				Logger.logger(object);
			} else if (todayDate.isAfter(date)) {
				String stringObject = "This plan is Expired";
				Logger.logger(stringObject);

			} else if (todayDate.equals(date) || todayDate.equals(beforeOneDay) || todayDate.equals(beforeTwoDays)) {
				String statement = "SUCCESS";
				Logger.logger(statement);
			} else {
				String sentence = "Special Offer Plan Expired";
				Logger.logger(sentence);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Cannot Find Offer Date");

		}
		return dao;

	}

}
