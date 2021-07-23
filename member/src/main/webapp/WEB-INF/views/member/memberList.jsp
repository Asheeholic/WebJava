<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>회원 목록 리스트</h1></div>
		<div>
			<table border="1">
				<tr>
					<th width="100">ID</th>
					<th width="100">Password</th>
					<th width="100">Name</th>
					<th width="100">Age</th>
					<th width="100">Hobby</th>
				</tr>
				<c:forEach var="member" items="${list }">
					<tr>
						<td align="center">${member.id}</td>
						<td align="center">${member.password}</td>
						<td align="center">${member.name}</td>
						<td align="center">${member.age}</td>
						<td align="center">${member.hobby}</td>
					</tr>
				</c:forEach>
			</table>
		
			<c:forEach var="member" items="${list }">
				${member.id } : ${member.name } : ${member.password }
				: ${member.age } : ${member.hobby }<br>
			</c:forEach>
		</div>
		<br>
		<div>
			<button type="button" onclick="location.href='main.do'">홈으로</button>
		</div>
	</div>
</body>
</html>