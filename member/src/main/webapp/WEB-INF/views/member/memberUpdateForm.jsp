<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>회원수정</div>
		<div>
			<form id="frm" name="frm" action="memberUpdate.do">
				<div>
					<table border="1">
						<tr>
							<th width="150">수정할 ID</th>
							<td width="400">
								<input type="text" id="id" name="id" placeholder="아이디 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">비밀번호</th>
							<td width="400">
								<input type="password" id="password" name="password" placeholder="비밀번호 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">비밀번호 확인</th>
							<td width="400">
								<input type="password" id="passcheck" name="passcheck" placeholder="비밀번호 확인" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">나이</th>
							<td width="400">
								<input type="number" id="age" name="age" placeholder="나이 입력" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">취미</th>
							<td width="400">
								<input type="checkbox" id="hobbys" name="hobbys" value="등산">등산&nbsp;
								<input type="checkbox" id="hobbys" name="hobbys" value="낚시">낚시&nbsp;
								<input type="checkbox" id="hobbys" name="hobbys" value="운동">운동&nbsp;
								<input type="checkbox" id="hobbys" name="hobbys" value="독서">독서&nbsp;
								<input type="checkbox" id="hobbys" name="hobbys" value="영화보기">영화보기&nbsp;
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="submit" value="회원수정">
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>