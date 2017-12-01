<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="http://www.jhta.co.kr/tags/mytag" %>
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
  <my:hello message="반갑습니다."/>
  <my:hello message="안녕하세요."/>
  <my:hello message="어서오세요."/>
  <my:hello message="환영합니다."/>
  <my:hello message="이제가세요."/>
  <my:hello message="잘가세요."/>
  
  <my:numberToStr number="10000000" pattern="#,###"/>
</div>
</body>
</html>