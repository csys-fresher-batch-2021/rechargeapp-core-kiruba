package app.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestService {
	@Test
	public void testService() {

		String name = "Kiruba";
		String password = "Livi@15";

		String email = "kiruba11@gmail.com";

		String mobileNo = "9025967216";

		String age = "41";

		String adhaarNo = "3447 7890 3257";

		boolean valid = RegisterMainService.test(name, password, email, age, mobileNo, adhaarNo);

		
		assertTrue(valid);

	}

}
