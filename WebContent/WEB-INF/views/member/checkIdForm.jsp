<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>!Teach 아이디 중복확인</h3>
<br>

	<form action="<%= request.getContextPath() %>/checkId.me">
		<input type="text" id="inputId" name="inputId">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	<%
		Integer result = (Integer)request.getAttribute("result");
		if(result != null){
			if(result > 0){
	%>
				이미 사용 중인 아이디 입니다.
	<%  
			} else{
	%> 
	 			사용 가능한 아이디 입니다.
	<% 
			}
		}
	%>
	
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
	
	function inputValue(){
		console.log(<%=request.getAttribute("result")%>);

		if(<%=request.getAttribute("result")%> == null){
			document.getElementById("inputId").value = opener.document.joinForm.joinUserId.value;
		} else{
			document.getElementById("inputId").value = "<%=(String)request.getAttribute("checkedId")%>";
		}
}
		
	document.getElementById("usedId").onclick = function(){
		opener.document.joinForm.userId.value = document.getElementById("inputId").value;
		window.close();
	}



</script>
</body>
</html>