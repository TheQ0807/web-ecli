<%@page import="kr.co.jhta.board.dao.BoardDao"%>
<%@page import="kr.co.jhta.board.vo.User"%>
<%@page import="kr.co.jhta.board.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 로그인 되지 않은 사용자가 접근했을 때 로그인후 되돌아갈 url 지정
pageContext.setAttribute("url", "/simple-jsp-board/index.jsp"); 
%>

<%@ include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");	

	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	
	User user = (User) session.getAttribute("loginUser");
	
	Board board = new Board();
	board.setTitle(title);
	board.setContents(contents);
	board.setWriter(user);
	
	BoardDao boardDao = new BoardDao();
	boardDao.addBoard(board);
	
	response.sendRedirect("/simple-jsp-board/board/index.jsp");
%>