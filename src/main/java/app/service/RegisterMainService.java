package app.service;

import app.model.User;

public class RegisterMainService {
	private RegisterMainService() {
		
	}
	public static boolean test(String name,String password,String email,String age,String mobileNo,String adhaarNo) {
		boolean valid=false;
		User reg=new User(name,password,email,mobileNo,age,adhaarNo);
		
	
	
	boolean isRegister=RegisterService.isValidUserDetails(name, password, email, age, mobileNo, adhaarNo);
	if(isRegister) {
		
	
		RegisterService.register2(reg);
		valid=true;
		
	
		
	}
	return valid;
	
	

	

}
}
