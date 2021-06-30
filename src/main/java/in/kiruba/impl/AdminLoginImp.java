package in.kiruba.impl;


import java.sql.SQLException;
import java.util.Map;

import in.kiruba.model.AdminLogin;

public interface AdminLoginImp {
	
	public  void admin(AdminLogin admin);

	public  AdminLogin getUserDetailsByUserName(AdminLogin admin) throws ClassNotFoundException, SQLException;

	public  Map<String, String> getAllAdminDetails() throws SQLException, ClassNotFoundException;

	public boolean findAdminAlreadtExistsOrNot(AdminLogin admin);


}
