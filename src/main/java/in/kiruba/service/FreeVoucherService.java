package in.kiruba.service;

import java.time.LocalDate;

import in.kiruba.dao.PlanDao;
import in.kiruba.log.Logger;
import in.kiruba.model.Plan;

public class FreeVoucherService {
	private FreeVoucherService() {

	}
	/**
	 * this method check user valid for free voucher.
	 * @param userId
	 * @param network
	 * @param plan
	 * @return
	 */

	public static boolean freeVoucher(int userId, String network, int plan) {
		boolean valid = false;

		LocalDate expiry = ValidityRemainder.findExpiryDate(userId);
		if (LocalDate.now().isBefore(expiry)) {
			valid = true;
			int validity = AmountPayableService.getValidity(plan, network);
			Plan data = PlanDao.getExpriyDate(plan, network);
			String mobileData = data.getData();
			Logger.logger("Scheme MobileData: " + mobileData);

			if (validity <= 35) {
				String object = "2 GB";
				Logger.logger("Voucher Data " + object);
			} else if (validity > 35 && validity <= 65) {
				String object = "4 GB";
				Logger.logger("FREEVOUCHER " + object);
			} else if (validity > 65 && validity <= 95) {
				String object = "6 GB";
				Logger.logger("FREEVOUCHER DATA " + object);
			}else if(validity>95&&validity<=182) {
				String string="12 GB";
				Logger.logger(string);
			}
			else if(validity>182&&validity<=365){
				String object1="24 GB";
				Logger.logger("Voucher "+object1);
			}
			else {
				String string = "sry! This plan does not have free voucher";
				Logger.logger(string);
			}

		} else {
			String statement = "Free voucher is unavailable";
			Logger.logger(statement);
		}
		return valid;
	}

}
