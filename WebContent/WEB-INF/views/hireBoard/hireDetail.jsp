<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hire.model.vo.*, java.util.*"%>
    
 <%
 	Hire h = (Hire)request.getAttribute("hire");
 	ArrayList<Files> fileList = (ArrayList<Files>)request.getAttribute("fileList");
 	Files titleImg = fileList.get(0);
 %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style>
	.outer{width:100%; display: center; border-top:2px solid #bdbdbd;border-bottom:2px solid #bdbdbd;font-family:"NanumGothic",sans-serif;}
	.outer tr{border-top:1px solid #cdcdcd;}
	.outer tr:first-child{border-top:0;}
	.outer th{background:#f6f6f6; width:30%;text-align:left; padding-left:3%}
	.outer td{text-align:left;background:#fff;padding-top:1%!important;padding-bottom:1%!important;color:#5c5c5c;font-size:15px;line-height:26px;padding-left:3%}
	.outer input[type="text"]
	{margin-right:1%;color:#5c5c5c; line-height:12px; font-size:14px;font-family:"NanumGothic",sans-serif;background:#f6f6f6;vertical-align:middle;border:1px solid #cdcdcd;padding:1%;}
	.insertArea {width:500px; height:450px; margin-left:auto; margin-right:auto;}
	
	.btnArea {margin-left:auto; margin-right:auto; width:180px;}
	/*#insertBtn,#cancelBtn {margin-left:auto; margin-right:auto; width:180px;} */
	
	#deleteHireBtn, #goListBtn{
		padding: 5px;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	#deleteHireBtn:hover, #goListBtn:hover{background:#fff;color:#0554f2;}
	
	#titleImgArea {width:200px; height:100px; text-align:center; display:table-cell; vertical-align:middle;}
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">채용 정보 작성</h2>
		
		<!-- 파일업로드를 위해 enctype을 지정해줘야 된다. -->
		<form action="<%= request.getContextPath() %>/insert.hire" method="post" encType="multipart/form-data"><!-- 파일올리는 거기 때문에 -->
			<div class="insertArea">
				<table id="insertThumbTable">
				<br>
					<tr>
						<th>회사 이미지</th>
						<td colspan="3">
							<div id="titleImgArea">
								<a href="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%=titleImg.getChangeName()%>">
									<img id="titleImg" width="300" height="100" src="<%= request.getContextPath() %>/thumbnail_uploadFiles/<%=titleImg.getChangeName()%>">
								</a>
							</div>
							<!-- <div id="fileArea">
								<input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this,1)">
							</div -->
						</td>
					</tr>
					<tr>
						<th width="100px">회사명</th>
						<td colspan="3"><%=h.getHireCompany()%></td>
					</tr>
					<tr>
						<th width="100px">채용담당자</th>
						<td colspan="3"><%=h.getHireName()%></td>
					</tr>
					<tr>
						<th width="100px">담당자 이메일</th>
						<td colspan="3"><%=h.getHireEmail()%></td>
					</tr>
					<tr>
						<th width="100px">모집분야</th>
						<td colspan="3"><%=h.getHireField() %></td>
					</tr>
					<tr>
						<th width="100px">채용인원</th>
						<td colspan="3"><%=h.getEmployNum() %></td>
					</tr>
					<tr>
						<th width="100px">채용예정월</th>
						<td colspan="3"><%=h.getHireDate() %></td>
					</tr>
					<tr>
						<th width="100px">회사주소</th>
						<td colspan="3"><%=h.getCompanyAddress() %></td>
					</tr>
				</table>
	</div>
	<br>
		<div class="btnArea">
		
			<input type="button" id="goListBtn" onclick="location.href='<%= request.getContextPath() %>/list.hire'" value="목록보기">
		
		<%if(loginMember.getMemId().equals("admin") && loginMember != null) {%>
			<input type="button" id="deleteHireBtn" onclick="location.href='<%= request.getContextPath() %>/delete.hire'" value="삭제하기">
		<%} %>
		
		</div>
		
	<br>
	<br>
	<script>
	
		$('#deleteHireBtn').on('click', function(){
			var bool = confirm("정말로 삭제하시겠습니까?");
			
			if(bool){
				location.href='<%=request.getContextPath()%>/delete.hire?no=' + <%=h.getHireNo()%>
			}
			
		});
	
	</script>
	<br>
	<br>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>