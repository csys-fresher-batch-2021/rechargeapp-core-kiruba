package in.kiruba.service;

import java.sql.SQLException;

import in.kiruba.dao.RegisterDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.impl.RegisterImp;
import in.kiruba.model.User;

public class RegisterService {
	private RegisterService() {
		
	}
	public static boolean registerUser(User regobj) {
		RegisterImp dao=new RegisterDao();
		
			try {
				dao.register(regobj);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ServiceException("Cannot call RegisterDao");
				
				
			}
		
		
		return true;
	}
	
	public static  boolean isUserAlreadyAvailable(User user) {
		RegisterImp dao = new RegisterDao();
		return dao.findUserAlreadtExistsOrNot(user);
	}
	
}
