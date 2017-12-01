<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>구구단</h1>
	
	<%
		for(int i =1; i<9; i++){
	%>
		<p>2*<%=i %>=<%=i*2 %> </p>
	<% 
		}
	%>
</body>
</html>