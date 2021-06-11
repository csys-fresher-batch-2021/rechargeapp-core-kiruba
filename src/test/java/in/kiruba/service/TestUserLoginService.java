package in.kiruba.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUserLoginService {
    /**
     * this test case is used to check the userLogin with correct user Details.
     */
	@Test
	public void testUserLoginServiceWithCorrectDetails() {
		boolean valid=UserLoginService.userLogin("Saras","Saras@20");
		assertTrue(valid);
		
	}
	/**
	 * this test case is used to check the userLogin with Incorrect user Details.
	 */
	@Test
	public void testUserLoginServiceWithInCorrectDetails() {
		boolean valid=UserLoginService.userLogin("saras","Saras20");
		assertFalse(valid);
		
	}
}
