<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="license.model.vo.License, board.model.vo.Files, java.util.*"%>
<%
	License l = (License)request.getAttribute("l");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style>
	h2{margin-top: 50px; margin-bottom: 10px;}
	#write{margin: auto; width: 1000px; height:auto;}
	#id{font-weight: bold; height: 150px;}
	#insertLicenseTable th { width: 100px;}
	#insertBtn{background: rgb(75, 148, 242); border: 0px;
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	#cancelBtn{background: rgb(192, 57, 43); border: 0px;
		color: white; font-weight: bold; width: 80px; height: 30px;}
	#litable{width: 1100px;}
	#litable th {height: 40px;}
</style>
</head>
<body>
	<%@ include file = "../common/menuBar.jsp" %>
	<div id="write">
		<br>
		<h2>기출문제 게시판 수정</h2><hr>
		<br>
		<form action="<%= request.getContextPath() %>/licenseUpdate.li" method="post">
			<input type="hidden" name="li" value="<%= l.getLicenseNo() %>">
			<table id="litable">
				<tr>
					<th>제목</th>
					<td><input type="text" size="50" id="title" name="title" value="<%=l.getLicenseTitle() %>"></td>
				</tr>
				<tr>
					<th>메모</th>
					<td>
						<input type="text" size="50" id="content" name="content" value="<%= l.getLicenseContent() %>">
					</td>
				</tr>
			</table>
			
			<br>
			<hr>
			
			<div class="insertArea" align="center">
			<br>
			<br>
				<input type="hidden" name="li" value="<%= l.getLicenseNo() %>">
				<table id="insertLicenseTable">
					<tr>
						<th class="id">1번</th>
						<td colspan="3">
							<textarea name="q1" rows="5" cols="120" style="resize:none;" placeholder="문제를 입력해 주세요."><%= l.getQuestion1() %></textarea>
						</td>
					</tr>
					<tr>
						<th height="80px">정답</th>
						<td colspan="3">
							<input type="radio" name="chk_info1" value="1"> 1 &nbsp;
							<input type="radio" name="chk_info1" value="2"> 2 &nbsp;
							<input type="radio" name="chk_info1" value="3"> 3 &nbsp;
							<input type="radio" name="chk_info1" value="4"> 4 &nbsp;
						</td>
					</tr>
					<tr>
						<th class="id">2번</th>
						<td colspan="3">
							<textarea name="q2" rows="5" cols="120" style="resize:none;" placeholder="문제를 입력해 주세요."><%= l.getQuestion2() %></textarea>
						</td>
					</tr>
					<tr>
						<th height="80px">정답</th>
						<td colspan="3">
							<input type="radio" name="chk_info2" value="1"> 1 &nbsp;
							<input type="radio" name="chk_info2" value="2"> 2 &nbsp;
							<input type="radio" name="chk_info2" value="3"> 3 &nbsp;
							<input type="radio" name="chk_info2" value="4"> 4 &nbsp;
						</td>
					</tr>
					<tr>
						<th class="id">3번</th>
						<td colspan="3">
							<textarea name="q3" rows="5" cols="120" style="resize:none;" placeholder="문제를 입력해 주세요."><%= l.getQuestion3() %></textarea>
						</td>
					</tr>
					<tr>
						<th height="80px">정답</th>
						<td colspan="3">
							<input type="radio" name="chk_info3" value="1"> 1 &nbsp;
							<input type="radio" name="chk_info3" value="2"> 2 &nbsp;
							<input type="radio" name="chk_info3" value="3"> 3 &nbsp;
							<input type="radio" name="chk_info3" value="4"> 4 &nbsp;
						</td>
					</tr>
					<tr>
						<th class="id">4번</th>
						<td colspan="3">
							<textarea name="q4" rows="5" cols="120" style="resize:none;" placeholder="문제를 입력해 주세요."><%= l.getQuestion4() %></textarea>
						</td>
					</tr>
					<tr>
						<th height="80px">정답</th>
						<td colspan="3">
							<input type="radio" name="chk_info4" value="1"> 1 &nbsp;
							<input type="radio" name="chk_info4" value="2"> 2 &nbsp;
							<input type="radio" name="chk_info4" value="3"> 3 &nbsp;
							<input type="radio" name="chk_info4" value="4"> 4 &nbsp;
						</td>
					</tr>
					<tr>
						<th class="id">5번</th>
						<td colspan="3">
							<textarea name="q5" rows="5" cols="120" style="resize:none;" placeholder="문제를 입력해 주세요."><%= l.getQuestion5() %></textarea>
						</td>
					</tr>
					<tr>
						<th height="80px">정답</th>
						<td colspan="3">
							<input type="radio" name="chk_info5" value="1"> 1 &nbsp;
							<input type="radio" name="chk_info5" value="2"> 2 &nbsp;
							<input type="radio" name="chk_info5" value="3"> 3 &nbsp;
							<input type="radio" name="chk_info5" value="4"> 4 &nbsp;
						</td>
					</tr>
					
					
					
				</table>
			<br>
			<br>
			
			</div>		
			<br>
			<div align="center">
				<input type="submit" id="insertBtn" value="수정하기">
				<input type="button" id="cancelBtn" onclick="location.href='javascript:history.go(-1);'" value="취소하기">
			</div>
				
		</form>
		<br>
		
		<br>
	</div>
	
	
	
	<%@ include file = "../common/footer.jsp" %>
	
	<script>
		$(function(){
			switch(<%= l.getAnswer1() %>){
					case 1: $("#chk1-1").prop(checked); break;
					case 2: $("#chk1-2").prop(checked); break;
					case 3: $("#chk1-3").prop(checked); break;
					case 4: $("#chk1-4").prop(checked); break;
			}
		});
	</script>
	
	
</body>
</html>