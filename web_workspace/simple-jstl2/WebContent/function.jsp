<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<%
	String text = "한 권으로 끝내는 nodejs and express";
	request.setAttribute("text", text);
	
	String filename = "logo.mp4";
	request.setAttribute("filename", filename);
	
	String menus = "라면,떡볶이,우동,쫄면,비빔국수,군만두,김밥,볶음밥";
	request.setAttribute("menus", menus);
	
	String contents = "<button>버튼</button>";
	request.setAttribute("contents", contents);
	
	List<String> names = Arrays.asList("이순신","김유신","강감찬");
	request.setAttribute("names", names);
%>
	<h1>function 태그</h1>
	
	<p>길이 : ${fn:length(text) }</p>
	<p>잘라내기 : ${fn:substring(text, 0 ,10) }</p>
	
	<c:choose>
		<c:when test="${fn:length(text) gt 20 }">
			<p>${fn:substring(text, 0 ,17) }...</p>
		</c:when>
		<c:otherwise>
			<p>${text }</p>
		</c:otherwise>
	</c:choose>
	<p>대문자로 : ${fn:toUpperCase(text) }</p>
	<p>대문자로 : ${fn:toLowerCase(text) }</p>
	<p>바꾸기: ${fn:replace(text, "끝내는", "마스터하는") }</p>
	<p>포함여부: ${fn:contains(text, 'node') }</p>
	<p>포함여부: ${fn:contains(text, 'noDe') }</p>	<!-- 그냥 컨테인즈는 대소문자 구분을하여서 찾는데 밑의 이그노아케이스는 대소문자를 구분하지 않고 찾아준다. -->
	<p>포함여부: ${fn:containsIgnoreCase(text, 'noDe') }</p>
	<p>위치: ${fn:indexOf(text, '권' ) }</p>
	<p>시작하냐?: ${fn:startsWith(text, '한') }</p>
	<p>끝나냐?: ${fn:endsWith(text,'한') }</p>
	
	<c:choose>
		<c:when test="${fn:endsWith(filename,'png') }">
			<p><span class="glyphicon glyphicon-picture"></span></p>
		</c:when>
		<c:when test="${fn:endsWith(filename,'doc') }">
			<p><span class="glyphicon glyphicon-file"></span></p>
		</c:when>
		<c:when test="${fn:endsWith(filename,'mp4') }">
			<p><span class="glyphicon glyphicon-facetime-video"></span></p>
		</c:when>
	</c:choose>
	
	<ul>
	<c:forEach var="menu" items="${fn:split(menus,',') }">
		<li>${menu }</li>
	</c:forEach>
  	</ul>
  	
  	<p>${fn:join(fn:split(menus,','), '-') }</p>
  	
  	<p>${contents }</p>
  	<p>${fn:escapeXml(contents) }</p>
  	
  	<p>${fn:length(names) }</p>
</div>
</body>
</html>