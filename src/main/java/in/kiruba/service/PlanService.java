package in.kiruba.service;

import java.util.List;

import in.kiruba.dao.ParticularPlan;
import in.kiruba.dao.PlanDao;
import in.kiruba.model.Plan;

public class PlanService {
	private PlanService() {

	}
    /**
     * this method return list of plans Details.
     * @return
     */
	public static List<Plan> getAllnetworkService() {

		List<Plan> list;
		list = PlanDao.getAllPlanLists();
		return list;

	}
	/**
	 * this method return list of plans for particular network.
	 * @param network
	 * @return
	 */

	public static List<Plan> getParticularNetworkList(String network) {

		List<Plan> list;
		list = ParticularPlan.getParticularNetworkList(network);
		return list;

	}
}
