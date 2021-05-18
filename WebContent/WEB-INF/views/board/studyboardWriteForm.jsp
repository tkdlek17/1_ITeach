<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style type="text/css">
	h2{margin-top: 50px; margin-bottom: 10px;}
	.tableArea{margin-top: 10px;}
	#title{width: 50%; height: 30px; font-size: 15px;}
	#region{width: 300px; height: 30px; font-size: 15px;}
	#textarea{width: 100%; margin-bottom: 30px; font-size: 15px;}
	label{font-weight: bold;}
	#insertNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	#cancelBtn{background: rgb(192, 57, 43); 
		color: white; font-weight: bold; width: 80px; height: 30px;}
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<div class="outer">
		<br>
		<h2>스터디모집 게시판 글쓰기</h2><hr>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/insert.st" method="post">
				<%-- 
				<label>게시판 종류 : </label>
				<select name="category">
					<option>--------</option>
					<option value="10">질문</option>
					<option value="20">문법</option>
					<option value="30">자유글</option>
					<option value="40">기출문제</option>
					<option value="50">채용공고</option>
					<option value="60">추천서적</option>
					<option value="70">스터디모집</option>
				</select><br><br>
				--%>
				<input type="text" size="50" id="region" name="region" placeholder="지역을 입력해 주세요.(시군구)"><br><br>
				<input type="text" size="50" id="title" name="title" placeholder="제목을 입력해 주세요."><br><br>
				<textarea name="content" id="textarea" cols="60" rows="20" style="resize:none;" placeholder="내용을 입력해 주세요."></textarea>
				
				
				<br>
				
				<div align="center">
					<input type="submit" id="insertNoBtn" value="등록">
					<input type="button" id="cancelBtn" onclick="location.href='<%= request.getContextPath() %>/list.st'" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>