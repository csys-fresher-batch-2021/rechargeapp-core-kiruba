package in.kiruba.service;

import java.sql.SQLException;
import java.time.LocalDate;
import in.kiruba.dao.SpecialOfferDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.impl.SpecialOfferImp;
import in.kiruba.log.Logger;
import in.kiruba.model.SpecialOffer;

public class SpecialOffers {
	private SpecialOffers() {

	}
	/**
	 * this method is used to get offers.
	 * @param plan
	 * @param todayDate
	 * @return
	 */

	public static SpecialOffer getOfferService(int plan, LocalDate todayDate) {
		SpecialOffer dao = null;
		SpecialOfferImp daoObject=new SpecialOfferDao();
		
		try {
			dao = daoObject.getOfferDetail(plan);
			LocalDate date = dao.getStage();
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
