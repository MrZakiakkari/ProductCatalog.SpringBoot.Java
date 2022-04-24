/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.example.springbootsecurity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import usermanagement.SimpleRoles;
import usermanagement.SimpleUser;

@Service
public class SimpleUserService
{
	public boolean addSimpleUser(SimpleUser simpleUser)
	{
		return simpleUserList.add(simpleUser);
	}
	public void deleteSimpleUserByUsername(String username)
	{
		Iterator<SimpleUser> iterator = simpleUserList.iterator();
		while (iterator.hasNext())
		{
			SimpleUser simpleUser = iterator.next();
			if (simpleUser.getUsername().equalsIgnoreCase(username))
			{
				iterator.remove();
				break;
			}
		}
	}
	public List<SimpleUser> getSimpleUsers()
	{
		return simpleUserList;
	}
	public SimpleUser getSimpleUserByCredentials(String username, String password)
	{
		Iterator<SimpleUser> iterator = simpleUserList.iterator();
		while (iterator.hasNext())
		{
			SimpleUser simpleUser = iterator.next();
			if (simpleUser.matches(username, password))
			{
				return simpleUser;
			}
		}
		return null;
	}
	//
	//	Private Fields
	//
	private static final List<SimpleUser> simpleUserList = new ArrayList<>();
	private static final String DEFAULT_PASSWORD = "pass";

	static
	{
		simpleUserList.add(new SimpleUser("bob", DEFAULT_PASSWORD, SimpleRoles.SUPER_ADMIN));
		simpleUserList.add(new SimpleUser("tom", DEFAULT_PASSWORD, SimpleRoles.ADMIN));
		simpleUserList.add(new SimpleUser("mary", DEFAULT_PASSWORD, SimpleRoles.USER));
	}
}
