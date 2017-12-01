<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div class="container">
	<h1><fmt:message key="label.list.title"/></h1>
	
	<table class="table">
		<thead>
			<tr>
				<th><fmt:message key="label.no"/></th>
				<th><fmt:message key="label.title"/></th>
				<th><fmt:message key="label.writer"/></th>
				<th><fmt:message key="label.createdate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boards }">
				<tr>
					<td>${board.no }</td>
					<td><a href="detail.do?no=${board.no }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.createdate }"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="row text-right">
		<a href="form.do" class="btn btn-primary btn-sm"><fmt:message key="label.button.form"/></a>
	</div>
</div>
</fmt:bundle>
</body>
</html>