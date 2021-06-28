package in.kiruba.main;

import java.time.LocalDate;

import in.kiruba.exception.ServiceException;
import in.kiruba.log.Logger;
import in.kiruba.model.PaymentDetail;
import in.kiruba.service.AmountPayableService;
import in.kiruba.service.PlanService;
import in.kiruba.valid.ValidPaymentDetail;

public class AmountPayable {

	public static void main(String[] args) {
		int userId = 72;
		String network = "jio";
		long mobileNumber = 9190990991L;
		long cardNumber = 371234567890123L;
		int amount = 59;
		int cvv = 777;
		boolean isExists = PlanService.isSchemeAlreadyAvailable(amount, network);

		if (isExists) {
			int validity = AmountPayableService.getValidity(amount, network);
			LocalDate date = LocalDate.of(2025, 7, 20);

			PaymentDetail object = new PaymentDetail(userId, network, amount, validity, mobileNumber);

			boolean valid = ValidPaymentDetail.paymentDetailValidation(mobileNumber, cardNumber, amount, cvv, date);
			try {
				if (valid) {

					if (AmountPayableService.payableService(object)) {
						String statement = "***Success***";
						Logger.logger(statement);
					}

					else {
						String statement = "----Sry! Transaction Is Failed---";
						Logger.logger(statement);
					}
				} else {
					String statement = "----Invalid Credentials---";
					Logger.logger(statement);
				}
			}

			catch (ServiceException e) {
				Logger.logger(e.getMessage());
			}
		} else {
			String string = "Please Choose correct scheme";
			Logger.logger(string);

		}
	}
}
