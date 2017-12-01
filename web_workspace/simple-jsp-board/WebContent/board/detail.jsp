<%@page import="kr.co.jhta.utils.DateUtils"%>
<%@page import="kr.co.jhta.board.vo.Comment"%>
<%@page import="kr.co.jhta.board.vo.Likes"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jhta.board.vo.Board"%>
<%@page import="kr.co.jhta.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
	pageContext.setAttribute("cp", "bb");
%>
<% pageContext.setAttribute("url", "/simple-jsp=board/board/form.jsp");%>
<%@ include file="../common/navi.jsp" %>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao boardDao = new BoardDao();
		//글 정보
	Board board = boardDao.getBoardByNo(no);
	Likes likes = new Likes();
	//댓글 정보
	List<Comment> commentList = boardDao.getCommentsByBoardNo(no);
	
%>
<div class="container">
 	<div class="container">
	<div class="row">
	 	<h1 class="well text-center">글 내용</h1>
		<div class="panel panel-default">
			<table class="table table-condensed table-hover">
				<thead >
				<% 
					
					
						if(board.getNo() == Integer.parseInt(request.getParameter("no"))) {
				%>
					<tr>
						<td>제목</td><td><%=board.getTitle() %></td>
					</tr>
					<tr>
						<td>글쓴이</td><td><%=board.getWriter().getName() %></td>
						<td>추천수</td><td><%=board.getLikes()%></td>
					</tr>
				<% 
						}
					
				%>
				<%
	
					
					
						if(board.getNo() == Integer.parseInt(request.getParameter("no"))) {
				%>
					<tr>
						<td>내용</td><td><%=board.getContentsWithBr() %></td>
					</tr>	
				<%		
						}
					
				%>
				</thead>
				<tbody>
				
				
				<tr>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	</div>
			<div class="panel-footer">
				<a href="index.jsp"><button class="btn btn-primary btn-sm text-right">글목록</button></a>	
				<%
					if(loginUser != null){
						String loginUserId = loginUser.getId();
						if(loginUserId.equals(board.getWriter().getId())){
				%>							
            	<a href="delete.jsp?no=<%=Integer.parseInt(request.getParameter("no"))%>" class="btn btn-danger btn-sm text-left">삭제</a>
				<%
						}else{
				%>
				<a href="likes.jsp?no=<%=board.getNo()%>" class="btn btn-success btn-sm text-left">추천</a>
				<%			
						}
					}
				%>
			</div>
			<div class="row">
				<form class="form-horizontal" method="post" action="addComment.jsp">
					<input type="hidden" name="no" value = "<%=board.getNo() %>">
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-9">
							<textarea rows="2" class="form-control" name="contents"></textarea>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-default">등록</button>
						</div>
					</div>
				</form>
			</div>
			<div class="row">
				<div class="col-sm-offset-1 col-sm-10">
				<ul class="list-group">
				<%
					for (Comment comment : commentList){		
				%>
					<li class="list-group-item">
						<p class="list-group-item-text"><%=comment.getContents() %></p>
						<p class="list-group-item-text text-right">
							<small><%=DateUtils.yyyymmddhhmmss(comment.getCreatedate()) %></small>
							<span class="label label-default"><%=comment.getWriter().getName() %></span>
						</p>
						</li>
				<% 
					}
				%>
			
				</ul>
			</div>
	</div>
	</div>
</body>
</html>