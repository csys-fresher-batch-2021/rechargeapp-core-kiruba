package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.service.ProvidingLoanService;

public class LoanProvision {

	public static void main(String[] args) {
		int userId=46;
		int loanChoice=1;
		boolean valid=ProvidingLoanService.providingLoan1(userId,loanChoice);
		if(valid) {
			String string="Recharge Successful";
			Logger.logger(string);
		}else {
			String object="Do recharge quickly";
			Logger.logger(object);
		}
		

	}
	
	

}
