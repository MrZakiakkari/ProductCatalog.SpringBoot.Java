/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.example.springbootsecurity;

import com.example.springbootsecurity.meta.SitePaths;
import com.example.springbootsecurity.meta.ViewPageNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import support.web.PathSupport;

@Controller
public class WebPageController
{
	@RequestMapping(SitePaths.ROOT)
	public String getHomePage()
	{
		return PathSupport.redirect(SitePaths.TEST);
	}

	@RequestMapping(SitePaths.TEST)
	public String getTestPage()
	{
		return ViewPageNames.TEST;
	}

	@Autowired
	private ProductService productService;
}
