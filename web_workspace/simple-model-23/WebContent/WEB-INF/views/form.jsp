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

<div class="container">
  <h1>회원가입폼</h1>
  
  <form method="post" action="register.do">
	<div class="form-group">
		<label>이메일</label>
		<input type="text" class="form.control" name="email">
	</div>  
	<div class="form-group">
		<label>비밀번호</label>
		<input type="text" class="form.control" name="pwd">
	</div>  
	<button type="submit" class="btn btn-primary">가입</button>
  </form>
</div>
</body>
</html>