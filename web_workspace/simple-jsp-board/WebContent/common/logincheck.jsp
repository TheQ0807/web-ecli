<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	if(session.getAttribute("loginUser") == null) {
		//로그인 완료 후 되돌아갈 url가져오기
		String url = (String) pageContext.getAttribute("url");
		String path = "/simple-jsp-board/user/loginform.jsp?deny=1&returnUrl="+url;
		response.sendRedirect(path);
		
		return;
	}
%>