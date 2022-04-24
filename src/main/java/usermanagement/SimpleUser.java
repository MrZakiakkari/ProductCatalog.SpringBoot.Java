/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package usermanagement;

public class SimpleUser
{
	public SimpleUser()
	{
	}
	public SimpleUser(String username, String password)
	{
		this.password = password;
		this.username = username;
	}
	public SimpleUser(String username, String password, String roles)
	{
		this.password = password;
		this.roles = roles;
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRoles()
	{
		return roles;
	}
	public void setRole(String roles)
	{
		this.roles = roles;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public boolean matches(String username, String password)
	{
		return getUsername().equalsIgnoreCase(username) && getPassword().equalsIgnoreCase(password);
	}

	private String password;
	private String roles;

	private String username;
}
