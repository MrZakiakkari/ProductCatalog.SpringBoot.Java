/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package usermanagement;

public class SimpleRoles
{
	public static final String ADMIN = "Admin";
	public static final String SUPER_ADMIN = "SuperAdmin";
	public static final String USER = "User";

	public static final String getAllRoles()
	{
		return ADMIN + "," + SUPER_ADMIN + "," + USER;
	}
	public static final String getDeleteRoles()
	{
		return ADMIN + "," + SUPER_ADMIN;
	}
}
