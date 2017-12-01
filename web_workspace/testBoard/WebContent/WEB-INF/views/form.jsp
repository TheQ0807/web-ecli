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
<fmt:bundle basename="i18n.messages">
<c:choose>
	<c:when test="${empty param.pno}">
		<c:set var="path" value="add.do"/>
	</c:when>
	<c:otherwise>
		<c:set var="path" value="reply.do"/>
	</c:otherwise>
</c:choose>
<div class="container">
	<h1>새 글</h1>
	<form class="well" method="post" action="${path}">
		<c:if test="${not empty param.pno}">
			<input type="hidden" name="pno" value="${param.pno}" />
		</c:if>
		<div class="form-group">
			<label><fmt:message key="label.title" /></label>
			<input type="text" class="form-control" name="title" placeholder="<fmt:message key="msg.title" />"/>
		</div>
		<div class="form-group">
			<label><fmt:message key="label.writer" /></label>
			<input type="text" class="form-control" name="writer" placeholder="<fmt:message key="msg.writer" />"/>
		</div>
		<div class="form-group">
			<label><fmt:message key="label.contents" /></label>
			<textarea rows="10" class="form-control" name="contents" placeholder="<fmt:message key="msg.contents" />"></textarea>
		</div>
		<button type="submit" class="btn btn-primary btn-sm"><fmt:message key="label.button.save" /></button>
		<a href="list.do" class="btn btn-info btn-sm"><fmt:message key="label.list.title"/></a>
	</form>
</div>
</fmt:bundle>
</body>
</html>