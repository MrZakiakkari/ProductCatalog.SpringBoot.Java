/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package support.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationSupport
{
	public static String getPrincipalUsername()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal == null)
		{
			return "";
		}
		else if (principal instanceof UserDetails userDetails)
		{
			return userDetails.getUsername();
		}
		else
		{
			return principal.toString();
		}
	}
}
