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
	 * 
	 * @return
	 */
	public static List<Plan> getAllNetworkService() {

		List<Plan> list;
		list = PlanDao.getAllPlanLists();
		return list;

	}

	/**
	 * this method return list of plans for particular network.
	 * 
	 * @param network
	 * @return
	 */

	public static List<Plan> getParticularNetworkList(String network) {

		List<Plan> list;
		list = ParticularPlan.getParticularNetworkList(network);
		return list;

	}
	/**
	 * this method return list of all plans.
	 * @param plan
	 * @return
	 */
	public static List<Integer> getAllPlans() {

		List<Integer> list;
		list = PlanDao.getAllPlans();
		return list;

	}
	/**
	 * this method check the list contain the plan.
	 * @param amount
	 * @return
	 */
	public static boolean validAmount(int plan) {
		boolean valid=false;
		List<Integer> list;
		list=getAllPlans();
		if(list.contains(plan)) {
			valid=true;
		}
		
		
	return valid;
	}
	
	/**
	 * this method find the days from validity. 
	 * @param plan
	 * @param network
	 * @return
	 */

	public static String findDays(int plan, String network) {

		Plan userDetail = PlanDao.getExpriyDate(plan, network);
		String str = userDetail.getValidity();

		str = str.replaceAll("[^0-9]", "");

		return str;

	}
	/**
	 * this method return details of scheme
	 * @param plan
	 * @param network
	 * @return
	 */

	public static String[] detials(int plan, String network) {

		Plan userDetail = PlanDao.getExpriyDate(plan, network);

		String[] detail;
		detail = new String[] { "NETWORK " + userDetail.getNetworkName(), "VALIDITY " + userDetail.getValidity(),
				"DATA " + userDetail.getData(), "SUBSCRIPTION " + userDetail.getSubscriptions() };

		return detail;

	}
	/**
	 * this method is find the scheme is already available or not.
	 * @param plan
	 * @param network
	 * @return
	 */
	public static  boolean isSchemeAlreadyAvailable(int plan,String network) {
		PlanDao dao = new PlanDao();
		return dao.findPlanAlreadyExistsOrNot(plan,network);
	}

}
