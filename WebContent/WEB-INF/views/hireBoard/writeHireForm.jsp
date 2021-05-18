<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	#insertBtn, #cancelBtn{
		padding: 5px;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	#insertBtn:hover, #cancelBtn:hover{background:#fff;color:#0554f2;}
	
	#titleImgArea {width:200px; height:100px; text-align:center; display:table-cell; vertical-align:middle;}
	
	#listArea{border: 2px solid lightgray; border-collapse:collapse; text-align: center;}
	.ts{width: 100px; font-size: 15px;}
	.ts:hover{cursor: pointer;}
	.www{background: white; width: 100%; height: 40px;}
	#mmm{
		background: white; text-align: center;
		vertical-align: middle; width: 50%; height: 40px;
	}
	.tA{width: 100%; height: 190px; background: rgb(19, 116, 242); }
	#lA{text-align: center; vertical-align: middle; width: 50%; height: 100px;}
	#c1{font-size: 30px; color: white; font-weight: bold;}
	#c2{color: white; font-weight: bold;}
	#fb{color: rgb(75, 148, 242); border-bottom: 4px solid rgb(75, 148, 242);}
	
	input{margin: 5px;}
</style>

</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts"  onclick="location.href='list.hire'">구인구직</th>
				<%if(loginMember != null) {%>
				<th class="ts" id="fb" onclick="location.href='writeHireForm.hire'">채용등록</th>
				<%} %>
			</tr>
		</table>
	</div>
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">채용공고</th>
			</tr>
			<tr>
				<th id="c2">Home > 채용공고</th>
			</tr>
		</table>
	</div>
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
								<img id="titleImg" width="150" height="100">
								<!-- 파일 업로드 하는 부분 -->
							</div>
							<div id="fileArea">
								<input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this,1)">
							</div>
						</td>
					</tr>
					<tr>
						<th width="100px">회사명</th>
						<td colspan="3"><input type="text" size="45" name="hireCompany" placeholder="회사명을 입력해주세요."></td>
					</tr>
					<tr>
						<th width="100px">채용담당자</th>
						<td colspan="3"><input type="text" size="45" name="hireName" placeholder="채용담당자의 성함을 입력해주세요."></td>
					</tr>
					<tr>
						<th width="100px">담당자 이메일</th>
						<td colspan="3"><input type="text" size="45" name="hireEmail" placeholder="이메일을 입력해주세요."></td>
					</tr>
					<tr>
						<th width="100px">모집분야</th>
						<td colspan="3"><input type="text" size="45" name="hireField" placeholder="모집분야를 입력해주세요."></td>
					</tr>
					<tr>
						<th width="100px">채용인원</th>
						<td colspan="3"><input type="text" size="45" name="employNum" placeholder="채용인원을 입력해주세요.(숫자만 기입해주세요)"></td>
					</tr>
					<tr>
						<th width="100px">채용예정월</th>
						<td colspan="3"><input type="date" size="45" name="hireDate"></td>
					</tr>
					<tr>
						<th width="100px">회사주소</th>
						<td colspan="3"><input type="text" size="45" name="companyAddress" placeholder="회사주소를 입력해주세요."></td>
					</tr>
				</table>
				
				<script>
					// 내용 작성 부분의 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
					$(function(){
						$("#fileArea").hide();
						
						$("#titleImgArea").click(function(){
							$("#thumbnailImg1").click();
						});
					});
					
					// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
					function LoadImg(value, num){
						if(value.files && value.files[0]){
							var reader = new FileReader();
							
							// e.target.result : 이미지 경로
							reader.onload = function(e){								
								if(num == 1){
									$("#titleImg").attr("src", e.target.result);
								}
							}
							
							reader.readAsDataURL(value.files[0]);
						}
					}
				</script>
				
			</div>
			<br>
			<div class="btnArea">
				<input type="submit" id="insertBtn" value="작성완료">
				<input type="button" id="cancelBtn" onclick="location.href='<%= request.getContextPath() %>/list.hire'" value="취소하기">
			</div>
			<br>
			<br>
			
		</form>
	</div>
	<script>
		$(function(){
			alert("채용정보는 수정이 불가하니 정확히 기입해주시기 바랍니다.");
		})
	</script>
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>