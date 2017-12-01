<%@page import="kr.co.jhta.board.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String cp = (String)pageContext.getAttribute("cp");
    	
    	User loginUser =(User) session.getAttribute("loginUser");
    %>
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/simple-jsp-board/index.jsp">중앙HTA</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="<%="h".equals(cp)?"active":""%>"><a href="/simple-jsp-board/index.jsp">홈</a></li>
      <li><a href="#">정규과정</a></li>
      <li><a href="#">단기과정</a></li>
      <li class="<%="bb".equals(cp)?"active":""%>"><a href="/simple-jsp-board/board/index.jsp">자유게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <% if(loginUser == null) {%>
      <li class="<%="u".equals(cp)?"active":""%>"><a href="/simple-jsp-board/user/form.jsp">회원가입</a></li>
      <li class="<%="l".equals(cp)?"active":""%>"><a href="/simple-jsp-board/user/loginform.jsp">로그인</a></li>
      <%} else{ %>
      <li><a href="/simple-jsp-board/user/logout.jsp">로그아웃</a></li>
      <%} %>
    </ul>
    <%
    	if(loginUser != null) { %>
    	<p class="navbar-text navbar-right"><strong><%=loginUser.getName() %></strong>님 환영합니다.</p>	
	<% } %>
  </div>
</nav>