<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${not empty param.lang }">
	<fmt:setLocale value="${param.lang }" scope="session"/>
</c:if>
<fmt:bundle basename="kr.co.jhta.i18n.message">
<div class="container">
	<h1><fmt:message key="home.title"/></h1>  
	<button><fmt:message key="btn.label.login" /></button>
	
	<p>
		<a href="i18n.jsp?lang=ko">Korea</a>
		<a href="i18n.jsp?lang=ja">Japan</a>
	</p>	
</div>
</fmt:bundle>
</body>
</html>