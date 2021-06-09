package in.kiruba.service;

import java.util.Set;

import in.kiruba.dao.UserLoginDao;
import in.kiruba.validation.RegisterValidation;

public class FindUserService {
	private FindUserService() {

	}

	/**
	 * This method find the user in users table in database after validate the user
	 * name and password.
	 * 
	 * @param name
	 * @param password
	 * @return
	 */

	public static boolean findUser(String name, String password) {
		boolean isValid = false;

		if (RegisterValidation.isValidUserName(name) && RegisterValidation.isValidPassword(password)) {

			Set<String> keys = UserLoginDao.getAllUserDetails().keySet();
			for (String key : keys) {
				String value = UserLoginDao.getAllUserDetails().get(key);
				if (name.equals(key) && password.equals(value)) {
					isValid = true;
					break;
				}
			}
		}
		return isValid;
	}

}
