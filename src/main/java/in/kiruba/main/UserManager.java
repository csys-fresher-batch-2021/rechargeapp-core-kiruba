package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.service.UserLoginService;

public class UserManager {

	public static void main(String[] args) {
		String name = "Jeeva";
		String key = "Jeeva@123";

		boolean valid = UserLoginService.userLogin(name, key);
		if (valid) {
			String obj = "----Successfully login---";
			Logger.logger(obj);
		} else {
			String obj = "----Invalid login---";
			Logger.logger(obj);
		}

	}

}
