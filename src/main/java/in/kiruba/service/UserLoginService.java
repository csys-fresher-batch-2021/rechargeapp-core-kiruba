package in.kiruba.service;

import in.kiruba.dao.UserLoginDao;
import in.kiruba.model.User;
import in.kiruba.validation.RegisterValidation;

public class UserLoginService {
	private UserLoginService() {

	}

	/**
	 * This method is used to find user with user Details parameters.
	 * 
	 * @param user
	 * @return
	 */

	public static boolean userLogin(String userName, String password) {
		boolean validUser = false;
		if (RegisterValidation.isValidUserName(userName) && RegisterValidation.isValidPassword(password)) {

			User user = new User(userName, password);

			User userDetail = UserLoginDao.getUserDetailsByUserNameAndUserPassword(user);

			if (userDetail.getPassword().equals(user.getPassword())) {

				validUser = true;
			}
		}
		return validUser;

	}
}
