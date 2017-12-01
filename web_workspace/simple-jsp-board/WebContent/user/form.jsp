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
<% pageContext.setAttribute("cp", "u"); %>
<%@ include file="../common/navi.jsp" %>

<div class="container">
  <div class="row">
	 	<h1 class="well">회원 가입하기</h1>
	 	<%
	 		final String FAIL_CODE_DUP_ID = "1";
	 		final String FAIL_CODE_SHORT_PWD ="2";
	 	
	 		String failCode = request.getParameter("fail");
	 	%>
	 	<%if(FAIL_CODE_DUP_ID.equals(failCode)) { %>
	 		<div class="alert alert-danger">
	 			<strong>오류</strong> 이미 사용중인 아이디 입니다.
	 		</div>
	 	
	 	<%} %>
	 	<%if(FAIL_CODE_SHORT_PWD.equals(failCode)) { %>
	 		<div class="alert alert-danger">
	 			<strong>오류</strong> 비밀번호는 8글자 이상 입력하시기 바랍니다.
	 		</div>
	 	
	 	<%} %>
		<div class="row">
		<form class="well" method="post" action="add.jsp">
			<div class="form-group">
				<label>이름</label>
				<input type="text" class="form-control" name="name" />
			</div>
			<div class="form-group">
				<label>아이디</label>
				<input type="text" class="form-control" name="id" />
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" class="form-control" name="pwd" />
			</div>
			<div class="form-group">
				<label>이메일</label>
				<input type="text" class="form-control" name="email" />
			</div>
			<div class="form-group">
				<button class="btn btn-primary btn-sm">가입</button>
			</div>
		</form>
	</div>
	</div>
</div>
</body>
</html>