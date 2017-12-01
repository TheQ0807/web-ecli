<%@page import="java.util.Random"%>
<%@page import="demo2.Book"%>
<%@page import="java.util.List"%>
<%@page import="demo2.BookDao"%>
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
 	 <%
 	 	String[] labels = {"default","primary","success","info","warning","danger"};
  		BookDao bookDao = new BookDao();
  		List<Book> books = bookDao.getAllBook();
 	 %>
 	 <h3 class="well">현재 판매중인 책들</h3>
 	 <p>
 	 	<%
 	 	Random random = new Random();
 	 	for(Book book : books) {
			 int number = random.nextInt(6);
 	 	%>
			<span class="label label-<%=labels[number]%>"style="cursor:pointer;" id="book-no-<%=book.getNo() %>"><%=book.getTitle() %></span>
 	 	<%
 	 	}
 	 	%>
 	 </p>
 	 <div class="panel panel-info">
 	 	<div class="panel-heading" id="book-title"></div>
 	 	<table class="table table-bordered">
 	 	<colgroup>
 	 		<col width="10%">
 	 		<col width="30%">
 	 		<col width="10%">
 	 		<col width="50%">
 	 	</colgroup>
 	 		<tbody>
 	 			<tr>
 	 				<th>번호</th><td id="book-no"></td>
 	 				<th>제목</th><td id="book-title-2"></td>
 	 			</tr>
 	 			<tr>
 	 				<th>저자</th><td id="book-author"></td>
 	 				<th>출판사</th><td id="book-publisher"></td>
 	 			</tr>
 	 			<tr>
 	 				<th>가격</th><td id="book-price"></td>
 	 				<th>할인여부</th><td id="book-discount"></td>
 	 			</tr>
 	 			<tr>
 	 				<th>설명</th><td colspan="3" id="book-info"></td>
 	 			</tr>
 	 		</tbody>
 	 	</table>
 	 </div>
</div>
</body>
<script type="text/javascript">
	var spanNodeList = document.getElementsByTagName("span");
	
	for(var index=0; index<spanNodeList.length; index++) {
		var span = spanNodeList.item(index);
		
		span.addEventListener("click", function(event){
			var bookNo = event.target.id.replace("book-no-", "");
			
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200) {
					var jsonText = xhr.responseText;
					var book = JSON.parse(jsonText);
					
					document.getElementById("book-title").textContent = book.title;
					document.getElementById("book-no").textContent = book.no;
					document.getElementById("book-title-2").textContent = book.title;
					document.getElementById("book-author").textContent = book.author;
					document.getElementById("book-publisher").textContent = book.publisher;
					document.getElementById("book-price").textContent = book.price;
					document.getElementById("book-discount").textContent = book.discount;
					document.getElementById("book-info").textContent = book.bookinfo;
				}
			};
			xhr.open("GET","book.do?bno="+ bookNo);
			xhr.send(null);
		});
	}
</script>
</html>