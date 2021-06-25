package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.model.User;
import in.kiruba.service.RegisterService;
import in.kiruba.valid.ValidUserDetail;

public class TestService {

	public static void main(String[] args) {

		String name = "Karan";
		String key = "Karan@123";

		String email = "karankumar88@gmail.com";

		long mobileNumber = 9999998791L;

		int age = 23;

		long aadharNumber = 245686002357L;
		User reg = new User(name, key, email, age, mobileNumber, aadharNumber);

		if (ValidUserDetail.isValidUserDetails(name, key, email, age, mobileNumber, aadharNumber)) {
			RegisterService.registerUser(reg);
			String obj = "Successfully registered";
			Logger.logger(obj);

		} else {
			String obj = "Invalid Credentials";
			Logger.logger(obj);
		}

	}

}