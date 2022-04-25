/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.example.springbootsecurity;

import com.example.springbootsecurity.meta.ViewPageNames;
import com.example.springbootsecurity.meta.SitePaths;
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
	@RequestMapping(SitePaths.ROOT)
	public String getHomePage()
	{
		return PathSupport.redirect(SitePaths.TEST);
	}
	@GetMapping(SitePaths.PRODUCTS)
	public ModelAndView getProductsPage()
	{
		ModelAndView modelAndView = new ModelAndView("allProducts");
		modelAndView.addObject("productList", productService.getProducts());
		return modelAndView;
	}
	@GetMapping(SitePaths.PRODUCT_ADD)
	public ModelAndView getProductAddPage(HttpServletRequest request, HttpSession session)
	{
		ModelAndView modelAndView = new ModelAndView(ViewPageNames.PRODUCT_ADD);
		modelAndView.addObject("product", new Product());
		return modelAndView;
	}
	@RequestMapping(SitePaths.TEST)
	public String getTestPage()
	{
		return ViewPageNames.TEST;
	}

	@Autowired
	private ProductService productService;
}
