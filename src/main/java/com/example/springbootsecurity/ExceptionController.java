/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.example.springbootsecurity;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController
{
	/**
	 *
	 * @param requst
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest requst, Exception exception)
	{
		ModelAndView modelAndView = new ModelAndView(ViewPageNames.ErrorPage);
		modelAndView.addObject("exception", exception);
		modelAndView.addObject("url", requst.getRequestURL());
		return modelAndView;
	}
}
