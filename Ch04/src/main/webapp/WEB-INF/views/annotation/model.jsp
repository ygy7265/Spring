<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Annotation::model</title>
	</head>
	<body>
		<h3>ModelAttribute</h3>
		
		<a href="/Ch04/index">index</a>
		<form action="/Ch04/annotation/model1" method="POST">	
				<input type="text" name="uid"/><br>
				<input type="submit" value="등록하기"/>
		</form>
		<form action="/Ch04/annotation/model2" method="POST">	
				<input type="text" name="uid"/><br>
				<input type="text" name="name"/><br>
				<input type="submit" value="등록하기"/>
		</form>
		<form action="/Ch04/annotation/model3" method="POST">	
				<input type="text" name="uid"/><br>
				<input type="text" name="name"/><br>
				<input type="text" name="hp"/><br>
				<input type="number" name="age"/><br>
				<input type="submit" value="등록하기"/>
		</form>
	
	</body>
</html>