package in.kiruba.main;

import java.sql.SQLException;

import in.kiruba.exception.ServiceException;
import in.kiruba.log.Logger;
import in.kiruba.model.AdminLogin;
import in.kiruba.service.AdminService;

public class AddAdminManager {

	public static void main(String[] args) {
		String adminName="Varun";
		String adminKey="Sara#123";
		AdminLogin obj=new AdminLogin(adminName,adminKey);
		try {
			if(AdminService.checkAdminExistsOrNot(adminName, adminKey)) {
				String object="Admin is Alreay Exists";
				Logger.logger(object);
			}else {
			
			if(AdminService.adminLogin(obj)) {
				
				String object="---Successfully Added---";
				Logger.logger(object);
			}else {
				String object="---Cannot Added---";
				Logger.logger(object);
			}
}
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Cannot find Admin details");
		}
		
		

	}

}
