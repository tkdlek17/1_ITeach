<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, question.model.vo.Board, question.model.vo.PageInfo, common.model.vo.Category"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
ArrayList<Category> category = (ArrayList<Category>) request.getAttribute("categoryList");
PageInfo pi = (PageInfo) request.getAttribute("pi");
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
%>
<%@ include file="/WEB-INF/views/common/menuBar.jsp"%>
<style>
#listArea {
	border: 2px solid lightgray;
	border-collapse: collapse;
}

.ts {
	width: 100px;
	font-size: 15px;
}

.ts:hover {
	cursor: pointer;
}

.www {
	background: white;
	width: 100%;
	height: 40px;
}

#mmm {
	background: white;
	text-align: center;
	vertical-align: middle;
	width: 50%;
	height: 40px;
}

.tA {
	width: 100%;
	height: 190px;
	background: rgb(19, 116, 242);
}

#lA {
	text-align: center;
	vertical-align: middle;
	width: 50%;
	height: 100px;
}

#c1 {
	font-size: 30px;
	color: white;
	font-weight: bold;
}

#c2 {
	color: white;
	font-weight: bold;
}

#gg {
	color: rgb(75, 148, 242);
	border-bottom: 4px solid rgb(75, 148, 242);
}

#search {
	width: 100%;
	height: 30px;
	margin-top: 50px;
}

#notice_title {
	font-weight: bold;
}

.ot {
	width: 1000px;
	height: 400px;
	border: 2px solid gray;
	margin-left: auto;
	margin-right: auto;
	margin-top: 80px;
	margin-bottom: 10px;
}

#searchtext {
	height: 30px;
}

#listArea {
	text-align: center;
}

.tableArea {
	width: 1100px;
	height: 480px;
	margin: auto;
}

.nt {
	background: rgb(75, 148, 242);
	color: #F2F2F2;
	border: 2px solid lightgray;
}

.nd {
	border: 2px solid lightgray;
}

#btnarea {
	margin-top: 10px;
}

#writeNoBtn {
	background: rgb(75, 148, 242);
	margin: auto;
	color: white;
	font-weight: bold;
	width: 80px;
	height: 30px;
	padding: auto;
	font-size: 16px;
	color: #fff;
	border: 1px solid #0554f2;
	border-radius: 2em;
	background: #0554f2;
	letter-spacing: -0.8px;
	font-weight: bold;
}

#searchBtn {
	background: skyblue;
	color: white;
	font-weight: bold;
	width: 80px;
	height: 30px;
	padding: auto;
	font-size: 16px;
	color: #fff;
	border: 1px solid #0554f2;
	border-radius: 2em;
	background: #0554f2;
	letter-spacing: -0.8px;
	font-weight: bold;
}

button:hover {
	cursor: pointer;
}

.pagingArea button {
	border-radius: 5px;
	background: #D5D5D5;
	width: 25px;
	height: 25px;
	font-weight: bold;
}

#numBtn {
	background: rgb(75, 148, 242);
}

#choosen {
	background: skyblue;
}

select {
	font-weight: bold;
	width: 100px;
	height: 34px;
}

#writeNoBtn:hover, #searchBtn:hover {
	background: #fff;
	color: #0554f2;
}
</style>
<div class="www" align="center">

	<table id="mmm">
		<tr>
			<th class="ts" id="gg" href="<%=request.getContextPath()%>/list.que">질문/답변</th>
			<th class="ts" id="fb" href="<%=request.getContextPath()%>/main.gr">프로그래밍 문법</th>
		</tr>
	</table>
</div>

<div class="tA" align="center">
	<br> <br>
	<table id="lA">
		<tr>
			<th id="c1">질문/답변</th>
		</tr>
		<tr>
			<th id="c2">Home > 질문/답변 > 질문/답변</th>
		</tr>
	</table>
