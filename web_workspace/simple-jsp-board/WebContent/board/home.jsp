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
<% pageContext.setAttribute("cp", "bb"); %>
<% pageContext.setAttribute("url", "/simple-jsp=board/board/form.jsp");%>
<%@ include file="../common/navi.jsp" %>
<%@ include file="../common/logincheck.jsp"%>
<div class="container">
	<div class="row">
		<h1 class="well">글 쓰기</h1>
	</div>
	<div class="row">
		<form class="well" method="post" action="add.jsp">
			<div class="form-group">
				<label>제목</label>
				<input type="text" class="form-control" name="title">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea rows="10" class="form-control" name="contents"></textarea>				
			</div>
			<div class="form-group text-right">
				<a href="index.jsp" class="btn btn-default btn-sm">취소</a>
				<button type="sumit" class="btn btn-primary btn-sm">저장</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>