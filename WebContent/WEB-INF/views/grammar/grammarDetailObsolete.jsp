<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="question.model.vo.Board, java.util.ArrayList, question.model.vo.Attachment"%>
<%
	Board board = (Board) request.getAttribute("board");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
%>
<%@ include file="/WEB-INF/views/common/menuBar.jsp"%>
<div class="container text-center subcolor">
	<div class="jumbotron">
		<br>
		<h1 class="display-4 px-2">프로그래밍 문법</h1>
		<p class="lead px-2">프로그래밍 문법 </p> <%-- 카테고리를 받아와서 보여주는게 필요하다. --%>
		<br>
	</div>
</div>
<div class="container form-width">
	<br>
	<div id="question">
	<div id="title">
		<h4>제목 : <%=board.getBoardTitile()%>
		</h4>
	</div>
	<hr>
	<div id="writer">작성자 : <%=board.getNickName()%></div>
	<br>
	<div id="content">
	<p>
	<%=board.getBoardContent()%>
	</p>
	</div>
	<a href="<%=request.getContextPath()%>/updateForm.que?no=<%= board.getBoardNo()%>">수정하기</a>
	<a href="<%=request.getContextPath()%>/delete.gr?no=<%= board.getBoardNo()%>">삭제하기</a>
	</div>
</div>
<script>
   
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>