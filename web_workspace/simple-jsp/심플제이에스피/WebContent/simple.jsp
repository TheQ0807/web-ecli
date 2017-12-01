<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		private String directory = "c:/temp";	
	
		public String getstringDate(Date date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
			
		}
	%>
	<%--
	<%
		// 자바코딩 영역이 된다.
		int x = 10;
		int y = 20;
		
		int z = 30;
		
		Date today = new Date();
	
	%>
	<p>x의값:<%=x %></p>
	<p>y의값: <%=y %></p>
	<p>z의값:<%=z %></p>
	<p>현재 시간: <%= getstringDate(today)%></p>
	--%>
	<%
		// 자바코딩 영역이 된다.
		int x = 10;
		int y = 20;
		
		int z = 30;
		
		Date today = new Date();
	
	%>
	<p>x의값:<%=x %></p>
	<p>y의값: <%=y %></p>
	<p>z의값:<%=z %></p>
	<p>현재 시간: <%= getstringDate(today)%></p>
	
</body>
</html>