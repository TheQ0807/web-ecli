<%@page import="kr.co.jhta.board.vo.Board"%>
<%@page import="kr.co.jhta.board.dao.BoardDao"%>
<%@page import="kr.co.jhta.board.vo.Likes"%>
<%@page import="kr.co.jhta.board.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("url", "/simple-jsp-board/board/index.jsp");
%>
<%@ include file="../common/logincheck.jsp" %>
<%
	int no = Integer.parseInt(request.getParameter("no"));

	User loginUser = (User) session.getAttribute("loginUser");
	
	Likes likes = new Likes();
	
	likes.setUserId(loginUser.getId());
	likes.setBoardNo(no);
		
	BoardDao boardDao = new BoardDao();
	
	Board board = boardDao.getBoardByNo(no);
	if(board.getWriter().getId().equals(loginUser.getId())) {
		response.sendRedirect("detail.jsp?no="+no);
		return;
	}
	
	int likesCount = boardDao.getLikes(likes);
	if(likesCount > 0){
		response.sendRedirect("detail.jsp?no="+no);
		return;
	}
	
	boardDao.addLikes(likes);
	response.sendRedirect("detail.jsp?no="+no);
	
%>