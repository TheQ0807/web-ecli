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
	<h1>글 수정</h1>
	
	<form method="post" action="modify.do">
		<input type="hidden" name="no" value="${board.no }">
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="title" value="${board.title }">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" name="writer" value="${board.writer }">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea rows="10" class="form-control" name="contents">${board.contents }</textarea>
		</div>
		<div class="text-right">
			<button type="submit" class="btn btn-primary btn-sm">수정</button>
		</div>
	</form>
</div>
</body>
</html>