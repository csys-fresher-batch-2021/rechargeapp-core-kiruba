package in.kiruba.main;

import java.util.List;

import in.kiruba.log.Logger;
import in.kiruba.model.Plan;
import in.kiruba.service.PlanService;

public class PlanManager {

	public static void main(String[] args) {
		String network="jio";
        List<Plan> list=PlanService.getParticularNetworkList(network);
		Logger.logger(network);
		String string="----PLANS----";
		Logger.logger(string);
		boolean empty=list.isEmpty();
		if(!empty) {
		   for(Plan object:list) {
				Logger.logger(object);
			}
			
		}else{
			String statement="NO PLANS AVAIABLE";
			Logger.logger(statement);
		}
			
		

	}

}