</div>
<br>
<br>
<br>
<div style="text-align: center;">
	<form action="<%=request.getContextPath()%>/list.que?">
		<select name="searchMethod">
			<option value="1">제목</option>
			<option value="2">제목+내용</option>
		</select>
		<%
			if (request.getAttribute("categoryNo") != null) {
		%>
		<%
			String categoryNo = request.getAttribute("categoryNo").toString();
		%>
		<input type="hidden" name="categoryNo" value="<%=categoryNo%>">
		<%
			}
		%>
		<input type="text" name="searchText">
		<button id="searchBtn">검색</button>
	</form>
</div>
<br>
<br>
<br>
<div class="tableArea">
	<table id="listArea">
		<tr>
			<th class="nt" width="100px" height="40px;">번호</th>
			<th class="nt" width="550px" height="40px;">제목</th>
			<th class="nt" width="150px" height="40px;">작성자</th>
			<th class="nt" width="200px" height="40px;">등록일</th>
			<th class="nt" width="100px" height="40px;">조회수</th>
		</tr>
		<%
			if (list.isEmpty()) {
		%>
		<tr>
			<td colspan="5">게시글이 없습니다.</td>
		</tr>
		<%
			} else {
		%>
		<%
			for (Board board : list) {
		%>
		<tr href="<%=request.getContextPath()%>/detail.que?no=<%=board.getBoardNo()%>">
			<td class="nd" height="40px;"><%=board.getId()%></td>
			<td class="nd" height="40px;"><%=board.getBoardTitile()%></td>
			<td class="nd" height="40px;"><%=board.getNickName()%></td>
			<td class="nd" height="40px;"><%=board.getBoardCreateAt()%></td>
			<td class="nd" height="40px;"><%=board.getBoardView()%></td>
		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
</div>
<!--  페이징  -->
<div class="pagingArea" align="center">
	<!-- 맨 처음으로 -->
	<button
		onclick="location.href='<%=request.getContextPath()%>/list.no?currentPage=1'">&lt;&lt;</button>
	<button
		onclick="location.href='<%=request.getContextPath()%>/list.que?currentPage=<%=currentPage - 1%>'"
		id="beforeBtn">&lt;</button>
	<%
		for (int i = pi.getStartPage(); i <= pi.getEndPage(); i++) {
	%>
	<%
		if (i == currentPage) {
	%>
	<button id="chosen" diabled><%=currentPage%></button>
	<%
		} else {
	%>
	<button id="numBtn"
		onclick="location.href='<%=request.getContextPath()%>/list.que?currentPage=<%=i%>'"><%=i%></button>
	<%
		}
	%>
	<%
		}
	%>
	<!-- 다음 페이지로 -->
	<button
		onclick="location.href='<%=request.getContextPath()%>/list.que?currentPage=<%=currentPage + 1%>'"
		id="afterBtn">&gt;</button>
	<script>
		if (
	<%=currentPage%>
		>=
	<%=maxPage%>
		) {
			$('#afterBtn').attr('disabled', true);
		}
	</script>
	<!-- 맨 뒤로 -->
	<button
		onclick="location.href='<%=request.getContextPath()%>/list.que?currentPage=<%=pi.getMaxPage()%>'">&gt;&gt;</button>
	<%
		if (loginMember != null) {
	%>
	&nbsp;<input type="button"
		onclick="location.href='<%=request.getContextPath()%>/insertForm.que'"
		id="writeNoBtn" value="작성하기">
	<%
		}
	%>
</div>
<br>
<script>
			$(function(){
					$('#listArea td').on({'mouseenter':function(){
						$(this).parent().css({'text-decoration':'underline', 'cursor':'pointer'});					
					}, 'mouseout':function(){
						$(this).parent().css('text-decoration', 'none');
					}});
			});
			
			
			$(document).ready(function(){
			    $('table tr').click(function(){
			        window.location = $(this).attr('href');
			        return false;
			    });
			});
			
			$(document).ready(function(){
			    $('table th').click(function(){
			        window.location = $(this).attr('href');
			        return false;
			    });
			});
	</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>