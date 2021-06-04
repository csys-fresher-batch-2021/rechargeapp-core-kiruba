package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.model.User;
import in.kiruba.service.RegisterService;
import in.kiruba.valid.ValidUserDetail;

public class TestService {

	public static void main(String[] args) {

		String name = "Madhu";
		String password = "Thanya@20";

		String email = "madhu20@gmail.com";

		long mobileNumber = 9999999781L;

		int age = 23;

		long aadharNumber = 245676902357L;
		User reg = new User(name, password, email, age, mobileNumber, aadharNumber);

		if (ValidUserDetail.isValidUserDetails(name, password, email, age, mobileNumber, aadharNumber)) {
			RegisterService.RegisterUser(reg);
			String obj="Successfully registered";
			Logger.logger(obj);

		} else {
			String obj="Invalid Credentials";
			Logger.logger(obj);
		}

	}

}