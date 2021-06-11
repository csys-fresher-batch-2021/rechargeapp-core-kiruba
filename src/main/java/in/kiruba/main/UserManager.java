package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.model.User;
import in.kiruba.service.UserLoginService;
import in.kiruba.validation.RegisterValidation;

public class UserManager {

	public static void main(String[] args) {
		String name = "Livith";
		String key = "Livith@15";
		User user = new User(name, key);
		boolean valid = UserLoginService.isUserAlreadyAvailable(user);
        if(RegisterValidation.isValidUserName(name)&&RegisterValidation.isValidPassword(key)) {
		if ((valid) && (UserLoginService.userLogin(name, key))) {

			String object = "----Successfully login---";
			Logger.logger(object);
		} else {
			String object = "----Invalid login---";
			Logger.logger(object);
		}
        }else {
        	String object="**Please Enter Valid Name and Key***";
        	Logger.logger(object);
        }

	}

}
