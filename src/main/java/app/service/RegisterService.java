package app.service;

import app.dao.RegisterDao;
import app.exception.ServiceException;

import app.model.User;
import app.validation.RegisterValidation;


public class RegisterService {
	private RegisterService() {
		
	}
	public static boolean register2(User regobj) {
		try {
			RegisterDao.register1(regobj);
			
			
		} catch (ServiceException e) {
			
			throw new ServiceException("cannot call RegisterDao");
			
	
			
		}
		return true;
	}
	/*
	 * this method validate the string parameters with certain conditions.
	 */
	public static boolean isValidUserDetails(String name,String password,String email,String age,String mobileNo,String adhaarNo) {
		boolean valid=false;
		
		if(RegisterValidation.isValidUserName(name)&&
		RegisterValidation.isValidPassword(password)&&
		
		RegisterValidation.isValidEmail(email)&&
		RegisterValidation.isValidAge(age)&&
		RegisterValidation.isValidAdhaarNo(adhaarNo)&&
		RegisterValidation.isValidMobileno(mobileNo)) {
			valid=true;
			
		}
		
		
		return valid;
		
		
		
	}


}
