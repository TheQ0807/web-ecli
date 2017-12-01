<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PASSWORD CHANGE</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.container {
	width: 1024px;
	margin: 0 auto;
	margin-top: 10%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div  class="col-sm-offset-3 col-sm-6">
				<form class="form-horizontal well">
					<h1 class="text-center">PASSWORD CHANGE</h1>
           				<div class="form-group">
               				<label class="control-label col-sm-3">PW</label>
               					<div class="col-sm-7">
                   					<input type="text" class="form-control" id="pw" placeholder="변경할 비밀번호를 입력하세요"/>
               					</div>
           				</div>
              			<div class="form-group">
              		 			<label class="control-label col-sm-3">PW-CHECK</label>
               					<div class="col-sm-7">
                  	 				<input type="password" class="form-control" id="repw" placeholder="확인을위해 다시입력하세요"/>
               					</div>
						</div>
						<div class="form-group text-center">
							<div class="col-sm-12">
								<button class="btn btn-danger" type="submit" id="pwch-btn">변경</button>
							</div>
						</div>			
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
		document.getElementById("pwch-btn").addEventListener('click', function(event){
		event.preventDefault();
		var pw = document.getElementById("pw").value;
		var repw = document.getElementById("repw").value;
		if(pw != repw || pw == '' || repw == ''){
			alert("아이디와 비밀번호를 확인하여주세요");
			document.getElementById("pw").value = "";
			document.getElementById("repw").value = "";
		}
	});
</script>
</html>