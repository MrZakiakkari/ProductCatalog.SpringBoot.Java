/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.example.springbootsecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import support.web.PathSupport;

@Controller
public class WebPageController
{
	@RequestMapping(SitePaths.Root)
	public String getHomePage()
	{
		return PathSupport.redirect(SitePaths.Test);
	}
	@GetMapping(SitePaths.Products)
	public ModelAndView getProductsPage()
	{
		ModelAndView modelAndView = new ModelAndView(ViewPageNames.Products);
		modelAndView.addObject("productList", productService.getProducts());
		return modelAndView;
	}
	@GetMapping(SitePaths.ProductAdd)
	public ModelAndView getProductAddPage(HttpServletRequest request, HttpSession session)
	{
		ModelAndView modelAndView = new ModelAndView(ViewPageNames.ProductAdd);
		modelAndView.addObject("product", new Product());
		return modelAndView;
	}
	@RequestMapping(SitePaths.Test)
	public String getTestPage()
	{
		return ViewPageNames.Test;
	}
	//
	//	Private Fields
	//
	@Autowired
	private ProductService productService;
}