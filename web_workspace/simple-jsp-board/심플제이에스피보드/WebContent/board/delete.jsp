<%@page import="kr.co.jhta.board.vo.Board"%>
<%@page import="kr.co.jhta.board.vo.User"%>
<%@page import="kr.co.jhta.board.dao.BoardDao"%>
<%@page import="kr.co.jhta.utils.IbatisUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% pageContext.setAttribute("url", "/simple-jsp=board/board/detail.jsp");%>
<%@ include file="../common/logincheck.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	

	BoardDao boardDao = new BoardDao();
	int no = Integer.parseInt(request.getParameter("no"));
	// 글 작성자와 로그인한 사용자가 동일한 사용자인지 체크
	Board board = boardDao.getBoardByNo(no);
	User loginUser = (User)session.getAttribute("loginUser");
	if(board.getWriter().getId().equals(loginUser.getId())) {
		boardDao.inactiveBoard(no);
	}
		
	response.sendRedirect("/simple-jsp-board/board/index.jsp");

%>