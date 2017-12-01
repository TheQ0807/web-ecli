<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Bootstrap Example</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(window).on("load",(function() {    
	     $('#loading').hide();  
	    }));
	var url;
		function watermarkMaking() {
			$('#loading').show(); 
			var formData = new FormData($("#form")[0]);
			formData.append("f", $("#f")[0].files[0]);
			$.ajax({
				type : "POST",
				url : "watermarkmk.jsp",
				processData: false,
				contentType: false,
				data : formData,
				success : function(res) {
					url = res;//.replace(/[\n]/g, "");
					$("#ajaximg").css("display", "block");
					$("#ajaximg").attr("src", "/img/"+url);
					var encoded = encodeURI($("#ajaximg").attr("src"));
					$("#ajaximg").attr("src", encoded);
					$('#loading').hide();
				}
			});
		}
	</script>
	<style>
		#loading {
		 width: 100%;  
		 height: 100%;  
		 top: 0px;
		 left: 0px;
		 position: fixed;  
		 display: block;  
		 opacity: 0.7;  
		 background-color: #fff;  
		 z-index: 99;  
		 text-align: center; } 
		  
		#loading-image {  
		 position: absolute;  
		 top: 50%;  
		 left: 50%; 
		 z-index: 100; }
	</style>
</head>
<body>
<div class="container">
	<h1>첨부파일 업로드</h1>
	<form method="post" id="form" action="javascript:watermarkMaking();" enctype="multipart/form-data">
		<input type="file" name="f" id="f"> <br/>
		<button type="submit">파일 업로드</button>
	</form>
	<img src="" id="ajaximg" style="display:hidden; width:100%">
</div>
<div id="loading"><img id="loading-image" src="/img/ajax-loader.gif" alt="Loading..." /></div>
</body>
</html>