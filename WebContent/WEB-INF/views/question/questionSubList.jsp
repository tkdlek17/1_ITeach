<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, question.model.vo.Board, question.model.vo.PageInfo, common.model.vo.Category"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	ArrayList<Category> category = (ArrayList<Category>)request.getAttribute("categoryList");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
%>
<%@ include file="/WEB-INF/views/common/menuBar.jsp"%>
<div class="container text-center subcolor">
	<br>
	<div class="jumbotron">
		<h1 class="display-4">질문답변</h1>
		<p class="lead">질문/답변 > 질문</p>

	</div>
	<br>
</div>
<div class="container text-center">
<br>
<div class="row form-width">
	<div class="col-md-3"><a style="color:black;" href="<%=request.getContextPath()%>/list.que">전체</a></div>
	<% for(Category c: category){ %>
	<div class="col-md-3"><a style="color:black;" href="<%=request.getContextPath()%>/subList.que?no=<%=c.getCateNo()%>"><%=c.getCateName() %></a></div>
	<% } %>
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
				href="<%=request.getContextPath()%>/detail.que?no=<%=board.getBoardNo()%>"><%=board.getBoardTitile()%></a></td>
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
				onclick="location.href='<%=request.getContextPath()%>/insertForm.que'">작성하기</button>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>