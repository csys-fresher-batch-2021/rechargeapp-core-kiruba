package in.kiruba.service;

import in.kiruba.model.User;
import in.kiruba.valid.ValidUserDetail;

public class RegisterServiceValidation {
	private RegisterServiceValidation() {

	}/*
		 * this method validate the string parameters and then insert the user details
		 * into register table
		 */

	public static boolean checkUserDetail(String name, String password, String email, int age, long mobileNumber,
			long aadharNumber) {
		boolean valid = false;
		User reg = new User(name, password, email, age, mobileNumber, aadharNumber);

		boolean isRegister = ValidUserDetail.isValidUserDetails(name, password, email, age, mobileNumber, aadharNumber);
		if (isRegister) {

			RegisterService.registerUser(reg);
			valid = true;

		}
		return valid;

	}
}
