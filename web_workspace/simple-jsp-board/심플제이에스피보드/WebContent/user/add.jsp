<%@page import="kr.co.jhta.board.dao.UserDao"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="kr.co.jhta.board.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	
	User user = new User();
	user.setName(name);
	user.setId(id);
	user.setPwd(DigestUtils.sha256Hex(pwd));
	user.setEmail(email);
	
	UserDao userDao = new UserDao();
	User registeredUser = userDao.getUserById(id);
	if(registeredUser != null) {
		response.sendRedirect("form.jsp?fail=1");
		return;
	}
	
	userDao.addUser(user);
	response.sendRedirect("success.jsp");

%>
