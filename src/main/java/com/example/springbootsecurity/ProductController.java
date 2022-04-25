/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.example.springbootsecurity;

import com.example.springbootsecurity.meta.SitePaths;
import com.example.springbootsecurity.meta.ViewPageNames;
import java.util.NoSuchElementException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import support.web.PathSupport;

@Controller
public class ProductController
{
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
	@GetMapping(SitePaths.PRODUCT_EDIT + "/{code}")
	public ModelAndView getProductEditPage(@PathVariable String code) throws NoSuchElementException
	{

		Product product = productService.getProductByCode(code);
		if (product == null)
		{
			throw new NoSuchElementException(String.format("No product matches code '%s'", code));
		}
		ModelAndView modelAndView = new ModelAndView(ViewPageNames.PRODUCT_ADD);
		modelAndView.addObject("product", product);
		return modelAndView;

	}
	@GetMapping(SitePaths.HANDLE_PRODUCT_DELETE + "/{code}")
	public String handleDeleteProduct(@PathVariable String code) throws NoSuchElementException
	{
		Product product = productService.getProductByCode(code);
		if (product == null)
		{
			throw new NoSuchElementException(String.format("No product matches code '%s'", code));
		}

		productService.deleteProductByCode(code);
		return PathSupport.redirect(SitePaths.PRODUCTS);
	}
	@PostMapping(SitePaths.PRODUCT_ADD)
	public ModelAndView handleAddProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult) throws BindException
	{
		if (bindingResult.hasErrors())
		{
			throw new BindException(bindingResult);
		}
		else
		{
			boolean insertedProduct = productService.addProduct(product);
			if (insertedProduct)
			{
				return new ModelAndView(PathSupport.redirect(SitePaths.PRODUCTS));
			}
			else
			{
				return new ModelAndView(ViewPageNames.ERROR_PAGE);
			}
		}
	}
	@PostMapping(SitePaths.PRODUCT_EDIT + "/{code}")
	public ModelAndView handleEditProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult) throws BindException
	{
		if (bindingResult.hasErrors())
		{
			throw new BindException(bindingResult);
		}
		else
		{
			productService.updateProduct(product);
			return new ModelAndView(PathSupport.redirect(SitePaths.PRODUCTS));
		}
	}
	//
	//	Private Fields
	//
	@Autowired
	private ProductService productService;
}
