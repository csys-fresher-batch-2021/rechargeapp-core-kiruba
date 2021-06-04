package in.kiruba.valid;

import in.kiruba.exception.MyException;
import in.kiruba.validation.RegisterValidation;

public class ValidUserDetail {
	
	public static boolean isValidUserDetails(String name,String password,String email,int age,String mobileNo,String adhaarNo) {
		boolean valid=false;
		
		try {
			if(RegisterValidation.isValidUserName(name)&&
			RegisterValidation.isValidPassword(password)&&
			
			RegisterValidation.isValidEmail(email)&&
			RegisterValidation.isValidAge(age)&&
			RegisterValidation.isValidAdhaarNo(adhaarNo)&&
			RegisterValidation.isValidMobileno(mobileNo)) {
				valid=true;
				
			}
		} catch (MyException e) {
			
			throw new MyException("User Detail are Not Valid");
		
		
		}
		
		
		return valid;
		
		
		
	}



}
