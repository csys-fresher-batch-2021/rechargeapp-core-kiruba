package in.kiruba.main;

import java.util.Date;

import in.kiruba.log.Logger;
import in.kiruba.service.CalculateExpriyDate;
import in.kiruba.service.PlanService;

public class ExprityDateManager {

	public static void main(String[] args) {
		int plan=2599;
		String network="jio";
		String[] array=PlanService.detials(plan, network);
		for(String i:array) {
			Logger.logger(i);
		}
		
		String statement1="---TODAY DATE-----";
		Logger.logger(statement1);
		Date date=new Date();
		Logger.logger(date);
		
		String day=PlanService.findDays(plan,network);
		int y=Integer.parseInt(day);
		String expriyDate=CalculateExpriyDate.calculateExpriyDate(y);
		
		String statement="----SCHEME EXPRIY DATE----";
		Logger.logger(statement);		
		Logger.logger(expriyDate);
		
			
			
			
		}
	


	

}
