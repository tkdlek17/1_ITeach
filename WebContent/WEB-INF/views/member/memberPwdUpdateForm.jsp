<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style>

.outer{width: 100%; height: 500px;}
 	#infot{border: 2px solid lightgray; width: 600px;}
 	.jj{font-weight: bold;
 	margin-top:5%;}
 	#updatePwdBtn, #cancelBtn{background: rgb(75, 148, 242); color: white; width:100px; height: 40px;}
 	#updatePWDtable{
 	margin-left: 36%;
 	margin-top: 10%;
 	}
 	
</style>

</head>
<body>
<header>
	  	<%@ include file="../common/menuBar.jsp" %>
</header>

<div class="outer">
		<br>
		<h2 align="center">비밀번호 수정하기</h2>
		
		<form action="<%= request.getContextPath() %>/UpdatePwdServlet" method="post" id="updatePwdForm" name="updatePwdForm" onsubmit="return send();">
			<table id="updatePWDtable">
				<tr>
					<td class="jj"><label>현재 비밀번호</label></td>
					<td class="jj"><input type="password" name="memPwd" id="memPwd"></td>
				</tr>
				
				<tr>
					<td class="jj"><label>변경 비밀번호</label></td>
					<td class="jj"><input type="password" name="newPwd"></td>
				</tr>
				<tr>
					<td class="jj"><label>변경 비밀번호 확인</label></td>
					<td class="jj"><input type="password" name="newPwd2"></td>
				</tr>
			</table>
			
			<br><br>
			
			<div class="btns" align="center">
				<input id="updatePwdBtn" type="submit" value="변경하기">
				<input type="button" id="cancelBtn" onclick="location.href='javascript:history.back();'" value="취소하기">
			</div>
		</form>
	</div>
	<script type="text/javascript">
	function send(){
		var newPwd = $('#newPwd');
        var newPwd2 = $('#newPwd2');
        
        console.log(newPwd);
        System.out.println(newPwd);
        System.out.println(newPwd2.val());
        
        if(newPwd.val().trim() != newPwd2.val().trim()){
           alert('비밀번호가 다릅니다.');
           newPwd2.focus();
           return false;
        } else if(newPwd.val().trim() == '' || newPwd2.val().trim() == ''){
           alert('비밀번호를 입력해주세요');
           newPwd.focus();
           return false;
        }
        
        return true;
     }
	</script>

<footer>
		<%@ include file="../common/footer.jsp" %>
</footer>
</body>
</html>