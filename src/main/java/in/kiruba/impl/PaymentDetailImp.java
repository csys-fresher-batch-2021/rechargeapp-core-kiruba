package in.kiruba.impl;


import java.sql.SQLException;
import in.kiruba.model.PaymentDetail;

public interface PaymentDetailImp {
	
	public  boolean payment(PaymentDetail pay) throws SQLException, ClassNotFoundException;

	public  PaymentDetail getTransactionDetail(int userId) throws SQLException, ClassNotFoundException;
	public boolean findUserAlreadtExistsOrNot(int userId);

}
