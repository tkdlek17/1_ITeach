<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.*, java.util.*, license.model.vo.Comments, license.model.vo.License"%>
<%
	License license = (License)request.getAttribute("license");
	ArrayList<Files> fileList = (ArrayList<Files>)request.getAttribute("fileList");
	ArrayList<Comments> list = (ArrayList<Comments>)request.getAttribute("list");
	
	System.out.println(license);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style>
	.www{background: white; width: 100%; height: 40px;}
	#mmm{
		background: white; text-align: center;
		vertical-align: middle; width: 50%; height: 40px;
	}
	.tA{width: 100%; height: 190px; background: rgb(19, 116, 242); }
	#lA{text-align: center; vertical-align: middle; width: 50%; height: 100px;}
	#c1{font-size: 30px; color: white; font-weight: bold;}
	#c2{color: white; font-weight: bold;}
	#gg{color: rgb(75, 148, 242); border-bottom: 4px solid rgb(75, 148, 242);}
	#detail > table {text-align: center;}
	#goQuestion{
		border: 0px; width: 250px; height: 30px; margin-left: 5px;
		border-radius: 10px;
		background: #4894F2; color: white; 
		font-size: 20px;
	}
	button{
	border-radius: 7px; border: 0px;
		color: white; background:rgba(95, 217, 243, 0.73);
		width: 100px; height: 30px;
	}
	.downloadFile{
		border-radius: 7px; border: 0px;
		color: white; background: rgb(75, 148, 242);
		text-align: center;
	}
	
	.files{width: 180px; height: 40px; padding: 5px;}
	
	.qt{text-align: center; vertical-align: middle; width: 60px;}
	.qd{height: 200ps; weight: 150px;}
	
	#addComments{background: rgb(75, 148, 242); border: 0px;border-radius: 4px;  font-size : 13px; color: white;
	width: 80px;height: 48px;  margin-left: 10px;}
	
	#updateBtn{background: rgb(75, 148, 242); border: 0px; border-radius: 4px;
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	#deleteBtn{background: rgb(192, 57, 43); border: 0px; border-radius: 4px;
		color: white; font-weight: bold; width: 80px; height: 30px;}
	#menuBtn{background: rgb(22, 160, 133); border: 0px; border-radius: 4px;
		color: white; font-weight: bold; width: 80px; height: 30px;}
	button:hover{cursor: pointer;}
	.show:hover{cursor: pointer;}
	#title{font-size: 30px; font-weight: weigh;}
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" id="gg" onclick="location.href='list.li'">기출문제</th>
			</tr>
		</table>
	</div>
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">기출문제</th>
			</tr>
			<tr>
				<th id="c2">Home &gt; 기출문제</th>
			</tr>
		</table>
	</div>
	<br>
	<form action="<%= request.getContextPath() %>/licenseUpdateForm.li" id="detailForm" method="post">
		
		<input type="hidden" name="no" value="<%= license.getLicenseNo() %>">
	
	
		<table style="float: right;">
			<th style="width: 60px;">작성자</th>
			<td style="width: 60px;">
				<input type="hidden" name="writer" value="<%= license.getMemNick() %>">
				<%= license.getMemNick() %>
			</td>
			<th style="width: 60px;">등록일</th>
			<td style="width: 100px;">
				<input type="hidden" name="createDate" value="<%= license.getCreateDate() %>">
				<%= license.getCreateDate() %>	
			</td>
		</table>
	
	
	<br>
	<div id="detail">
		<br>
		<div align="center">
			<label id="title"><%= license.getLicenseTitle() %></label>
			<input type="hidden" name="title" value="<%= license.getLicenseTitle() %>">
			<br>
			<input type="hidden" name="content" value="<%= license.getLicenseContent() %>">
			<%= license.getLicenseContent() %>
		</div>
		
		<br>
		<div class="content" align="center">
			<br>
			<table>
				<tr>
					<td class="files">
						<div class="downloadFile">
							<a href='<%=request.getContextPath() %>/license_uploadFiles/<%= fileList.get(0).getChangeName() %>'
								download='<%= fileList.get(0).getFileName() %>'> 문제 파일 다운로드 </a>
						</div>
						
					</td>
					<td class="files">
						<div class="downloadFile">
							<a href='<%=request.getContextPath() %>/licens_uploadFiles/<%= fileList.get(1).getChangeName() %>'
								download='<%= fileList.get(1).getFileName() %>'> 답안 파일 다운로드 </a>
						</div>
						
					</td>
				</tr>
			</table>
			
			<br><br>
			
			<table id="Qa" width="1100px;">
				<tr style="height: 10px;">
				</tr>
				
				<tr>
					<th class="qt">1번</th>
					<td class="qd">
						<input type="hidden" name="q1" value="<%= license.getQuestion1() %>">
						<pre><%= license.getQuestion1() %></pre>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				<tr style="background: rgb(75, 148, 242); color: white;">
					<td class="qt"><div id="ans1" class="show">정답</div></td>
					<td id="ans1-1">
						<input type="hidden" name="a1" value="<%= license.getAnswer1() %>">
						<%= license.getAnswer1() %>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				
				<tr>
					<th class="qt">2번</th>
					<td class="qd">
						<input type="hidden" name="q2" value="<%= license.getQuestion2() %>">
						<pre><%= license.getQuestion2() %></pre>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				<tr style="background: rgb(75, 148, 242); color: white;">
					<td class="qt"><div id="ans2" class="show">정답</div></td>
					<td id="ans2-1">
						<input type="hidden" name="a2" value="<%= license.getAnswer2() %>">
						<%= license.getAnswer2() %>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				
				
				<tr>
					<th class="qt">3번</th>
					<td class="qd">
						<input type="hidden" name="q3" value="<%= license.getQuestion3() %>">
						<pre><%= license.getQuestion3() %></pre>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				<tr style="background: rgb(75, 148, 242); color: white;">
					<td class="qt"><div id="ans3" class="show">정답</div></td>
					<td id="ans3-1">
						<input type="hidden" name="a3" value="<%= license.getAnswer3() %>">
						<%= license.getAnswer3() %>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				
				
				<tr>
					<th class="qt">4번</th>
					<td class="qd">
						<input type="hidden" name="q4" value="<%= license.getQuestion4() %>">
						<pre><%= license.getQuestion4() %></pre>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				<tr style="background: rgb(75, 148, 242); color: white;">
					<td class="qt"><div id="ans4" class="show">정답</div></td>
					<td id="ans4-1">
						<input type="hidden" name="a4" value="<%= license.getAnswer4() %>">
						<%= license.getAnswer4() %>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				
				
				<tr>
					<th class="qt">5번</th>
					<td class="qd">
						<input type="hidden" name="q5" value="<%= license.getQuestion5() %>">
						<pre><%= license.getQuestion5() %></pre>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				
				<tr style="background: rgb(75, 148, 242); color: white;">
					<td class="qt"><div id="ans5" class="show">정답</div></td>
					<td id="ans5-1">
						<input type="hidden" name="a5" value="<%= license.getAnswer5() %>">
						<%= license.getAnswer5() %>
					</td>
				</tr>
				<tr style="height: 10px;">
				</tr>
				
				
			
			</table>
			
			<br><br>
			
			<div align="center">
					<% if(loginMember != null && license.getLicenseWriter().equals(loginMember.getMemId())) { %>
					<input type="submit" id="updateBtn" value="수정">
					<input type="button" onclick="deleteLicense()" id="deleteBtn" value="삭제">
					<% } %>
					<input type="button" onclick="location.href='<%= request.getContextPath() %>/list.li'" id="menuBtn" value="메뉴로">
			</div>
		</div>	
		</div>	
		</form>
		<br><br>
		<div id="commentsArea" align="center">
		
			<div id="commentsWriter">
				<table>
					<tr>
						<td><textarea rows="3" cols="90" id="commentContent" style="resize:none;"></textarea></td>
						<td><button id="addComments">등록</button></td>
					</tr>
				</table>

			</div>
				
			<div id="commentSelectArea">
				<table id="commentsTable">
					<%if(list.isEmpty()) { %>
					<tr><td colspan="3">댓글이 없습니다.</td></tr>		
					<% } else { %>
					<%	for(int i = 0; i < list.size(); i++) { %>
						<tr>
							<td width="100px"><%= list.get(i).getMemNick()%></td>
							<td width="400px"><%= list.get(i).getContent() %></td>
							<td width="200px"><%= list.get(i).getCreateDate() %></td>
						</tr>
					<%
						}
					}
					%>	
				
				
				</table>
			</div>
		
		</div>
	
	<br><br><br>
	<%@ include file="../common/footer.jsp" %>
	
	<script>
	$(function(){
		$('#ans1-1').hide();
		$('#ans2-1').hide();
		$('#ans3-1').hide();
		$('#ans4-1').hide();
		$('#ans5-1').hide();
	});
	
	
	$('#ans1').click(function(){
		$('#ans1-1').toggle();
		
		count++;
		
		if(count % 2 != 0 ){
			$('#ans1-1').show();
		} else {
			$('#ans1-1').hide();
		}
	});
	
	
	$('#ans2').click(function(){
		$('#ans2-1').toggle();
		
		count++;
		
		if(count % 2 != 0 ){
			$('#ans2-1').show();
		} else {
			$('#ans2-1').hide();
		}
	});
	
	$('#ans3').click(function(){
		$('#ans3-1').toggle();
		
		count++;
		
		if(count % 2 != 0 ){
			$('#ans3-1').show();
		} else {
			$('#ans3-1').hide();
		}
	});
	
	$('#ans4').click(function(){
		$('#ans4-1').toggle();
		
		count++;
		
		if(count % 2 != 0 ){
			$('#ans4-1').show();
		} else {
			$('#ans4-1').hide();
		};
	});
	
	$('#ans5').click(function(){
		$('#ans5-1').toggle();
		
		count++;
		
		if(count % 2 != 0 ){
			$('#ans5-1').show();
		} else {
			$('#ans5-1').hide();
		};
	});
	
		$(function(){
			$('#addComments').on('click', function(){
				var memNum = "<%= loginMember.getMemNum() %>";
				var writer = "<%= loginMember.getMemNick()%>";
				var li = "<%= license.getLicenseNo() %>";
				var content = $('#commentContent').val();
				
				$.ajax({
					url: 'insertComments.li',
					data: {memNum:memNum, writer:writer, li:li, content:content},
					success: function(data){
						console.log(data); 
						$commentsTable = $('#commentsTable');
						$commentsTable.html('');
						
						for(var key in data){
							var $tr = $('<tr>');
							var $writerTd = $('<td>').text(data[key].memNick).css('width', '100px');
							var $contentId = $('<td>').text(data[key].content).css('width', '400px');
							var $dateTd = $('<td>').text(data[key].createDate).css('width', '200px');
							
							$tr.append($writerTd);
							$tr.append($contentId);
							$tr.append($dateTd);
							$commentsTable.append($tr);
						}
						
						$('#commentContent').val('');
						
						
					},
					error: function(data){
						console.log('서버 전송 실패 시 호출되는 함수');
						console.log(data);
					}
				});
				
				
			});
		});
	
	
	
	
	function deleteLicense(){
		var bool = confirm('정말로 삭제하시겠습니까?');
		
		if(bool){
			location.href = '<%= request.getContextPath() %>/delete.li?li=' + <%= license.getLicenseNo() %>;
		}
	}
	</script>

</body>
</html>