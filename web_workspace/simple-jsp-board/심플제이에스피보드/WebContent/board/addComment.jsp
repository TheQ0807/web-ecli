<%@page import="kr.co.jhta.board.dao.BoardDao"%>
<%@page import="kr.co.jhta.board.vo.Comment"%>
<%@page import="kr.co.jhta.board.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	pageContext.setAttribute("url", "/simple-jsp-board/board/index.jsp");
 %>
<%@ include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	int boardNo = Integer.parseInt(request.getParameter("no"));
	String contents = request.getParameter("contents");
	
	User loginUser = (User) session.getAttribute("loginUser");
	BoardDao boardDao = new BoardDao();
	
	Comment comment = new Comment();
	comment.setContents(contents);
	comment.setWriter(loginUser);
	comment.setBoard(boardDao.getBoardByNo(boardNo));
	
	boardDao.addComment(comment);
	
	response.sendRedirect("detail.jsp?no="+boardNo);
%>