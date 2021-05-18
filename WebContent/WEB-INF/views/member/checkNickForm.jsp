<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue();">
	<h3>!Teach 닉네임 중복확인</h3>
	<br>
	
	<form action="<%= request.getContextPath() %>/checkNick.xx" id="nickCheckForm">
		<input type="text" id="inputNick" name="inputNick">
		<input type="submit" value="중복확인"/>
	</form>
	
	<%
		Integer result = (Integer)request.getAttribute("result");
		if(result != null){
			if(result > 0){
	%>
				이미 사용 중인 닉네임 입니다.
	<%  	
			} else {
	%>
				사용 가능한 닉네임 입니다.
	<%
				}
			}
	%>
	<br>
	<br>
	
	<input type="button" id="memNick" value="확인">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	<script>
		function inputValue(){
			if(<%=request.getAttribute("result")%> == null){
				document.getElementById("inputNick").value = opener.document.joinForm.nickName.value;
			} else{
				document.getElementById("inputNick").value = "<%= (String)request.getAttribute("checkedNick")%>";
			}
		}
	
		document.getElementById("memNick").onclick = function(){
				opener.document.joinForm.nickName.value = document.getElementById("inputNick").value;
				window.close();
		}
	
	</script>
</body>
</html>