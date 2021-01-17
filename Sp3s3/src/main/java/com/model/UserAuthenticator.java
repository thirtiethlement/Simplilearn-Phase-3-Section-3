package com.model;

import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class UserAuthenticator {
	
	public static List<User> validUserDatabase = new ArrayList<User>();
	
	private User currentUser;
	
	public boolean login(String username, String password)
	{
		for (int i = 0; i < validUserDatabase.size(); i++)
		{
			if ((validUserDatabase.get(i).getUsername() == username) && (validUserDatabase.get(i).getPassword() == password))
			{
				currentUser = validUserDatabase.get(i);
				return true;
			}
		}
		return false;					
	}
	
	public String getActiveUsername()
	{
		if (currentUser != null)
		{
			return currentUser.getUsername();
		}
		return null;
	}
	
	public String getActivePassword()
	{
		if (currentUser != null)
		{
			return currentUser.getPassword();
		}
		return null;
	}
	
	public void logout()
	{
		currentUser = null;
	}
}
