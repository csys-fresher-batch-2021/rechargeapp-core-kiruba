package in.kiruba.service;

import in.kiruba.model.User;

public class UserLoginService {
	private UserLoginService() {

	}
    /**
     * This method is used to call the find user with user parameters.
     * @param user
     * @return
     */
	public static boolean login(User user) {
		boolean validUser = false;

		if (FindUserService.findUser(user.getName(), user.getPassword())) {
			validUser = true;
		}

		return validUser;
	}

}
