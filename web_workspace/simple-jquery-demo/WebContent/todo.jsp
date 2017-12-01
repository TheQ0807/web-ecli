<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style type="text/css">
  	.del {}
  	.done {}
  	.save {}
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(function(){

  		
  		function reset(){
  		var htmlContents = "";
  		$.ajax({
  			type:"GET",
  			url:"response-list.jsp",
  			dataType:"json",
  			success:function(result){
				$.each(result, function(index, item){
						htmlContents += "<tr>";
						htmlContents += "<td>"+item.no+"</td>"
						htmlContents += "<td>"+item.title+"</td>"
						htmlContents += "<td>"+item.dates+"</td>"
						htmlContents += "<td>"+item.completed+"</td>"
						htmlContents += "<td>";
						if(item.completed == "아니오"){
							htmlContents += "<button class='btn btn-success btn-xs' id='btn-"+item.no+"'>처리</button>";
						}else{
							htmlContents += "<button class='btn btn-danger btn-xs' id='btn-"+item.no+"'>삭제</button>";
						}
						htmlContents += "</td>";
						htmlContents += "</tr>";
					})
					$("table tbody").html(htmlContents);
				}
	  		})
  		}
  		
  		
  		$("#btn-add-todo").on("click", function(e){
  			e.preventDefault();
  			
  			var tit = $(":input[name=title]").val();
  			var date = $(":input[name=dates]").val();
  			var con = $(":input[name=contents]").val();
  			  			
  			$.ajax({
				type:"post",
				url: "response-add.jsp",
				data:{title:tit, dates:date, contents:con},
				dataType:"json",
				success:function(result){
					console.log(result);
					var html = "";
					html += "<tr>";
					html += "<td>"+result.no+"</td>";
					html += "<td>"+result.title+"</td>";
					html += "<td>"+result.dates+"</td>";
					html += "<td>"+result.completed+"</td>";
					html += "<td>";
					if(result.completed == "아니오"){
						html += "<button class='btn btn-success btn-xs' id='btn-"+result.no+"'>처리</button>";
					}else {
						html += "<button class='btn btn-danger btn-xs' id='btn-"+result.no+"'>삭제</button>";
					}
						
					html += "</td>"
					html += "</tr>"
					
					$("table tbody").before(html);
					$(":input[name=title]").val("");
		  			$(":input[name=dates]").val("");
		  			$(":input[name=contents]").val("");
				}
			    })
			})
			
			$("table").on("click", "button.btn-success",function(e){
				e.preventDefault();
				var number = $(this).parents("tr").find("td:eq(0)").text();
				
				$.ajax({
					type:"POST",
					url:"response-com.jsp",
					data:{no:number},
					dataType:"json",
					success:reset
				})
			})
				
			$("table").on("click", "button.btn-danger",function(e){
				e.preventDefault();
				var number = $(this).parents("tr").find("td:eq(0)").text();
				
				$.ajax({
					type:"POST",
					url:"response-del.jsp",
					data:{no:number},
					dataType:"json",
					success:reset
					
				})
				})
				reset();
  	})
  </script>
</head>
<body>

<div class="container">
	<h1>Todo List</h1>
	
	<form class="well form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2">제목</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="title"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">날짜</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="dates"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">내용</label>
			<div class="col-sm-9">
				<textarea rows="3" class="form-control" name="contents"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-9 col-sm-offset-2 text-right">
				<button class="btn btn-default btn-md" id="btn-add-todo">등록</button>
			</div>
		</div>
	</form>
	
	<table class="table table-condensed">
		<thead>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>날짜</th>
				<th>완료여부</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<!-- Ajax 결과를 화면에 표시할때 아래와 같은 모양이 되게 html을 만드세요.  -->
			<!-- <tr>
				<td>1</td>
				<td><a href="1">마트 장보기</a></td>
				<td>9.30</td>
				<td>아니오</td>
				<td>
					todo-completed값이 "아니오"이면 처리버튼 활성화 "예"이면 삭제버튼 활성화
					<button class="btn btn-success btn-xs" id="btn-todo-com">처리</button>
					<button class="btn btn-danger btn-xs" id="btn-todo-del">삭제</button>
				</td>
			</tr> -->
		</tbody>
	</table>
</div>
</body>
</html>