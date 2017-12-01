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
	<div class="row">
		<h3>박스오피스 조회</h3>
	</div>
		<div class="row">
			<form class="form-horizontal well">
				<div class="form-group">
					<label class="control-label col-sm-2">조회날짜</label>
				<div class="col-sm-9">
					<input type="date" class="form-control" name="searchdate" id="search-date" />
				</div>
				<div class="col-sm-1">
					<button type="submit" class="btn btn-default" id="btn-search">조회</button>
				</div>	
				</div>
			</form>
		</div>
		<div class="row">
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>순위</th>
						<th>제목</th>
						<th>개봉일</th>
						<th class="text-right">관객수</th>
						<th class="text-right">누적매출액</th>
						<th class="text-right">누적관객수</th>
						<th class="text-right">스크린수</th>
					</tr>
				</thead>
				<tbody id="boxoffice-body"></tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	document.getElementById("btn-search").addEventListener("click", function(event) {
		event.preventDefault();	// form안에 잇는 버튼은 자동으로 form의 입력값을 제출하기 때문에 페이지 이동이 발생하게 되는데 이를 방해한다.
		
		var searchDate = document.getElementById("search-date").value;
		searchDate = searchDate.replace(/-/g,'');
		
		var xhr = new XMLHttpRequest();
		xhr.open("GET",'boxoffice.do?date='+searchDate);
		xhr.send(null);
		xhr.onreadystatechange = function(){
			if(xhr.readyState ==4 && xhr.status == 200 ) {
				var xmlDoc = xhr.responseXML;
				
				
				var htmlContent = "";
				var boxofficeNodeList = xmlDoc.getElementsByTagName("dailyBoxOffice");
				
				for(var i=0; i<boxofficeNodeList.length; i++) {
					var boxoffice = boxofficeNodeList.item(i);
					
					var 순위 = boxoffice.getElementsByTagName("rank").item(0).textContent;
					var 제목 = boxoffice.getElementsByTagName("movieNm").item(0).textContent;
					var 개봉일 = boxoffice.getElementsByTagName("openDt").item(0).textContent;
					var 관객수 = boxoffice.getElementsByTagName("audiCnt").item(0).textContent;
					var 누적관객수 = boxoffice.getElementsByTagName("audiAcc").item(0).textContent;
					var 누적매출액 = boxoffice.getElementsByTagName("salesAcc").item(0).textContent;
					var 스크린수 = boxoffice.getElementsByTagName("scrnCnt").item(0).textContent;
					
					htmlContent +="<tr>";
					htmlContent +="<td>"+순위+"</td>";
					htmlContent +="<td>"+제목+"</td>";
					htmlContent +="<td>"+개봉일+"</td>";
					htmlContent +="<td class='text-right'>"+new Number(관객수).toLocaleString()+"</td>";
					htmlContent +="<td class='text-right'>"+new Number(누적관객수).toLocaleString()+"</td>";
					htmlContent +="<td class='text-right'>"+new Number(누적매출액).toLocaleString()+"</td>";
					htmlContent +="<td class='text-right'>"+new Number(스크린수).toLocaleString()+"</td>";
					htmlContent +="</tr>";
				}
				document.getElementById('boxoffice-body').innerHTML = htmlContent;
			}
		}
	});
</script>
</html>