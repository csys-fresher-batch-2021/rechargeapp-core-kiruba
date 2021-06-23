package in.kiruba.main;

import in.kiruba.dao.AdditionalPlanDao;
import in.kiruba.log.Logger;
import in.kiruba.model.AdditionalPlan;
import in.kiruba.service.AdditionalPlanService;

public class AdditionalPlanManager {

	public static void main(String[] args) {
		int scheme = 599;
		int userId = 67;
		boolean additionalValid = AdditionalPlanService.isAdditionalPlanAlreadyAvailable(scheme);

		if (additionalValid) {
			AdditionalPlan validity = AdditionalPlanDao.getExtraPlanDetail(scheme);
			String planValidity = validity.getValidity();
			String network = validity.getNetwork();
			String data = validity.getData();
			String subscription = validity.getSubscription();
			long mobileNumber = 9999991234L;
			AdditionalPlan object = new AdditionalPlan(scheme, network, planValidity, data, subscription, userId, mobileNumber);
			AdditionalPlanService.isValidAdditionalPlan(scheme, object);

		} else {
			String statementObject = "Scheme Does Not Exists";
			Logger.logger(statementObject);
		}
	}

}
