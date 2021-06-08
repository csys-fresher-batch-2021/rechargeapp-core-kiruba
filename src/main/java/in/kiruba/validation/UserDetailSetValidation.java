package in.kiruba.validation;

public class UserDetailSetValidation {
	private UserDetailSetValidation() {
		
	}
	/*
	 * this method validate the parameter string is empty or not
	 */
	public static boolean isEmptyString(String userName) {
		boolean isValid=false;
		
		if(!(userName.trim().equals(""))) {
			isValid=true;
			
		}
		return isValid;
	}

}
