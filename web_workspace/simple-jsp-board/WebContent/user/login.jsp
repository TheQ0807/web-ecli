<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="kr.co.jhta.board.dao.UserDao"%>
<%@page import="kr.co.jhta.board.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");


	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String returnUrl = request.getParameter("returnUrl");
	
	UserDao userDao = new UserDao();
	User registeredUser = userDao.getUserById(id);
	
	if(registeredUser == null) {
		response.sendRedirect("loginform.jsp?fail=1");
		return;
	}
	
	if(! registeredUser.getPwd().equals(DigestUtils.sha256Hex(pwd))){
		response.sendRedirect("loginform.jsp?fail=1");
		return;
	}
	// 로그인처리
	session.setAttribute("loginUser", registeredUser);
	if(returnUrl == null) {	
		response.sendRedirect("/simple-jsp-board/index.jsp");
	}else {
		response.sendRedirect(returnUrl);
	}
%>