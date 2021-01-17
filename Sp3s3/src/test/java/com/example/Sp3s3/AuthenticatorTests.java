package com.example.Sp3s3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.User;
import com.model.UserAuthenticator;

public class AuthenticatorTests 
{
	@BeforeEach
	public void init()
	{
		UserAuthenticator.validUserDatabase.add(new User("Matt", "pass"));
		UserAuthenticator.validUserDatabase.add(new User("Reph", "pass"));
		UserAuthenticator.validUserDatabase.add(new User("Krishna", "pass"));
		UserAuthenticator.validUserDatabase.add(new User("Amarjeet", "pass"));
	}
	
	@Test
	public void loginTest()
	{
		UserAuthenticator ua = new UserAuthenticator();
		
		assertEquals(true, ua.login("Matt", "pass"));
	}
	
	@Test
	public void badLoginTest()
	{
		UserAuthenticator ua = new UserAuthenticator();
		
		assertEquals(false, ua.login("Matt", "BadPass"));
	}
	
	@Test
	public void usernameRetrievalTest()
	{
		UserAuthenticator ua = new UserAuthenticator();
		
		assertEquals(true, ua.login("Matt", "pass"));
		
		assertEquals("Matt", ua.getActiveUsername());
	}
	
	@Test
	public void passwordRetrievalTest()
	{
		UserAuthenticator ua = new UserAuthenticator();
		
		assertEquals(true, ua.login("Matt", "pass"));
		
		assertEquals("pass", ua.getActivePassword());
	}
	
	@Test
	public void logoutTest()
	{
		UserAuthenticator ua = new UserAuthenticator();
		
		assertEquals(true, ua.login("Matt", "pass"));
		
		ua.logout();
		
		assertEquals(null, ua.getActivePassword());
	}
	
}
