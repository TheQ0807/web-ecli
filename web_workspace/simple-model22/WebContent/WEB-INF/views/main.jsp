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
  	<h1>Main Page</h1>
  	<p>${message}</p>
  	
  	<h3>문의하기</h3>
  	<p><a href="about.do?type=job">채용 문의하기</a></p>
  	<p><a href="about.do?type=project">프로젝트 문의하기</a></p>
  	<p><a href="about.do?type=etc">기타 문의하기</a></p>
</div>
</body>
</html>