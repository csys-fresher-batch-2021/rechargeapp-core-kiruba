package app.validation;

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
         * this test case validate the string mobileNo with correct detail.
         */

		@Test
		public void testwithCorrectMobileNo() {

			boolean valid = RegisterValidation.isValidMobileno("9025967216");
			assertTrue(valid);

		} /*
         * this test case validate the string mobileNo with Incorrect detail.
         */

		@Test
		public void testwithInCorrectMobileNo() {

			boolean valid = RegisterValidation.isValidMobileno("902596721");
			assertFalse(valid);

		}
		 /*
         * this test case validate the string adhaarNo with correct detail.
         */

		@Test
		public void testwithCorrectAdhaarNo() {

			boolean valid = RegisterValidation.isValidAdhaarNo("3456 7890 2345");
			assertTrue(valid);

		}
		 /*
         * this test case validate the string adhaarNo with Incorrect detail.
         */

		@Test
		public void testwithInCorrectAdhaarNo() {

			boolean valid = RegisterValidation.isValidAdhaarNo("3456 7890 234");
			assertFalse(valid);

		}
		 /*
         * this test case validate the string age with correct detail.
         */

		
		@Test
		public void testwithCorrectAge() {

			boolean valid = RegisterValidation.isValidAge("45");
			assertTrue(valid);

		}
		 /*
         * this test case validate the string age with Incorrect detail.
         */

		@Test
		public void testwithInCorrectAge() {

			boolean valid = RegisterValidation.isValidAge("0");
			assertFalse(valid);

		}

	}


	


