package in.kiruba.valid;

import java.time.LocalDate;

import in.kiruba.service.PlanService;
import in.kiruba.validation.PaymentValidation;
import in.kiruba.validation.RegisterValidation;

public class ValidPaymentDetail {
	private ValidPaymentDetail() {
		
	}
	/**
	 * this method return true whether the details are valid.
	 * @param mobileNumber
	 * @param cardNumber
	 * @param amount
	 * @param cvv
	 * @param date
	 * @return
	 */
	
	public static boolean paymentDetailValidation(long mobileNumber,long cardNumber,int amount,int cvv,LocalDate date) {
		boolean valid=false;
		if(PaymentValidation.isValidCardNumber(cardNumber)&&PaymentValidation.isValidCvvNumber(cvv)&&PlanService.validAmount(amount)&&PaymentValidation.isValidExpiryMonthAndYear(date)&&RegisterValidation.isValidMobileno(mobileNumber)) {
			
				 valid=true;
			
	    
	    }
		 return valid;
	}

}
