package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.model.User;
import in.kiruba.service.UserLoginService;

public class UserManager {

	public static void main(String[] args) {
		String name = "Kaviya";
		String key = "Kavi@123";
		User user = new User(name, key);

		boolean valid = UserLoginService.login(user);
		if (valid) {
			String obj="----Successfully login---";
			Logger.logger(obj);
		} else {
			String obj="----Invalid login---";
			Logger.logger(obj);
		}

	}

}
