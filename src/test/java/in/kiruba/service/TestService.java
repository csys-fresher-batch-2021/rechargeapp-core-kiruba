package in.kiruba.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestService {
	@Test
	public void testService() {

		String name = "Kavitha";
		String password = "Livith@15";

		String email = "Kavith11@gmail.com";

		long mobileNo = 9991998880L;

		int age = 41;

		long adhaarNo = 340578903257L;

		boolean valid = RegisterServiceValidation.checkUserDetail(name, password, email, age, mobileNo, adhaarNo);

		
		assertTrue(valid);

	}

}
