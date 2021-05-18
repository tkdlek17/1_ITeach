<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="question.model.vo.Board, java.util.ArrayList, question.model.vo.Attachment"%>
<%
	Board board = (Board) request.getAttribute("board");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
<%@ include file="/WEB-INF/views/common/menuBar.jsp"%>
<style>
	
	.tA{width: 100%; height: 190px; background: rgb(19, 116, 242); }
	#lA{text-align: center; vertical-align: middle; width: 50%; height: 100px;}
	#c1{font-size: 30px; color: white; font-weight: bold;}
	#c2{color: white; font-weight: bold;}
	
	#listArea{border: 2px solid lightgray; border-collapse:collapse;}
	.ts{width: 100px; font-size: 15px;}
	.ts:hover{cursor: pointer;}
	.www{background: white; width: 100%; height: 40px;}
	#mmm{
		background: white; text-align: center;
		vertical-align: middle; width: 50%; height: 40px;
	}
	.container-min {
		min-height: 480px;
	}
	
	.list-min {
		min-height: 400px;
	}
	.sub-color {
	 background: rgb(19, 116, 242); 
	 color: white;
	 }
	 
	 .gram-item {
	 color: black;
	 }
	 
	 .text-style{color: darkgray; font-weight: bold;}
	 
	 #gg {
	color: rgb(75, 148, 242);
	border-bottom: 4px solid rgb(75, 148, 242);
}

</style>
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" onclick="location.href='<%=request.getContextPath()%>/list.que'">질문/답변</th>
				<th class="ts" id="gg" onclick="location.href='<%=request.getContextPath()%>/main.gr'">프로그래밍 문법</th>
			</tr>
		</table>
	</div>
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">질문/답변</th>
			</tr>
			<tr>
				<th id="c2">Home > 질문/답변 > 프로그래밍 문법 </th>
			</tr>
		</table>
	</div>
	<br>
	<br>
<div>
	<div class="row">
	<div class="col-4">
		<div style="width:100%; font-weight: bold;" class="display-6 sub-color py-2 text-center">목록</div>
		<ul class="py-3 bg-light list-min" >
			<% for (Board b: list) {%>
			<li><a href="<%=request.getContextPath()%>/detail.gr?no=<%= b.getBoardNo() %>" class="gram-item h4 text-style"><%=b.getBoardTitile() %></a></li>
			<% } %>
		</ul>
	</div>
	<div class="col-8">
		<div>
		<h2 class="text-center text-style"><b><%= board.getBoardTitile() %></b></h2>
		<br>
		<div class="lead text-style"><%= board.getBoardContent() %></div>
		</div>
		
	</div>
	</div>
</div>
	<div class="text-center">
		<% if(loginMember != null && loginMember.getIsStaff().equals("Y")){ %>
			<button id="updateBtn" class="btn btn-primary" type="button" onclick="location.href='<%=request.getContextPath()%>/updateForm.gr?no=<%=board.getBoardNo()%>';" >수정</button>
			<button id="deletBtn" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/delete.gr?no=<%=board.getBoardNo()%>'">삭제</button>
		<% } %>
	</div>
<br>
<script>
  
   
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>