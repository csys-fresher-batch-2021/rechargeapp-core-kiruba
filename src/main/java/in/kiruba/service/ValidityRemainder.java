package in.kiruba.service;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import in.kiruba.dao.PaymentDetailDao;
import in.kiruba.model.PaymentDetail;

public class ValidityRemainder {
	private ValidityRemainder() {
		
	}
	
	public static long remainingValidity(int plan,String network) throws ClassNotFoundException, SQLException{
	    
	    int validityDays=AmountPayableService.getValidityInPayment(plan,network);
	    long validityPeriod=0;
	  
		PaymentDetail detail;
		detail=PaymentDetailDao.getTransactionDetail(plan,network);
		Date transactionDate=detail.getDate();
		LocalDate localDate = Instant.ofEpochMilli(transactionDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
		
		LocalDate expiryDate=CalculateExpriyDate.calculateExpriyDateOfLocalDate(localDate,validityDays);
		validityPeriod = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
		 		 
				
		return validityPeriod;
		
		
		
	}

		
		
		
}
	
	
	
	


