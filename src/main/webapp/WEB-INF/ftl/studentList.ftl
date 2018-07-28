<html>
<head>
	<title>student information</title>
</head>
<body>
	<h1>student information</h1> <br>
	<table border='1'>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>gender</td>
			<td>age</td>
			<td>address</td>
		</tr>
		<#list students as student>
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.gender}</td>
			<td>${student.age}</td>
			<td>${student.address}</td>
		</tr>
		</#list>
	</table>
	
	<h1>welcome you</h1>
</body>
</html>