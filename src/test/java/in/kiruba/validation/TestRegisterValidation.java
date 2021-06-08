package in.kiruba.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRegisterValidation {
	

	
        /*
         * this test case validate the string name with correct detail.
         */
		@Test
		public void testwithCorrectName() {

			boolean valid = RegisterValidation.isValidUserName("Kiruba");
			assertTrue(valid);

		}
		 /*
         * this test case validate the string name with Incorrect detail.
         */

		@Test
		public void testwithInCorrectName() {

			boolean valid = RegisterValidation.isValidUserName("livi16");
			assertFalse(valid);

		} /*
         * this test case validate the string password with correct detail.
         */

		@Test
		public void testwithCorrectPassword() {

			boolean valid = RegisterValidation.isValidPassword("Kiru@15");
			assertTrue(valid);

		}
		 /*
         * this test case validate the string password with Incorrect detail.
         */

		@Test
		public void testwithInCorrectPassword() {

			boolean valid = RegisterValidation.isValidPassword("Karu15");
			assertFalse(valid);

		}
		 /*
         * this test case validate the string email with correct detail.
         */

		@Test
		public void testwithCorrectEmail() {

			boolean valid = RegisterValidation.isValidEmail("kiruba15@gmail.com");
			assertTrue(valid);

		}
		 /*
         * this test case validate the string email with Incorrect detail.
         */

		@Test
		public void testwithInCorrectEmail() {

			boolean valid = RegisterValidation.isValidEmail("kirubagmail.com");
			assertFalse(valid);

		}
		 /*
         * this test case validate the long mobileNo with correct detail.
         */

		@Test
		public void testwithCorrectMobileNo() {

			boolean valid = RegisterValidation.isValidMobileno(9999999999L);
			assertTrue(valid);

		} /*
         * this test case validate the long mobileNo with Incorrect detail.
         */

		@Test
		public void testwithInCorrectMobileNo() {

			boolean valid = RegisterValidation.isValidMobileno(888888888L);
			assertFalse(valid);

		}
		 /*
         * this test case validate the long adhaarNo with correct detail.
         */

		@Test
		public void testwithCorrectAdhaarNo() {

			boolean valid = RegisterValidation.isValidAdhaarNo(345678902345L);
			assertTrue(valid);

		}
		 /*
         * this test case validate the long adhaarNo with Incorrect detail.
         */

		@Test
		public void testwithInCorrectAdhaarNo() {

			boolean valid = RegisterValidation.isValidAdhaarNo(34567890234L);
			assertFalse(valid);

		}
		 /*
         * this test case validate the int age with correct detail.
         */

		
		@Test
		public void testwithCorrectAge() {

			boolean valid = RegisterValidation.isValidAge(45);
			assertTrue(valid);

		}
		 /*
         * this test case validate the int age with Incorrect detail.
         */

		@Test
		public void testwithInCorrectAge() {

			boolean valid = RegisterValidation.isValidAge(0);
			assertFalse(valid);

		}

	}


	


