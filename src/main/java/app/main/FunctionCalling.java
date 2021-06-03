package app.main;

import app.model.User;
import app.service.RegisterService;

public class FunctionCalling {

	public static void main(String[] args) {
		
		
		String name="Priya";
		String password="Kavi@15";
		
		String email="kirubi11@gmail.com";
		
		String mobileNo="9025767210";
		
		String age="23";
		
		String adhaarNo="2456 7890 2357";
		User reg=new User(name,password,email,mobileNo,age,adhaarNo);
				
		if(RegisterService.isValidUserDetails(name, password, email, age, mobileNo, adhaarNo)){
			RegisterService.register2(reg);
			System.out.println("Successfully registered");
			
			
		}else {
			System.out.println("Invalid Credentials");
		}
		
		
		
	

	}

}