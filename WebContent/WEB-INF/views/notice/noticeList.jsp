<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, notice.model.vo.*" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
	#gg{color: rgb(75, 148, 242); border-bottom: 4px solid rgb(75, 148, 242);}
	#search{width: 100%; height: 30px; margin-top: 50px;}
	#notice_title{font-weight: bold;}
	.ot{
		width: 1000px; height: 400px; border: 2px solid gray;
		margin-left: auto; margin-right: auto; margin-top: 80px; margin-bottom: 10px;
	}
	#searchtext{height: 30px;}
	#listArea{text-align: center;}
	.tableArea{width:1100px; height:480px; margin:auto;}
	.nt{background: rgb(75, 148, 242); color: #F2F2F2; border: 2px solid lightgray;}
	.nd{border: 2px solid lightgray;}
	#btnarea{margin-top: 10px;}
	#writeNoBtn{
		background: rgb(75, 148, 242); margin:auto;
		color: white; font-weight: bold; width: 80px; height: 30px;	
		padding: auto;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	#searchBtn{
		background: skyblue;
		color: white; font-weight: bold; width: 80px; height: 30px;	
		padding: auto;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	button:hover{cursor: pointer;}
	.pagingArea button{border-radius: 5px; background: #D5D5D5; width: 25px; height: 25px; font-weight: bold;}
	#numBtn{background: rgb(75, 148, 242);}
	#choosen{background: skyblue;}
	select{font-weight: bold; width: 100px; height: 34px;}
	#writeNoBtn:hover, #searchBtn:hover{background:#fff;color:#0554f2;}
	
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" id="gg" onclick="location.href='list.no'">공지사항</th>
				<th class="ts" onclick="location.href='list.fbo'">자유글</th>
				<th class="ts" onclick="location.href='list.st'">스터디모집</th>
			</tr>
		</table>
	</div>
	
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">공지사항</th>
			</tr>
			<tr>
				<th id="c2">Home > 커뮤니티 > 공지사항</th>
			</tr>
		</table>
	</div>
	
	<form action="<%= request.getContextPath()%>/list.no" method="get" >
	<div id="search" align="center">
		<select name="search">
			<option value="notice_title" selected>제목</option>
		</select>
		<input type="text" id="searchtext" size="50" name="searchtext" placeholder="검색">
		<button id="searchBtn">검색</button>
	</div>
	</form>
	
	
<%--	<div class="ot" align="center"> --%>
		<br><br><br>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th class="nt" width="100px" height="40px;">번호</th>
					<th class="nt" width="550px" height="40px;">제목</th>
					<th class="nt" width="150px" height="40px;">작성자</th>
					<th class="nt" width="200px" height="40px;">등록일</th>
					<th class="nt" width="100px" height="40px;">조회수</th>
				</tr>
				<% if(list.isEmpty()){ %>
					<tr>
						<td colspan="5">존재하는 공지사항이 없습니다.</td>
					</tr>
				<% } else { 
						for(Notice n : list){ %>
						<tr>
							<td class="nd" height="40px;"><%= n.getNoticeNo() %></td>
							<td class="nd" height="40px;"><%= n.getNoticeTitle() %></td>
							<td class="nd" height="40px;"><%= n.getMemNick() %></td> 	
							<td class="nd" height="40px;"><%= n.getNoticeDate() %></td>
							<td class="nd" height="40px;"><%= n.getNoticeCount() %></td>
						</tr>
				<% 		} 
				   } %>
			</table>
	<div id="btnarea" align="right">
	 <% if(loginMember != null && loginMember.getMemId().equals("admin")){ %> 
				<input type="button" onclick="location.href='writeNoticeForm.no'" id="writeNoBtn" value="공지등록">
	 <% } %> 			
	</div>
		</div>
	<br><br><br><br>
		
		<!-- 페이징 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.no?currentPage=1'">&lt;&lt;</button>
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.no?currentPage=<%= currentPage - 1 %>'" id="beforeBtn">&lt;</button>
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
			<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.no?currentPage=<%= p %>'"><%= p %></button>
			<% 
				}
			}
			%>
			
			<!-- 다음 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.no?currentPage=<%= currentPage + 1 %>'" id="afterBtn">&gt;</button>
			<script>
				if(<%= currentPage %> >= <%= maxPage %>){
					$('#afterBtn').attr('disabled', true);
				}
			</script>
			<!-- 맨 뒤로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.no?currentPage=<%= maxPage %>'">&gt;&gt;</button>
		</div>
		<br><br><br>
<%-- 	</div>  --%>
	
	
	
	<script>
			$(function(){
					$('#listArea td').on({'mouseenter':function(){
						$(this).parent().css({'background' : 'lightgray', 'cursor':'pointer'});					
					}, 'mouseout':function(){
						$(this).parent().css('background', 'none');
					}, 'click':function(){
					<% if(loginMember != null){%>
						var num = $(this).parent().children().eq(0).text();
						location.href='<%= request.getContextPath() %>/detail.no?no=' + num;
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