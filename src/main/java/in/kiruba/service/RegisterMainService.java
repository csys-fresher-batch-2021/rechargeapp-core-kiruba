package in.kiruba.service;

import in.kiruba.model.User;
import in.kiruba.valid.ValidUserDetail;

public class RegisterMainService {
	private RegisterMainService() {

	}/*
	this method validate the string parameters and then insert the user details into register table
	*/
	

	public static boolean test(String name, String password, String email, int age, String mobileNo,
			String adhaarNo) {
		boolean valid = false;
		User reg = new User(name, password, email,  age, mobileNo, adhaarNo);

		boolean isRegister = ValidUserDetail.isValidUserDetails(name, password, email, age, mobileNo, adhaarNo);
		if (isRegister) {

			RegisterService.callRegisterDao(reg);
			valid = true;

		}
		return valid;

	}
}
