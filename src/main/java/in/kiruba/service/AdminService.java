package in.kiruba.service;

import java.sql.SQLException;
import java.util.Set;

import in.kiruba.dao.AdminLoginDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.model.AdminLogin;
import in.kiruba.validation.RegisterValidation;

public class AdminService {
	private AdminService() {

	}

	public static boolean adminLogin(AdminLogin obj) {
		try {
			AdminLoginDao.admin(obj);

		} catch (ServiceException e) {

			throw new ServiceException("Cannot call AdminLoginDao");
		}
		return true;
	}

	public static boolean addAdmin(AdminLogin obj) {

		try {
			AdminLoginDao.admin(obj);

		} catch (ServiceException e) {

			throw new ServiceException("Cannot call");
		}
		return true;
	}

	public static boolean login(String userName, String password) {
		boolean validUser = false;
		if (RegisterValidation.isValidUserName(userName) && RegisterValidation.isValidPassword(password)) {

			AdminLogin user = new AdminLogin(userName, password);

			AdminLogin userDetail = null;
			try {
				userDetail = AdminLoginDao.getUserDetailsByUserName(user);
				if ((userDetail.getAdminPassword()).equalsIgnoreCase(user.getAdminPassword())) {

					validUser = true;
				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new ServiceException("Cannot get Admin Details");
			}

		}
		return validUser;

	}

	public static boolean checkAdminExistsOrNot(String userName, String password)
			throws ClassNotFoundException, SQLException {
		boolean validUser = false;
		if (RegisterValidation.isValidUserName(userName) && RegisterValidation.isValidPassword(password)) {
			Set<String> keys = AdminLoginDao.getAllAdminDetails().keySet();
			for (String key : keys) {
				String value = AdminLoginDao.getAllAdminDetails().get(key);
				if (userName.equals(key) && password.equals(value)) {
					validUser = true;
					break;
				}
			}
		}
		return validUser;

	}

	public static boolean adminService(AdminLogin obj) {
		boolean valid = false;

		if (login(obj.getAdminName(), obj.getAdminPassword())) {
			valid = true;
		}

		return valid;
	}

	public static boolean isAdminAlreadyAvailable(AdminLogin detail) {
		AdminLoginDao dao = new AdminLoginDao();
		return dao.findAdminAlreadtExistsOrNot(detail);
	}

}
