package in.kiruba.impl;


import java.sql.SQLException;

import in.kiruba.model.AdditionalPlan;

public interface AdditionalPlanImp {
	
	public  void extraPlan(AdditionalPlan plan) throws ClassNotFoundException, SQLException;

	public  AdditionalPlan getExtraPlanDetail(int plan);

	public  void additionalPlan(AdditionalPlan plan) throws ClassNotFoundException, SQLException;

	public boolean findAdditionalPlanAlreadyExistsOrNot(int plan);


}
