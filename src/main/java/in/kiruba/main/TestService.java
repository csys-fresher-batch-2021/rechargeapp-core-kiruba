package in.kiruba.main;

import in.kiruba.model.User;
import in.kiruba.service.RegisterService;
import in.kiruba.valid.ValidUserDetail;

public class TestService {

	public static void main(String[] args) {
		
		
		String name="Priya";
		String password="Kavi@15";
		
		String email="kirubi11@gmail.com";
		
		String mobileNo="9999999789";
		
		int age=23;
		
		String adhaarNo="2456 7890 2357";
		User reg=new User(name,password,email,age,mobileNo,adhaarNo);
				
		if(ValidUserDetail.isValidUserDetails(name, password, email, age, mobileNo, adhaarNo)){
			RegisterService.callRegisterDao(reg);
			System.out.println("Successfully registered");
			
			
		}else {
			System.out.println("Invalid Credentials");
		}
		
		
		
	

	}

}