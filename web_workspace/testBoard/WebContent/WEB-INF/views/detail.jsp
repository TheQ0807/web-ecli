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
	<h1><fmt:message key="label.contents" /></h1>
	
	<table class="table">
		<tbody>
			<tr>
				<th><fmt:message key="label.no" /></th>
				<td>${boardByNo.no }</td>
				<th><fmt:message key="label.createdate" /></th>
				<td><fmt:formatDate value="${boardByNo.createdate }" pattern="yyyy.MM.dd HH:mm:ss"/></td>
			</tr>
			<tr>
				<th><fmt:message key="label.title" /></th>
				<td colspan="3"><c:out value="${boardByNo.title }" /></td>
			</tr>
			<tr>
				<th><fmt:message key="label.contents" /></th>
				<td colspan="3"><textarea rows="10" class="form-control" readonly="readonly"><c:out value="${boardByNo.contents }"/></textarea></td>
			</tr>
		</tbody>
	</table>
	<hr/> <!-- 수평라인이 하나 생기게하는 태그-->
	<div class="row text-right">
		<a href="form.do?pno=${boardByNo.pno }" class="btn btn-primary btn-sm">답글</a>
		<a href="del.do?no=${boardByNo.no }" class="btn btn-primary btn-sm">삭제</a>
		<a href="list.do" class="btn btn-primary btn-sm"><fmt:message key="label.list.title"/></a>
	</div>
</div>
</fmt:bundle>
</body>
</html>