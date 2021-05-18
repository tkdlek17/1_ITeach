<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
    <%
	Member member = (Member)session.getAttribute("loginMember");
	Member mb = (Member)request.getAttribute("member");
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
 	.outer{width: 100%; height: 500px;}
 	#infot{border: 2px solid lightgray; width: 600px;}
 	.jj{font-weight: bold;}
 	#updatePwdBtn:hover{cursor: pointer;}
 	#updatePwdBtn{text-decoration: underline; color: #1E3269; font-weight: bold;}
 	#updateBtn, #deleteBtn, #gohome{background: rgb(75, 148, 242); color: white; width:100px; height: 40px;}
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>

		<div class="outer" align="center">
		<br><br><br><br>
		
		<div id="infot">
		<h2>내 정보 보기</h2>
		
		<br><br>
		
		<form action="<%= request.getContextPath() %>/UpdateMemberFormServlet" method="post" id="myForm" name="myForm">
			<table id="myPagetable">
				<tr>
					<td width="200px" class="jj">아이디</td>
					<td width="200px"><%=mb.getMemId() %><input type="hidden" maxlength="13" name="myId" value="<%= mb.getMemId() %>" required></td>
				</tr>
				<tr>
					<td class="jj">이름</td>
					<td><%= mb.getMemName() %><input type="hidden" name="myName" required value="<%= mb.getMemName() %>"></td>
				</tr>
				<tr>
					<td class="jj">닉네임</td>
					<td><%= mb.getMemNick() %><input type="hidden" maxlength="15" name="myNickName" required value="<%= mb.getMemName() %>"></td>
				</tr>
				<tr>
					<td class="jj">성별</td>
					<td>
						<%=mb.getGender() == null? "-" : mb.getGender()%>
						<input type="hidden" maxlength="11" name="mygender" value="<%=mb.getGender() %>">
					</td>
				</tr>
				<tr>
					<td class="jj">이메일</td>
					<td><%=mb.getEmail() == null? "-" : mb.getEmail()%><input type="hidden" name="myEmail" value="<%=mb.getEmail() %>"></td>
				</tr>
				<tr>
					<td class="jj">회원가입일</td>
					<td><%=mb.getEnrollDate() %><input type="hidden" name="myEnrollDate" value="<%=mb.getEnrollDate() %>"></td>
				</tr>
				<tr>
					<td class="jj">비밀번호</td>
					<td id="updatePwdBtn" value="비밀번호 변경 하기" onclick="location.href='UpdatePwdForm'">변경하기</td>
				</tr>
			
			</table>
			
			<br><br>
			
			<div class="myPageBtns" align="center">
				<input id="updateBtn" type="submit" value="수정하기">
				<input id="deleteBtn" type="button" value="탈퇴하기" onclick="deleteMember();">
				<input type="button" id="gohome" onclick="goHome();" value="메인으로">	
			</div>
		</form>
		<br>
		</div>
	</div>
	<br><br><br>
	<script>
		function deleteMember(){
			var bool = confirm("정말로 탈퇴하시겠습니까?");
			
			if(bool){
				location.href="<%= request.getContextPath()%>/delete.me";
			}
		}
		
	</script>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>