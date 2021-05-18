<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, question.model.vo.Board, question.model.vo.PageInfo"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
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
</style>
<div class="container text-center subcolor">
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" onclick="location.href='list.que'">질문/답변</th>
				<th class="ts" id="fb" onclick="location.href='<%=request.getContextPath()%>/main.gr'">프로그래밍 문법</th>
			</tr>
		</table>
	</div>
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">프로그래밍 문법</th>
			</tr>
			<tr>
				<th id="c2">Home > 질문/답변 > 프로그래밍 문법</th>
			</tr>
		</table>
	</div>
	<br>
</div>
<div class="container text-center row">
	<table class="col">
		<thead>
			<tr>
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<%
			for (Board board : list) {
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a class="text-dark"
				href="<%=request.getContextPath()%>/detail.gr?no=<%=board.getBoardNo()%>"><%=board.getBoardTitile()%></a></td>
			<td><%=board.getNickName()%></td>
			<td><%=board.getBoardCreateAt()%></td>
			<td><%=board.getBoardView()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<div class="row">
		<div class="col">
			<a id="toBeforePage">&lt;&lt;</a> <a id="toBeforePage">&lt;</a>
			<%
				for (int i = pi.getStartPage(); i <= pi.getEndPage(); i++) {
			%>
			<a class="text-dark"
				href="<%=request.getContextPath()%>/list.que?currentPage=<%=i%>"><%=i%></a>&nbsp;
			<%
				}
			%>
			<a id="toNextPage">&gt;</a> <a id="toNextPage">&gt;&gt;</a>
			<button class="float-right" type="button"
				onclick="location.href='<%=request.getContextPath()%>/insertForm.gr'">작성하기</button>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>