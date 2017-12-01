<%@page import="vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	request.setAttribute("msg", "안녕하세요");
	request.setAttribute("contents", "<button>이 버튼을 누르면 프로그램이 폭발합니다.</button>");

	request.setAttribute("pass", "합격");
	
	request.setAttribute("score", 97);
	
	String[] books = {"자바책","html책","자바스크립트책", "스프링책"};
	request.setAttribute("books", books);
	
	List<Product> products = new ArrayList<>();
	products.add(new Product(100, "겔럭시노트 8", 1100000,"삼성전자"));
	products.add(new Product(100, "아이폰 8", 900000,"애플"));
	products.add(new Product(100, "아이폰 8 플러스",1000000,"애플"));
	products.add(new Product(100, "아이폰 X",1500000,"애플"));
	products.add(new Product(100, "애플워치3",1100000,"애플"));
	request.setAttribute("products", products);
	
%>
<div class="container">
	<h1>Core 태그 라이브러리</h1>
	
	<h3>out 태그</h3>
	<pre>
		값을 표현하는 태그
		
	</pre>
	<p>자바코드로 표현하기: 
		<%
			String text = (String) request.getAttribute("contents");
		%>
		<%= text %>
	</p>
	<p>EL로 표현하기: ${contents }</p>
	<p>JSTL로 표현하기: <c:out value="${contents}"/></p>
	
	
	
	<h3>if 태그</h3>
	<pre>
		java의 if문을 흉내내는 태그다.
		if 태그의 test속성값이 true인 경우 if태그의 내부 컨텐츠가 처리된다.
		else태그는 존재하지 않는다. 
	</pre>
	
	<c:if test="${not empty msg }">
		<p>test 속성의 연산결과가 true인 경우 표시된다.</p>
	</c:if>
	<c:if test="${pass eq '합격' }">
		<p>합격을 축하드립니다. 내일까지 400만원 납부하세요.</p>
	</c:if>
	<c:if test="${pass eq '불합격' }">
		<p>불합격입니다. 영원히 우리회사 지원자격을 박탈합니다.</p>
	</c:if>
	
	<h3>choose, when, otherwise 태그</h3>
	<pre>
		if ~ else 
		if ~ else if ~ else if
		if ~ else if ~ else if ~ else 를 흉내낼 수 있다.
	</pre>
	
	<c:choose>
		<c:when test="${score ge 70 }">
			<p>합격</p>
			<c:choose>
				<c:when test="${score ge 98 }">
					<p>전액장학금</p>
				</c:when>
				<c:when test="${score ge 95 }">
					<p>반액장학금</p>
				</c:when>
				<c:when test="${score ge 90 }">
					<p>기성회비 면제</p>
				</c:when>
				<c:otherwise>
					<p>장학금 없음</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>불합격</p>
		</c:otherwise>
	</c:choose>
	
	<h3>forEach 태그</h3>
	<pre>
		반복작업을 수행한다.
	</pre>
	
	<c:forEach var="x" items="${books}">
		<p>${x}</p>
	</c:forEach>
	
	<table  class="table">
		<thead>
			<tr>
				<th>제품번호</th>
				<th>제품명</th>
				<th>가격</th>
				<th>제조사</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="p" items="${products }" varStatus="x">
			<tr class="${p.price > 1000000 ? 'info': '' }">
				<td>${x.count}</td>
				<td>${p.no }</td>
				<td>${p.name }</td>
				<td>${p.price }</td>
				<td>${p.maker }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<ul class="pagination">
		<c:forEach var="n" begin="1" end="10" varStatus="x">
			<c:choose>
				<c:when test="${x.first || x.last }">
					<li class="disabled"><a href="">${n }</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="">${n }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	
	<h3>set, remove 태그</h3>
	<pre>
		변수의 선언/삭제를 흉내낸다.
	</pre>
	<c:set var="hobbys" value="게임,영화,운동,독서" />
		<p>${hobbys }</p>
	<%-- <c:remove var="hobbys"/>
	<p>${hobbys} </p> --%>
	
	<h3>forTokens 태그</h3>
	<c:forTokens var="h" items="${hobbys }" delims=",">
		<p><input type="checkbox">${h }</p>
	</c:forTokens>
	
</div>
</body>
</html>