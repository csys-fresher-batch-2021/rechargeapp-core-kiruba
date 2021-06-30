package in.kiruba.impl;

import java.util.List;

import in.kiruba.model.Plan;

public interface PlanImp {
	
	public  List<Plan> getAllPlanLists();

	public  Plan getExpriyDate(int plan, String network);

	public  List<Integer> getAllPlans();

	public  Plan getAllPlanDetails(int plan);

	public boolean findPlanAlreadyExistsOrNot(int scheme,String system);


}
