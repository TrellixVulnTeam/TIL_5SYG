<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>글을 삭제합니다.</h1>
	<form action="http://localhost:8080/mvc/boarddelete" method="post">
		삭제할 글번호<input type="text" name="seq">		
		<input type="submit" value="삭제">
	</form>
</body>
</html>