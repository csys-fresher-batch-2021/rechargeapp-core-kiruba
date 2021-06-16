package in.kiruba.main;

import java.util.List;

import in.kiruba.log.Logger;
import in.kiruba.model.Plan;
import in.kiruba.service.PlanService;

public class AllPlansManager {

	public static void main(String[] args) {
		List<Plan> list=PlanService.getAllNetworkService();
		String statement="---All Popular Plans---";
		Logger.logger(statement);
		for(Plan net:list) {
			Logger.logger(net);
		}
	

	}

}
