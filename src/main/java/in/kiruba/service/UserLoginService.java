package in.kiruba.service;

import in.kiruba.dao.UserLoginDao;
import in.kiruba.model.User;

public class UserLoginService {
	private UserLoginService() {

	}
    /**
     * This method is used to  find user with user Details parameters.
     * @param user
     * @return
     */
	
	public static boolean userLogin(String userName, String password) {
		
		boolean validUser = false;
		
			
			User user = new User(userName, password);
			
			User userDetail = UserLoginDao.getUserDetailsByUserName(user);
			
			
			if (userDetail.getPassword().equals(user.getPassword())) {

				validUser = true;
			}
		
		return validUser;

   }
	/**
	 * this method is used to to check the user detail is already present or not. 
	 * @param detail
	 * @return
	 */
	public static  boolean isUserAlreadyAvailable(User detail) {
		UserLoginDao dao = new UserLoginDao();
		return dao.findUserAlreadtExitOrNot(detail);
	}
}
