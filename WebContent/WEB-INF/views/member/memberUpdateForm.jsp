<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="member.model.vo.Member"%>
    
    <%
    Member member = (Member)session.getAttribute("loginMember");
    Member mb = (Member)request.getAttribute("member");
    
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style>


.outer{width: 100%; height: 500px;}
 	#infot{border: 2px solid lightgray; width: 600px;}
 	.jj{font-weight: bold;}
 	#updatePwdBtn:hover{cursor: pointer;}
 	#updatePwdBtn{text-decoration: underline; color: #1E3269; font-weight: bold;}
 	#updateBtn, #cancelBtn, #gohome{background: rgb(75, 148, 242); color: white; width:100px; height: 40px;}


</style>
</head>
<body>
	  	<%@ include file="../common/menuBar.jsp" %>

<div class="outer" align="center">
		<br><br><br><br>
		<div id="infot">
		<h2>내 정보 수정</h2>
		<br><br>
		<form action="<%= request.getContextPath() %>/UpdateMemberServlet" method="post" id="updateForm" name="updateForm">
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td width="200px"><input type="text" name="myId" value="<%=mb.getMemId()%>"style="background:lightgray;" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="myName" value="<%=mb.getMemName()%>"required></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" maxlength="15" name="myNickName" value="<%=mb.getMemNick()%>" required></td>
					
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="text" maxlength="6" name="mygender" value="<%=mb.getGender()%>" placeholder="남자 / 여자">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="myEmail" value="<%=mb.getEmail()%>"></td>
				</tr>
				
				
			</table>
			
			<br>
			<br><br>
			<div class="btns" align="center">
				<input id="updateBtn" type="submit" value="수정하기">
				<input type="button" id="cancelBtn" onclick="location.href='javascript:history.go(-1)'" value="취소하기">
			</div>
		</form>
		<br>
	</div>
	</div>
<br><br><br>

<footer>
		<%@ include file="../common/footer.jsp" %>
</footer>

</body>
</html>