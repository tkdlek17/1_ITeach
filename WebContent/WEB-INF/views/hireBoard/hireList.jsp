<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, hire.model.vo.*"%>
<%
	ArrayList<Hire> list = (ArrayList<Hire>)request.getAttribute("list");	
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
<style type="text/css">
#listArea{border: 2px solid lightgray; border-collapse:collapse; text-align: center;}
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
	
	#searchtext{height: 30px;}
	.tableArea{width:1100px; height:600px; margin:auto;}
	.nt{background: rgb(75, 148, 242); color: #F2F2F2; border: 2px solid lightgray;}
	.nd{border: 2px solid lightgray;}
	#btnarea{margin-top: 10px;}
	#writeFboBtn{
		background: rgb(75, 148, 242); margin-right: 5px; margin-bottom: 80px;
		color: white; font-weight: bold; width: 80px; height: 30px;	
	}
	#searchBtn{
		background: skyblue;
		color: white; font-weight: bold; width: 80px; height: 30px;	
		padding: auto;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	.pagingArea button{border-radius: 5px; background: #D5D5D5; width: 25px; height: 25px; font-weight: bold;}
	button:hover{cursor: pointer;}
	#numBtn{background: rgb(75, 148, 242);}
	#choosen{background: skyblue;}
	select{font-weight: bold; width: 100px; height: 34px;}
	
	.btnarea {margin-left:auto; margin-right:auto; width:150px;}
	#insertBtn {margin-left:auto; margin-right:auto; width:150px;}
	
	#insertBtn{
		padding: 5px;
		font-size:16px;color:#fff;border:1px solid #0554f2;border-radius:2em;background:#0554f2; letter-spacing:-0.8px; font-weight:bold;
	}
	#insertBtn:hover, #searchBtn:hover{background:#fff;color:#0554f2;}
	
	
	
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" id="fb" onclick="location.href='list.hire'">구인구직</th>
				<%if(loginMember != null) {%>
				<th class="ts" onclick="location.href='writeHireForm.hire'">채용등록</th>
				<%} %>
			</tr>
		</table>
	</div>
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">채용공고</th>
			</tr>
			<tr>
				<th id="c2">Home > 채용공고</th>
			</tr>
		</table>
	</div>
	
	<form action="<%= request.getContextPath()%>/list.hire" method="get" >
	<div id="search" align="center">
		<select name="search">
			<option value="hireWriter">작성자</option>
			<option value="CompanyAd" selected>지역</option>
		</select>
		<input type="text" id="searchtext" size="50" name="searchtext" placeholder="검색">
		<button id="searchBtn">검색</button>
	</div>
	</form>
	
		<br>
		<div class="tableArea">
			<table id="listArea">
				<thead>
				<tr>
					<th class="nt" width="100px" height="40px;">글번호</th>
					<th class="nt" width="450px" height="40px;">회사명</th>
					<th class="nt" width="250px" height="40px;">지역</th>
					<th class="nt" width="150px" height="40px;">작성자</th>
					<th class="nt" width="200px" height="40px;">등록일</th>
					<th class="nt" width="100px" height="40px;">조회수</th>
				</tr>
				</thead>
				<tbody>
				<%if(list.isEmpty()) {%>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<%} else{%>
				<%		for(Hire h : list) {%>
				<tr>
					<td class="nd" height="40px;"><%=h.getHireNo()%></td>
					<td class="nd" height="40px;"><%=h.getHireCompany()%></td>
					<td class="nd" height="40px;"><%=h.getCompanyAddress()%>
					<td class="nd" height="40px;"><%=h.getWriter()%></td>
					<td class="nd" height="40px;"><%=h.getCreateDate()%></td>
					<td class="nd" height="40px;"><%=h.getViewCount()%></td>
				</tr>
				<%		} %>
				<%	} %>
				</tbody>
			</table>
			<br>
			<%if(loginMember != null) {%>
			<div class="btnarea" align="right">
				<button id="insertBtn" onclick="location.href='<%=request.getContextPath()%>/writeHireForm.hire'">작성하기</button>
			</div>
		<%} %>
		<br>
		</div>
		<br>
		<br>
		<!-- 페이징 -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.hire?currentPage=1'">&lt;&lt;</button>
			
			<!-- 이전으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.hire?currentPage=<%=currentPage - 1%>'" id="beforeBtn">&lt;</button>
			<script>
				if(<%=currentPage%> <= 1){
					var before = $('#beforeBtn');
					before.attr('disabled', true);
					//alert("첫 페이지 입니다.")
				}
			</script>
			
			<!-- 숫자 버튼 -->
			<%for(int p = startPage; p <= endPage; p++) {
				if(p == currentPage){
			%>
			<button id="choosen" disabled><%= p %></button>
			<%				
				} else {
			%>
			<button onclick="location.href='<%=request.getContextPath()%>/list.hire?currentPage=<%=p%>'" id="numBtn"><%= p %></button>
			<%
				}
			}
			%>
			
			<!-- 다음 페이지로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/list.hire?currentPage=<%=currentPage + 1%>'" id="afterBtn">&gt;</button>
			<script>
				if(<%=currentPage%> >= <%=maxPage%>){
					$('#afterBtn').attr('disabled', true);
					//alert("마지막 페이지 입니다");
				}
			
			</script>
			<!-- 맨 뒤로-->
			<button onclick="location.href='<%=request.getContextPath()%>/list.hire?currentPage=<%=maxPage%>'">&gt;&gt;</button>
		
		</div>
		<br>
		<br>
		
		<br>
		<br>
		
	</div>
	<script>
	
	
	$(function(){
		$('#listArea td').on({'mouseenter': function(){
			$(this).parent().css({'background' : 'lightgray', 'cursor' : 'pointer'});
		}, 'mouseout': function(){
			$(this).parent().css({'background' : 'none'});
		}, 'click': function(){
			<%if(loginMember != null){%>
				var num = $(this).parent().children().eq(0).text();
				location.href='<%=request.getContextPath()%>/detail.hire?no=' + num;
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