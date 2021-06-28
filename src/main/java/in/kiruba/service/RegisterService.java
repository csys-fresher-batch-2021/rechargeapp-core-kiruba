package in.kiruba.service;

import java.sql.SQLException;

import in.kiruba.dao.RegisterDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.model.User;

public class RegisterService {
	private RegisterService() {
		
	}
	public static boolean registerUser(User regobj) {
		
			try {
				RegisterDao.register(regobj);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ServiceException("Cannot call RegisterDao");
				
				
			}
		
		
		return true;
	}
	
	public static  boolean isUserAlreadyAvailable(User user) {
		RegisterDao dao = new RegisterDao();
		return dao.findUserAlreadtExistsOrNot(user);
	}
	
}
