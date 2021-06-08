package in.kiruba.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestService {
	@Test
	public void testService() {

		String name = "Kaviya";
		String key = "Kavi@123";

		String email = "kavi17@gmail.com";

		long mobileNo = 9909908080L;

		int age = 41;

		long adhaarNo = 542578903257L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, key, email, age, mobileNo, adhaarNo);

		
		assertTrue(valid);

	}
	@Test
	public void testServiceWithIncorrectUserName() {

		String name = "livith";
		String key = "Livith15";

		String email = "livith20@gmail.com";

		long mobileNo = 9999998809L;

		int age = 23;

		long adhaarNo = 344578903571L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, key, email, age, mobileNo, adhaarNo);

		
		assertFalse(valid);

	}
	@Test
	public void testServiceWithIncorrectUserPssword() {

		String name = "Livith";
		String key = "livith15";

		String email = "livith20@gmail.com";

		long mobileNo = 9999998802L;

		int age = 87;

		long adhaarNo = 344578190357L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, key, email, age, mobileNo, adhaarNo);

		
		assertFalse(valid);

	}
	@Test
	public void testServiceWithIncorrectEmail() {

		String name = "Livith";
		String key = "Livith@15";

		String email = "livith1gmail.com";

		long mobileNo = 9999998802L;

		int age = 56;

		long adhaarNo = 344578190357L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, key, email, age, mobileNo, adhaarNo);

		
		assertFalse(valid);

	}
	@Test
	public void testServiceWithIncorrectAge() {

		String name = "Livith";
		String key = "Livith@15";

		String email = "livith20@gmail.com";

		long mobileNo = 9999998802L;

		int age = 0;

		long adhaarNo = 344578190357L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, key, email, age, mobileNo, adhaarNo);

		
		assertFalse(valid);

	}
	@Test
	public void testServiceWithIncorrectMobileNumber() {

		String name = "Livith";
		String key = "Livith@15";

		String email = "livith20@gmail.com";

		long mobileNo = 999999802L;

		int age = 34;

		long adhaarNo = 344578190357L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, key, email, age, mobileNo, adhaarNo);

		
		assertFalse(valid);

	}
	@Test
	public void testServiceWithIncorrectAdhaarNumber() {

		String name = "Livith";
		String key = "Livith@15";

		String email = "livith80@gmail.com";

		long mobileNo = 9999998802L;

		int age = 54;

		long adhaarNo = 34457890357L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, key, email, age, mobileNo, adhaarNo);

		
		assertFalse(valid);

	}


}
