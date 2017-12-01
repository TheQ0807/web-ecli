package com.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;

public class RegisterController implements Controller{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		System.out.println(email+":"+pwd+"신규 회원정보 저장완료");
		
		return "redirect:home.do";
	}
}
