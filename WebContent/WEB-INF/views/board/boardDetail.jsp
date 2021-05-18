<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Fboard, board.model.vo.Comments, java.util.ArrayList" %>
<% 
	Fboard fb = (Fboard)request.getAttribute("fboard");
	ArrayList<Comments> list = (ArrayList<Comments>)request.getAttribute("list");
	System.out.println(fb);
	System.out.println(list);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style>
	h4{color: rgb(75, 148, 242); margin-top: 30px;}
	hr{border:1px solid rgb(75, 148, 242);}
	#title{font-size: 30px; font-weight: bold;}
	#nickName{color: darkgray; font-size: 20px; font-weight: bold;}
	.jj{font-size: 15px; color: gray;}
	#ap{font-size: 20px; font-weight: bold;}
	#tcontent{margin-top: 10px; width: 100%; font-size: 17px;}
	#updateNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	#deleteNoBtn{background: rgb(192, 57, 43); 
		color: white; font-weight: bold; width: 80px; height: 30px;}
	#cancelBtn{background: rgb(22, 160, 133); 
		color: white; font-weight: bold; width: 80px; height: 30px;}
	#addComments{background: rgb(75, 148, 242); border: 0px;border-radius: 4px;
		color: white; font-weight: bold; width: 80px;height: 70px;}
	#cnickName{color: darkgray; font-weight: bold;}
	#commentsContent{margin-top: 5px; width: 980px; height: 75px; font-size: 15px}
	#cNick{font-weight: bold;}
	button:hover{cursor: pointer;}
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<div class="outer">
		<br>
		<h4>커뮤니티 > <%= fb.getCateName() %></h4>
		<div class="tableArea">
			<form action="boardUpdateForm.fbo" id="detailForm" name="detailForm" method="post">
			<input type="hidden" size="50" name="no" value="<%= fb.getBoardNo() %>"> 
				<input type="hidden" size="50" name="id" value="<%= fb.getId() %>">
				<input type="hidden" size="50" name="title" value="<%= fb.getBoardTitle() %>">
				<label id="title"><%= fb.getBoardTitle() %></label><br><br>
				<label id="nickName"><%= fb.getMemNick() %></label>
	 			<input type="hidden" size="50" name="nickName" value="<%= fb.getMemNick() %>"><br>			
<%-- 				<input type="hidden" name="date" value="<%= fb.getModifyDate() %>">				 --%>
				<label class="jj"><%= fb.getModifyDate() %></label> &nbsp;&nbsp; <label class="jj">조회&nbsp;<%= fb.getBoardView() %></label>
					<br>
					<hr><br>
					<textarea name="content"  id="tcontent" cols="60" rows="20" style="resize:none;" readonly><%= fb.getBoardContent() %></textarea>
				
				<br><br><br>
				
				<div align="center">
					    <% if(loginMember != null && fb.getMemNick().equals(loginMember.getMemNick())){ %> 
						<input type="submit" id="updateNoBtn" value="수정">
						<input type="button" id="deleteNoBtn" value="삭제">
					 	<% } %> 
<%-- 				<input type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="뒤로"> --%>
					<input type="button" onclick="location.href='list.fbo'" id="cancelBtn" value="목록">
				</div>
			</form>

			<br><br><br>
					
			<hr>	
<%-- 			<label id="ap">댓글</label><br><br>      --%>
				
			<br>
	<div class="commentsArea">
		<% if(loginMember != null){ %>  
		<div class="commentsWriterArea">
			<label id="cnickName"><%= loginMember.getMemNick() %></label><br>   
			<table>
			<tr>
				<td width="1000px"><textarea rows="5" cols="80" id="commentsContent" style="resize:none;" placeholder="댓글을 입력해 주세요."></textarea></td>
				<td width="100px"><button id="addComments">등록</button></td>
			</tr>
			</table>
		</div>
		<% } %>
		<br>
		
		<div id="commentsSelectArea"><!-- 댓글 조회 부분 -->
			<table id="commentsSelectTable">
				<% if(list.isEmpty()){ %>
					<tr><td colspan="3">댓글이 없습니다.</td></tr>
				<% } else { %>
					<% for(int i = 0; i < list.size(); i++){ %>
						<tr>
							<td width="150px" id="cNick"><%= list.get(i).getMemNick() %></td>
							<td width="700px"><%= list.get(i).getContent() %></td>
							<td width="250px"><%= list.get(i).getCreateDate() %></td>
						</tr>
					<% } %>
				<% } %>
			</table>
		</div>
	</div>
	
	<br><br><br>
	
		</div>
		<script>
		$(function(){
			$('#addComments').on('click', function(){
				var writer = '<%= loginMember.getMemNum() %>'; 
				var fbNo = <%= fb.getBoardNo() %>;
				var content = $('#commentsContent').val();
				
				$.ajax({
					url: 'insertComments.fbo',
					data:{writer:writer, fbNo:fbNo, content:content},
					success: function(data){
						console.log(data);
						$commentsTable = $('#commentsSelectTable');
						$commentsTable.html('');
						
						for(var key in data){
							var $tr = $('<tr>');
							var $writerTd = $('<td>').text(data[key].memNick).css('width', '100px');
							var $contentTd = $('<td>').text(data[key].content).css('width', '700px');
							var $dateTd = $('<td>').text(data[key].createDate).css('width', '200px');
							
							$tr.append($writerTd);
							$tr.append($contentTd);
							$tr.append($dateTd);
							$commentsTable.append($tr);
						}
						
						$('#commentsContent').val('');
					}
				});
			});
		});
		
			$('#deleteNoBtn').on('click', function(){
				var bool = confirm('정말 삭제하시겠습니까?');
				
				if(bool){
					location.href='<%= request.getContextPath() %>/delete.fbo?fbNo=' + <%= fb.getBoardNo() %>;
				}
			})
		</script>
	</div>
</body>
</html>