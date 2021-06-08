package in.kiruba.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestService {
	@Test
	public void testService() {

		String name = "Jeeva";
		String password = "Jeeva@123";

		String email = "pavi2000@gmail.com";

		long mobileNo = 9999908880L;

		int age = 41;

		long adhaarNo = 342578903257L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, password, email, age, mobileNo, adhaarNo);

		
		assertTrue(valid);

	}
	@Test
	public void testServiceWithIncorrectDetails() {

		String name = "livith";
		String password = "Livith15";

		String email = "livith@gmail.com";

		long mobileNo = 999999880L;

		int age = 0;

		long adhaarNo = 34457890357L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, password, email, age, mobileNo, adhaarNo);

		
		assertFalse(valid);

	}

}
