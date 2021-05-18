<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, common.model.vo.Category, question.model.vo.Board" %>
    <% 
    	ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList"); 
    	Board board = (Board)request.getAttribute("board");
    %>
<%@ include file="/WEB-INF/views/common/menuBar.jsp"%>
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
	<div class="container form-width">
	
	<form class="form" method="post" action="<%=request.getContextPath() %>/update.gr">
		<input type="hidden" name="no" value="<%= board.getBoardNo() %>">
		<label>제목</label><input type="text" name="title" class="form-control" value="<%= board.getBoardTitile() %>">
		<label>카테고리 : </label><br>
		<select id="categorySelect" name="category" class="form-control">
			<% for(Category c : categoryList){ %>
				<option value="<%= c.getCateNo() %>" <% if(c.getCateNo() == board.getCateNum()) { %>selected<% } %>><%= c.getCateName() %></option>
			<% } %>
		</select><br>
		<label>내용</label><textarea name="content" rows="10" cols="100" class="form-control"><%=board.getBoardContent() %></textarea>
		<button type="submit" class="btn btn-primary">제출</button>&nbsp;<button type="reset" class="btn btn-secondary">초기화</button>
		<a href="<%=request.getContextPath()%>/update.gr?no=<%=board.getBoardNo()%>">수정하기</a>
	</form>
	</div>
	<script>
		
	</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>