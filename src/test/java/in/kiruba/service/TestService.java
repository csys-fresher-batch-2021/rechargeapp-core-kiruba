package in.kiruba.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestService {
	@Test
	public void testService() {

		String name = "Livith";
		String password = "Livith@15";

		String email = "livith11@gmail.com";

		long mobileNo = 9999998880L;

		int age = 41;

		long adhaarNo = 344578903257L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, password, email, age, mobileNo, adhaarNo);

		
		assertTrue(valid);

	}

}
