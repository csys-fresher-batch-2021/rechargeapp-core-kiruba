

package in.kiruba.validation;


    
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class RegisterValidation {
		private RegisterValidation() {

		}
		
			
		
		/*
		 * this method validate the string name,which is contains one upper case and lower case and must contain 3 to 12 characters.
		 */
		public static boolean isValidUserName(String userName) {
			boolean isValid = false;
			String regex = "^[a-zA-Z]{3,12}";
			if (UserDetailSetValidation.isEmptyString(userName)) {
				Pattern pattern = Pattern.compile(regex);
				Matcher match = pattern.matcher(userName);

				isValid = match.matches();

			}
            
			return isValid;
		}
		
		
			
		/*
		 * this method validate the string name,which is contains one upper case and lower case and must contain one numeric value and special character and 5 or more characters.
		 */
		

		public static boolean isValidPassword(String password) {
			boolean isValid = false;

			String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{5,}$";
			if (UserDetailSetValidation.isEmptyString(password)) {
				Pattern pattern = Pattern.compile(regex);
				Matcher match = pattern.matcher(password);

				isValid = match.matches();

			}
           
			return isValid;
		}
		/*
	   
	   .* A-Z characters allowed,a-z characters allowed, 0-9 numbers allowed, Additionally email may contain only dot(.), dash(-) and underscore(_),Rest all characters are not allowed.
        a-z characters allowed
        0-9 numbers allowed
        Additionally email may contain only dot(.), dash(-) and underscore(_)
        Rest all characters are not allowed
		 * this method validate the string email for certain conditions
		 */

		public static boolean isValidEmail(String email) {
			boolean isValid = false;

			String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
			if (UserDetailSetValidation.isEmptyString(email)) {
				Pattern pattern = Pattern.compile(regex);
				Matcher match = pattern.matcher(email);

				isValid = match.matches();

			}
			

			return isValid;
		}/*
		this method validate the age ,it is must grater than 0 and less than 60
		*/

		public static boolean isValidAge(int age) {
			boolean isValid = false;

				if (age > 0 && age<=100) {
					isValid = true;

				}
				return isValid;

			}
			
			
			
		/*
		this method validate the mobileNo which contain must 10 numbers.
		*/

		public static boolean isValidMobileno(long mobileNo) {
			boolean isValid = false;
			String mobileNumber=Long.toString(mobileNo);

			String regex = "^[0-9]{10}$";
			if (UserDetailSetValidation.isEmptyString(mobileNumber)) {
				Pattern pattern = Pattern.compile(regex);
				Matcher match = pattern.matcher(mobileNumber);

				isValid = match.matches();

			}
         
			return isValid;
		}
		/*
		 * this method validate the adhaarNo ,which contain 12 numbers.
		 */

		public static boolean isValidAdhaarNo(long adhaarNo) {
			boolean isValid = false;
			String aadharNumber=Long.toString(adhaarNo);

			String regex = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
			if (UserDetailSetValidation.isEmptyString(aadharNumber)) {
				Pattern pattern = Pattern.compile(regex);
				Matcher match = pattern.matcher(aadharNumber);

				isValid = match.matches();

			}
         
			return isValid;
		}

				
		

		
	   
		
	  
		

	}




