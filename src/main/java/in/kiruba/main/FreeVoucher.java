package in.kiruba.main;

import in.kiruba.log.Logger;
import in.kiruba.service.AmountPayableService;
import in.kiruba.service.FreeVoucherService;
import in.kiruba.service.PlanService;

public class FreeVoucher {

	public static void main(String[] args) {
		int userId = 77;
		int plan = 599;
		String network = "jio";
		boolean userAvailable = AmountPayableService.isUserAlreadyAvailable(userId);
		boolean scheme = PlanService.isSchemeAlreadyAvailable(plan, network);
		if (userAvailable) {
			if (scheme) {
				boolean valid = FreeVoucherService.freeVoucher(userId, network, plan);
				if (valid) {
					Logger.logger(
							"You are eligible for freevoucher" + "\n" + "---Recharge this plan and enjoy free voucher---");

				} else {
					Logger.logger("Recharge Popular Plans");
				}

			} else {
				Logger.logger("Choose valid scheme");
			}

		} else {
			Logger.logger("Enter Valid User Id");
		}

	}

}
