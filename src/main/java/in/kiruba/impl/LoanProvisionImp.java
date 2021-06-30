package in.kiruba.impl;


import java.sql.SQLException;

public interface LoanProvisionImp {
	
	public  boolean loanPayment(int userId) throws SQLException, ClassNotFoundException;

	public  boolean isValidUserForLoan(int userId);

}
