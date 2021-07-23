<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
</head>
<body>
	<div align="center">
		<div><h1>회원조회</h1></div>
		<div>
			<!-- 검색이니깐 get도 괜찮지 않을까? -->
			<form id="frm" name="frm" action="memberSearch.do" method="post">
				<table border="1">
					<tr>
						<th width="250">조회할 회원 아이디</th>
						<th>
							<input type="text" id="id" name="id" placeholder="아이디 입력">
						</th>
					<tr>
				</table>
				<div>
					<input type="submit" value="검색">
				</div>
			</form>		
		</div>
	</div>
</body>
</html>