package in.kiruba.main;

import java.sql.SQLException;
import java.util.Date;

import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.impl.PaymentDetailImp;
import in.kiruba.log.Logger;
import in.kiruba.model.PaymentDetail;
import in.kiruba.service.AmountPayableService;

public class MyRecharge {

	public static void main(String[] args) {
		int userId = 77;
		PaymentDetail detail = null;
		boolean valid = AmountPayableService.isUserAlreadyAvailable(userId);
		if (valid) {
			PaymentDetailImp dao=new PaymentDetailDao();
			try {
				detail = dao.getTransactionDetail(userId);
				int payment = detail.getPlan();
				String networkName = detail.getNetwork();
				Date rechargeDate = detail.getDate();
				long mobileNumber = detail.getMobileNumber();
				String status = "SUCCESS";
				String statement = "YOUR RECHARGE DETAILS";
				Logger.logger(statement);
				String string = "PLAN: " + payment + " \nNETWORK: " + networkName + " \nDATE: " + rechargeDate
						+ " \nMOBILENUMBER:" + mobileNumber;
				Logger.logger(string);
				Logger.logger(status);
			} catch (ClassNotFoundException | SQLException e) {
				throw new ServiceException("Unable to get rechage details");

			}
		} else {
			String string = "Invalid user Id";
			Logger.logger(string);
		}

	}

}
