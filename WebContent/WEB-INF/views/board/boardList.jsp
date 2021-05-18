<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*"%>
<%
ArrayList<Fboard> list = (ArrayList<Fboard>)request.getAttribute("list");
PageInfo pi = (PageInfo)request.getAttribute("pi");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<style>
	#listArea{border: 2px solid lightgray; border-collapse:collapse;}
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
	#search{width: 100%; height: 30px; margin-top: 50px;}
	#lbl1{font-size: 20px; font-weight: bold;}
	.ot{
		width: 1100px; height: 550px; 
		margin-left: auto; margin-right: auto; margin-top: 80px; margin-bottom: 10px;
	}
	#searchtext{height: 30px;}
	#listArea{text-align: center;}
	.tableArea{width:1100px; height:480px; margin:auto;}
	.nt{background: rgb(75, 148, 242); color: #F2F2F2; border: 2px solid lightgray;}
	.nd{border: 2px solid lightgray;}
	#btnarea{margin-top: 10px;}
	#writeFboBtn{
		padding: 5px;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	#searchBtn{
		background: skyblue;
		color: white; font-weight: bold; width: 80px; height: 30px;	
		padding: auto;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	#writeFboBtn:hover, #searchBtn:hover{background:#fff;color:#0554f2;}
	.pagingArea button{border-radius: 5px; background: #D5D5D5; width: 25px; height: 25px; font-weight: bold;}
	button:hover{cursor: pointer;}
	#numBtn{background: rgb(75, 148, 242);}
	#choosen{background: skyblue;}
	select{font-weight: bold; width: 100px; height: 34px;}
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" onclick="location.href='list.no'">공지사항</th>
				<th class="ts" id="fb" onclick="location.href='list.fbo'">자유글</th>
				<th class="ts" onclick="location.href='list.st'">스터디모집</th>
			</tr>
		</table>
	</div>
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">자유글</th>
			</tr>
			<tr>
				<th id="c2">Home > 커뮤니티 > 자유글</th>
			</tr>
		</table>
	</div>
	
	<form action="<%= request.getContextPath()%>/list.fbo" method="get" >
	<div id="search" align="center">
		<select name="search">
			<option value="free_title" selected>제목</option>
			<option value="free_writer">작성자</option>
		</select>
		<input type="text" id="searchtext" size="50" name="searchtext" placeholder="검색">
		<button id="searchBtn">검색</button>
	</div>
	</form>
	
<%--    <div class="ot" align="center">  --%>
		<br><br><br>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th style="visibility:hidden;position:absolute;"></th>
					<th class="nt" width="100px" height="40px;">번호</th>
					<th class="nt" width="550px" height="40px;">제목</th>
					<th class="nt" width="150px" height="40px;">작성자</th>
					<th class="nt" width="200px" height="40px;">등록일</th>
					<th class="nt" width="100px" height="40px;">조회수</th>
				</tr>
				<% if(list.isEmpty()){ %>
					<tr>
						<td colspan="6">존재하는 게시글이 없습니다.</td>
					</tr>
				<% } else { 
						for(Fboard fb : list){ %>
						<tr>
							<td style="visibility:hidden;position:absolute;"><%= fb.getBoardNo() %></td>
							<td class="nd" height="40px;"><%= fb.getId() %></td>
							<td class="nd" height="40px;"><%= fb.getBoardTitle() %></td>
							<td class="nd" height="40px;"><%= fb.getMemNick() %></td> 	
							<td class="nd" height="40px;"><%= fb.getCreateDate() %></td>
							<td class="nd" height="40px;"><%= fb.getBoardView() %></td>
						</tr>
				<% 		} 
				   } %>
			</table>
	<div id="btnarea" align="right">
		<% if(loginMember != null){ %>  
				<button onclick="location.href='<%= request.getContextPath() %>/writeBoardForm.fbo'" id="writeFboBtn">글쓰기</button>
		 <% } %> 		
	</div>
		</div>
	<br><br><br><br>
	
		<!-- 페이징 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.fbo?currentPage=1'">&lt;&lt;</button>
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.fbo?currentPage=<%= currentPage - 1 %>'" id="beforeBtn">&lt;</button>
			<script>
				if(<%= currentPage %> <= 1){
					var before = $('#beforeBtn');
					before.attr('disabled', true);
				}
			</script>
			<!-- 숫자 버튼 -->
			<% 
			for(int p = startPage; p <= endPage; p++) {
				if(p == currentPage){
			%>
			<button id='choosen' disabled><%= p %></button>
			<% 		
				} else{
			%>
			<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.fbo?currentPage=<%= p %>'"><%= p %></button>
			<% 
				}
			}
			%>
			
			<!-- 다음 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.fbo?currentPage=<%= currentPage + 1 %>'" id="afterBtn">&gt;</button>
			<script>
				if(<%= currentPage %> >= <%= maxPage %>){
					$('#afterBtn').attr('disabled', true);
				}
			</script>
			<!-- 맨 뒤로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.fbo?currentPage=<%= maxPage %>'">&gt;&gt;</button>
		</div>
		<br><br><br>
<%--	</div>  --%>
	
	
	
	<script>
			$(function(){
				$('#listArea td').on({'mouseenter':function(){
					$(this).parent().css({'background' : 'lightgray', 'cursor':'pointer'});					
				}, 'mouseout':function(){
					$(this).parent().css({'background' : 'none'});
				}, 'click':function(){
				<% if(loginMember != null){%>
					var num = $(this).parent().children().eq(0).text();
					location.href='<%= request.getContextPath() %>/detail.fbo?fbNo=' + num;
				<%} else if(loginMember == null){ %>
					alert("상세 게시글은 회원만 조회가 가능합니다.");
					location.href = '<%= request.getContextPath()%>/Login.me';
				<%} %>
				}});
			});
	</script>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>