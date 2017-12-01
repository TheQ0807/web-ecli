package com.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;

public class RegisterFormController implements Controller {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return "form.jsp";
	}
	
}
