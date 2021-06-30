package in.kiruba.impl;

import java.sql.SQLException;

import in.kiruba.model.User;

public interface RegisterImp {
	
	public  void register(User reg) throws ClassNotFoundException, SQLException;

	public boolean findUserAlreadtExistsOrNot(User user);
	

}
