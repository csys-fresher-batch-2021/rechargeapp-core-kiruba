package in.kiruba.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import in.kiruba.log.Logger;

public class CalculateExpiryDate {
	private CalculateExpiryDate() {
		
	}
	/**
	 * this method is used to calculate the expire date.
	 * @param days
	 * @return
	 */
	
	public static String calculateExpiryDate(int days) {
		String expriyDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    Calendar c = Calendar.getInstance();
	    LocalDate date=LocalDate.now();
	    Logger.logger(date);
	    c.setTime(new Date()); 
	    c.add(Calendar.DATE, days); 
	    expriyDate=sdf.format(c.getTime());
	    return expriyDate;
	
	}
	public static LocalDate calculateExpiryDateOfLocalDate(LocalDate transactionDate,int days) {
		LocalDate date;
		date=transactionDate.plusDays(days);
		
		return date;
	
	}
	
   
}
