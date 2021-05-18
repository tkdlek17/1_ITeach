<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Fboard" %>
<% Fboard sb = (Fboard)request.getAttribute("sb"); %>
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
	#updateNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	#cancelBtn{background: rgb(192, 57, 43); 
		color: white; font-weight: bold; width: 80px; height: 30px;}
	button:hover{cursor: pointer;}
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<div class="outer">
		<br>
		<h2>스터디모집 수정</h2><hr>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/update.st" method="post">
		<%-- 	<label>등록일 : </label>
				<input type="date" name="date" value="<%= sb.getModifyDate() %>"><br><br> --%>
				<input type="hidden" name="no" value="<%= sb.getBoardNo() %>"> 
				<input type="hidden" name="id" value="<%= sb.getId() %>"> 
				<input type="text" size="50" id="region" name="region" placeholder="지역을 입력해 주세요.(시군구)" value="<%= sb.getRegion() %>"><br><br>
				<input type="text" size="50" id="title" name="title" placeholder="제목을 입력해 주세요." value="<%= sb.getBoardTitle() %>"><br><br>
				<textarea name="content" id="textarea" cols="60" rows="20" style="resize:none;" placeholder="내용을 입력해 주세요."><%= sb.getBoardContent() %></textarea>
				
				
				<br>
				
				<div align="center">
					<input type="submit" id="updateNoBtn" value="수정">
					<input type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>