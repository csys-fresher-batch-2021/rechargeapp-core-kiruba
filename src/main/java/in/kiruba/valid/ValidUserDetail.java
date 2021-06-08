package in.kiruba.valid;

import in.kiruba.exception.ServiceException;
import in.kiruba.validation.RegisterValidation;

public class ValidUserDetail {
	private ValidUserDetail() {
		//default constructor

	}

	public static boolean isValidUserDetails(String name, String password, String email, int age, long mobileNumber,
			long aadharNumber) {
		boolean valid = false;

		try {
			if (RegisterValidation.isValidUserName(name) && RegisterValidation.isValidPassword(password) &&

					RegisterValidation.isValidEmail(email) && RegisterValidation.isValidAge(age)
					&& RegisterValidation.isValidAdhaarNo(aadharNumber)
					&& RegisterValidation.isValidMobileno(mobileNumber)) {
				valid = true;

			}
		} catch (ServiceException e) {

			throw new ServiceException("User Details are Not Valid");

		}

		return valid;

	}

}
