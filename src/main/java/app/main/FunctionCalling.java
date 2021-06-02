package app.main;

import app.model.Register;
import app.service.RegisterService;

public class FunctionCalling {

	public static void main(String[] args) {
		
		
		String name="Kiruba";
		String password="Livi@15";
		
		String email="kiruba11@gmail.com";
		
		String mobileNo="9025967216";
		
		String age="23";
		
		String adhaarNo="3456 7890 2357";
		Register reg=new Register(name,password,email,mobileNo,age,adhaarNo);
		
		
		if(RegisterService.isValidUserDetails(name, password, email, age, mobileNo, adhaarNo)){
			RegisterService.register2(reg);
			
			
		}
		
		
		
	

	}

}