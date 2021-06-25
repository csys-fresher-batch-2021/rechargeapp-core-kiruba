package in.kiruba.main;

import java.sql.SQLException;
import java.util.Date;

import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.log.Logger;
import in.kiruba.model.PaymentDetail;

public class MyRecharge {

	public static void main(String[] args) {
		int userId=299;
		PaymentDetail detail = null;
		try {
			detail = PaymentDetailDao.getTransactionDetail(userId);
			int payment=detail.getPlan();
			String networkName=detail.getNetwork();
			Date rechargeDate=detail.getDate();
			long mobileNumber=detail.getMobileNumber();
			String status="SUCCESS";
			String statement="YOUR RECHARGE DETAILS";
			Logger.logger(statement);
			String string="PLAN: "+ payment +" \nNETWORK: "+networkName +" \nDATE: "+rechargeDate+" \nMOBILENUMBER:"+mobileNumber;
			Logger.logger(string);Logger.logger(status);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Unable to get rechage details");
			
		}
		
	}

}
