package com.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;

public class HomeController implements Controller{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("notice", "추석연휴기간 서비스를 하지 않겠다 저리가삼 훠이~");
		
		return "home.jsp";
	}

}
