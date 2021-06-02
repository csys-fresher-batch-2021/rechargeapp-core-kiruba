package app.validation;

public class UserDetailSetValidation {
	private UserDetailSetValidation() {
		
	}
	/*
	 * thi method validate the string is empty or not
	 */
	public static boolean isEmptyString(String userName) {
		boolean isValid=false;
		
		if(!(userName.trim().equals(""))) {
			isValid=true;
			
		}
		return isValid;
	}

}
