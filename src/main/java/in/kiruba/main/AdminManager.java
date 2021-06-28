package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.model.AdminLogin;
import in.kiruba.service.AdminService;

public class AdminManager {

	public static void main(String[] args) {
		String adminName="Livith";
		String adminPassword="Sara@123";
		AdminLogin admin=new AdminLogin(adminName,adminPassword);
		boolean valid=AdminService.isAdminAlreadyAvailable(admin);
		if(valid) {
			
		
		if(AdminService.adminService(admin)) {
			
			String object="---Successfully login---";
			Logger.logger(object);
		}else {
			String object="---Invalid login---";
			Logger.logger(object);
		}
		}else {
			String statement="Invalid credentials";
			Logger.logger(statement);
		}
		
	

	}

}
