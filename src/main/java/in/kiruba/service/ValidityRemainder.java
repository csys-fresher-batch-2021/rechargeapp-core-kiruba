package in.kiruba.service;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.model.PaymentDetail;

public class ValidityRemainder {
	private ValidityRemainder() {

	}

	/**
	 * this method is used to find transaction date then it is used to find
	 * validity.
	 * 
	 * @param plan
	 * @param network
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static long remainingValidity(int userId) throws ClassNotFoundException, SQLException {

		long validityPeriod = 0;

		PaymentDetail detail;
		detail = PaymentDetailDao.getTransactionDetail(userId);

		int validityDays = detail.getValidity();

		Date transactionDate = detail.getDate();
		LocalDate localDate = Instant.ofEpochMilli(transactionDate.getTime()).atZone(ZoneId.systemDefault())
				.toLocalDate();

		LocalDate expiryDate = CalculateExpiryDate.calculateExpiryDateOfLocalDate(localDate, validityDays);
		validityPeriod = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);

		return validityPeriod;

	}
	/**
	 * this method find expire date.
	 * @param userId
	 * @return
	 */
	public static LocalDate findExpiryDate(int userId) {
		PaymentDetail detail;
		LocalDate expiryDate;
		try {
			detail = PaymentDetailDao.getTransactionDetail(userId);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Cannot find User Id");
		}

		int validityDays = detail.getValidity();

		Date transactionDate = detail.getDate();
		LocalDate localDate = Instant.ofEpochMilli(transactionDate.getTime()).atZone(ZoneId.systemDefault())
				.toLocalDate();

		expiryDate = CalculateExpiryDate.calculateExpiryDateOfLocalDate(localDate, validityDays);
		return expiryDate;
		
	}

	

}
