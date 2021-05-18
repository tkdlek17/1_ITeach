<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, java.util.HashMap, java.util.Set, question.model.vo.Board, question.model.vo.PageInfo"%>
<%
	HashMap<String, ArrayList<Board>> map = (HashMap<String, ArrayList<Board>>) request.getAttribute("map");
PageInfo pi = (PageInfo) request.getAttribute("pi");
%>
<%@ include file="/WEB-INF/views/common/menuBar.jsp"%>
<style>
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
<main role="main">
	<div class="album py-5">
		<div class="mx-5">

			<div class="row">
				<%
					for (String key : map.keySet()) {
				%>
				<div class="col-md-4">
					<div class="card mb-4 box-shadow">
							
						
						<div class="card-body">
						
							<div class="card-title">
								<a href="#" id="grammar-title"><b><%=key%></b></a>
							</div>
							<%
								ArrayList<Board> list = map.get(key);
							%>
							<%
								for (Board board : list) {
							%>
							<div class="card-text">
									<a  id="grammar-list-item" class=""
									href="<%=request.getContextPath()%>/detail.gr?no=<%=board.getBoardNo()%>"><%=board.getBoardTitile()%></a>
							</div>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<div id="btnarea" align="center">
		<% if(loginMember != null && loginMember.getMemId().equals("admin")){ %>
			<input type="button"
		onclick="location.href='<%=request.getContextPath()%>/insertForm.gr'"
		id="writeNoBtn" value="작성하기" class="center">
		<% } %>
		
		</div>
	</div>
</main>
<%-- <div class="container row justify-content-center">
	<div class="d-flex justify-content-center align-items-center">
	<div class="row">
	<% for(String key: map.keySet()){ %>
		<div class="col-md-6 card">
		<div class="card-body">
		<h5 class="card-title">
		<span><a>더보기</a></span>
		</h5>		
		
		<br>
		<% for(Board board: list){ %>
		<div class="card-text">
		<a href="<%=request.getContextPath() %>/detail.gr?no=<%= board.getBoardNo()%>"><%= board.getBoardTitile() %></a>
		</div>
		<% } %>
		</div>
		</div>		
	
	</div>
	</div>
</div> --%>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>