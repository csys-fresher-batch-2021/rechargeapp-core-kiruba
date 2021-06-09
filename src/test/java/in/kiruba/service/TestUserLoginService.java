package in.kiruba.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.kiruba.model.User;

public class TestUserLoginService {

	@Test
	public void testUserLoginServiceWithCorrectDetails() {
		User user=new User("Saras","Saras@20");
		boolean valid=UserLoginService.login(user);
		assertTrue(valid);
		
	}
	@Test
	public void testUserLoginServiceWithInCorrectDetails() {
		User user=new User("saras","Saras20");
		boolean valid=UserLoginService.login(user);
		assertFalse(valid);
		
	}
}
