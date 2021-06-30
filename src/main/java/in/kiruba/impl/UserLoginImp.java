package in.kiruba.impl;

import in.kiruba.model.User;

public interface UserLoginImp {
	
	public  User getUserDetailsByUserName(User user);

	public  boolean findUserAlreadtExitOrNot(User user);

}
