package in.kiruba.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.kiruba.model.User;

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
		boolean valid=UserLoginService.userLogin("Saras","Saras@2");
		assertFalse(valid);
		
	}
	@Test
	public void testUserExistsOrNot() {
		User  user=new User("Saras","Saras@20");
		boolean valid=UserLoginService.isUserAlreadyAvailable(user);
		assertTrue(valid);
		
	}
	@Test
	public void testUserExistsOrNot1() {
		User  user=new User("Kamal","Saras@20");
		boolean valid=UserLoginService.isUserAlreadyAvailable(user);
		assertFalse(valid);
		
	}
}
