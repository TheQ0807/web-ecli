package com.hta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;

public class HomeController implements Controller{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// main.jsp에 표시할 데이터를  조회/가공 한다. <--- home.do 요청을 처리한다.
		System.out.println("HomeController process() 실행중...");
		
		// 뷰템플릿에 데이터 전달하기
		request.setAttribute("message", "메인페이지 방문을 환영합니다.");
	}
}
