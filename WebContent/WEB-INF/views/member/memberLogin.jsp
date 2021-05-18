<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
	.a{font-size: 70px; color: rgb(75, 148, 242); font-weight: bold;}
	#userId, #password{
		width:400px; height: 45px; 
	}
	#userId{
		margin-bottom: 7px;
	}
	#password{
		margin-bottom: 10px;
	}
	#signup{
		width:400px; height: 50px; background: rgb(75, 148, 242); color: white;
		margin-bottom: 10px; 
	}
	#goMain{
		margin-left: 340px; font-weight: bold;   
	}
	button:hover{cursor: pointer;}
	#goMain:hover{cursor: pointer;}
</style>
</head>
<body class="b">
	<%@ include file="../common/menuBar.jsp" %>
	<br><br><br><br>	
	
	
	 
	<div class="loginArea" align="center">
		
			<form id="loginForm" action="<%= request.getContextPath() %>/Login.meto" method="post" onsubmit="return validate();">
	<div id="content">
		
		<h1 class="a">!TEACH</h1><br><br>
		
		
		<input type="text" id="userId" name="userId" placeholder="아이디">
		<span id="existId"></span>
		
		<br>
		<input type="password" id="password" name="password" placeholder="비밀번호">
		
		<br>
    	<span><button id="signup">로그인</button></span>
    	
    	<br>
		<span><label id="goMain" onclick="goHome();">홈으로</label></span>
    	
    	
		
		</div>
		</form>
<br><br><br><br><br><br>
	</div>
	
	<script>
		function validate(){
			var id = $('#userId');
			var pwd = $('#password');
	
			if(id.val().trim().length == 0){
				alert("아이디를 입력해주세요");
				id.focus();
		
				return false;
			} else if(pwd.val().trim().length == 0){
				alert("비밀번호를 입력하세요");
				pwd.focus();
		
				return false;
			}
			return true;
		}
	</script>

   	<%@ include file="../common/footer.jsp" %> 
</body>
</html>