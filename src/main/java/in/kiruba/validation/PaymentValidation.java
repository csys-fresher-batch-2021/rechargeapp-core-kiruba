package in.kiruba.validation;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentValidation {
	private PaymentValidation() {

	}

	public static boolean isValidCardNumber(long cardNumber) {
		boolean isValid = false;
		String number = Long.toString(cardNumber);
		String regex = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(number);

		isValid = match.matches();
		
      
		return isValid;
	}

	public static boolean isValidCvvNumber(int cvv) {
		boolean isValid = false;
		String number = Integer.toString(cvv);
		String regex = "^[0-9]{3,4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(number);

		isValid = match.matches();
		
		
		return isValid;
	}

	public static boolean isValidExpiryMonthAndYear(LocalDate date) {
		
		boolean isValid = false;
		LocalDate currentDate = LocalDate.now();
		if (date.isAfter(currentDate)) {
			isValid = true;

		}
		
		return isValid;
	}

}
