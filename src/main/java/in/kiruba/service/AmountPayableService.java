package in.kiruba.service;

import java.sql.SQLException;

import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.exception.ServiceException;
import in.kiruba.model.PaymentDetail;

public class AmountPayableService {
	AmountPayableService(){
		
	}
	/**
	 * this method insert the payment details into database.
	 * @param object
	 * @return
	 */
	
	public static boolean payableService(PaymentDetail object) {
		boolean valid=false;
		
			try {
				valid=PaymentDetailDao.payment(object);
			} catch (ClassNotFoundException | SQLException e) {
				throw new ServiceException("Try Other Plans");
	
				
			}
			
			return valid;
				
			
		}
		
	
		
	}


