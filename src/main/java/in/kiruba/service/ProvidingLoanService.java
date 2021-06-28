package in.kiruba.service;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import in.kiruba.dao.LoanProvisionDao;
import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.log.Logger;
import in.kiruba.model.PaymentDetail;

public class ProvidingLoanService {
	private ProvidingLoanService() {

	}

	public static boolean providingLoan(int userId) {
		boolean valid = false;
		PaymentDetail payment;
		try {
			payment = PaymentDetailDao.getTransactionDetail(userId);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Cannot find payment details");
		}
		int period = payment.getValidity();
		Date transactionDate = payment.getDate();
		LocalDate date = Instant.ofEpochMilli(transactionDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate expiryDate = CalculateExpiryDate.calculateExpiryDateOfLocalDate(date, period);
		LocalDate alertDate = expiryDate.plusDays(1);
		LocalDate finalAlertDate = alertDate.plusDays(2);
		LocalDate blockDate = finalAlertDate.plusDays(1);
		if (alertDate.isAfter(expiryDate)) {
			String object = "Outgoing not working? Incomming will also stop on" + finalAlertDate
					+ "\n---Special Loan provision---" + "\n To avoid stop incomming calls" + "\n www.bit.ly/rcehhome ";
			Logger.logger(object);
			valid = true;
		} else {
			String statement = "Incoming calls are blocked " + blockDate + "onwards.";
			Logger.logger(statement);
		}

		return valid;
	}
	

	public static boolean providingLoan1(int userId, int choice) {
		boolean valid = false;
		LocalDate date = LocalDate.of(2021, 03, 30);
		int period = 87;
		LocalDate expiryDate = CalculateExpiryDate.calculateExpiryDateOfLocalDate(date, period);

		LocalDate alertDate = expiryDate.plusDays(1);
		LocalDate finalAlertDate = alertDate.plusDays(2);
		LocalDate blockDate = finalAlertDate.plusDays(1);
		if (alertDate.isAfter(expiryDate)) {
			String object = "Outgoing not working? Incomming will also stop on " + finalAlertDate
					+ "\n---Special Loan provision---" + "\n To avoid stop incomming calls" + "\n www.bit.ly/rcehhome ";
			Logger.logger(object);

			if (userChoice(choice, userId)) {
				valid = true;
			}

		} else {
			String statement = "Incoming calls are blocked " + blockDate + "onwards.";
			Logger.logger(statement);
		}
		return valid;
	}

	public static boolean userChoice(int choice, int userId) {
		boolean valid = false;
		boolean dao;
		if (choice == 1) {
			try {
				if (!LoanProvisionDao.isValidUserForLoan(userId)) {
					dao = LoanProvisionDao.loanPayment(userId);
					if (dao) {
						String string = "DONE";
						Logger.logger(string);
						valid = true;
					}
				}else {
					String message="You are not valid for loan";
					Logger.logger(message);
				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new ServiceException("Cannot get Loan payment details");
			}

		} else if (choice == 0) {
			String stringObject = "Outgoing service and Incoming service are blocked for your Number.To restart, please recharge.";
			Logger.logger(stringObject);
		}
		return valid;
	}
	

}
