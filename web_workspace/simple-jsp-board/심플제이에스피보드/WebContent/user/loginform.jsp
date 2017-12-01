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
<% pageContext.setAttribute("cp", "l"); %>
<%@ include file="../common/navi.jsp" %>

<div class="container">
  <div class="row">
	 	<h1 class="well">로그인하기</h1>
	 	<%
	 		if(request.getParameter("fail") != null) {
	 	%>		
	 		<div class="alert alert-danger">
	 			<strong>오류</strong> 아이디 혹은 비밀번호가 올바르지 않습니다.
	 		</div>	
	 	<%	
	 		}
	 	%>
	 	<%
	 		if(request.getParameter("deny") != null) {
	 	%>		
	 		<div class="alert alert-danger">
	 			<strong>오류</strong> 로그인이 필요합니다.
	 		</div>	
	 	<%	
	 		}
	 	%>
	 	<%
	 		String returnUrl = request.getParameter("returnUrl");
	 	%>
		<div class="row">
		<form class="well" method="post" action="login.jsp">
		<%if (returnUrl != null) {%>
			<input type="hidden" name="returnUrl" value="<%=returnUrl%>">
		<%} %>
			<div class="form-group">
				<label>아이디</label>
				<input type="text" class="form-control" name="id" />
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" class="form-control" name="pwd" />
			</div>
			<div class="form-group">
				<button  class="btn btn-primary btn-sm">로그인</button>
			</div>
		</form>
	</div>
	</div>
</div>
</body>
</html>