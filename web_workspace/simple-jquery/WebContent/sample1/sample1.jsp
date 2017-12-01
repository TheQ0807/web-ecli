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
  <script type="text/javascript">
  $(function(){
	 
	  $("#dept-list").on("click","a",function(e){
		 e.preventDefault();
		 var departmentId = $(this).attr("href");
		 
		 $(this).parent().addClass("active").siblings().removeClass("active");
		 
		 $.ajax({
			type:"GET",
			url:"response2.jsp",
			data:{deptId:departmentId},
			dataType:"json",
			success:function(result){
				var html = "";
				$.each(result, function(index, item){
					html += "<tr>";
					html += "<td>"+item.id+"</td>";
					html += "<td>"+item.firstName+"</td>";
					html += "<td>"+item.lastName+"</td>";
					html += "<td>"+item.job+"</td>";
					html += "<td>"+item.salary+"</td>";
					html += "</tr>";
				});
				$("#employee-list tbody").html(html);
			}
		 });
		 
	  });
	  
	  $.ajax({
		  type:"GET",
		  url:"response1.jsp",
		  dataType:"json",
		  success:function(result){
			  if(result.resultCode == "S"){
				  var depts = result.data;
				  $.each(depts, function(index , item){
					  var $li = $("<li class='list-group-item'><a href='"+item.id+"'>"+item.name+"</a></li>");
					  $("#dept-list").append($li);
				  });
			  	  
			  }
		  },
		  error:function(){
			  
		  }
	  });
  });
  </script>
</head>
<body>

<div class="container">
	<h1>부서별 사원 조회</h1>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="panel panel-primary">
				<div class="panel-heading">부서 목록</div>
				<ul class="list-group" id="dept-list" ></ul>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="panel panel-info">
				<div class="panel-heading">사원 목록</div>
				<table class="table" id="employee-list">
					<tr>
						<th>id</th>
						<th>first name</th>
						<th>last name</th>
						<th>job</th>
						<th>salary</th>
					</tr>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>