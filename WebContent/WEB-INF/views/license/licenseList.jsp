<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, license.model.vo.*" %>
    
<%
	ArrayList<License> list = (ArrayList<License>)request.getAttribute("list");
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
	#licenseTitle, #licenseContent{font-weight: bold;}
	#searchtext{height: 30px;}
	#middle h1{padding: 10px;  text-align: center;}
	#listArea{text-align: center;}
	.tableArea{width:1100px; height:480px; margin:auto;}
	.lt{background: rgb(75, 148, 242); color: #F2F2F2; border: 2px solid lightgray;}
	.ld{border: 2px solid lightgray;}
	#btnarea{margin-top: 10px;}
	#updateBtn{
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
	#numBtn{background: rgb(75, 148, 242);}
	#choosen{background: skyblue;}
	.pagingArea button{border-radius: 5px; background: #D5D5D5; width: 25px; height: 25px; font-weight: bold; border: 0px;}
	button:hover{cursor: pointer;}
	#updateBtn:hover, #searchBtn:hover{background:#fff;color:#0554f2;}
</style>
</head>
<body>
	<%@ include file = "../common/menuBar.jsp" %>
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" id="gg" onclick="location.href='list.li'">기출문제</th>
			</tr>
		</table>
	</div>
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
					<th id="c1">기출문제</th>
			</tr>
			<tr>
				<th id="c2">Home &gt; 기출문제</th>
			</tr>
		</table>
	</div>
	
	<br>
	<form action="<%= request.getContextPath() %>/list.li" method="get">
		<div class="searcharea" align="center">
			<select name="search">
				<option value="licenseTitle">종목</option>
				<option value="licenseContent">내용</option>
			</select>
			<input id="searchText" name="searchText" type="text" size="50" placeholder="내용을 입력하세요">
			<button id="searchBtn">검색</button>
		</div>
	</form>
	
	
	<br>
	<br>
	<div class="tableArea">
         <table id="listArea">
            <tr>
               <th class="lt" width="100px" height="40px;">글번호</th>
               <th class="lt" width="550px" height="40px;">글제목</th>
               <th class="lt" width="150px" height="40px;">작성자</th>
               <th class="lt" width="200px" height="40px;">등록일</th>
               <th class="lt" width="100px" height="40px;">조회수</th>
            </tr>
            <% if(list.isEmpty()) { %>
            <tr>
               <td colspan="5">조회된 리스트가 없습니다.</td>
            </tr>
            <% } else {  %>
            	<% for(License l : list) { %>
		            <tr>
		               <td class="nt" height="40px;"><%= l.getLicenseNo() %></td>
		               <td class="nt" height="40px;"><%= l.getLicenseTitle() %></td>
		               <td class="nt" height="40px;"><%= l.getMemNick() %></td>
		               <td class="nt" height="40px;"><%= l.getCreateDate() %></td>
		               <td class="nt" height="40px;"><%= l.getLicenseView() %></td>
		            </tr>
		            
         		  <% } %>
        	<% } %>
         </table>
         <% if(loginMember != null) { %>
         <div id="btnarea" align="right">
			<button type="submit" id="updateBtn" onclick="location.href='<%= request.getContextPath() %>/writeLicenseForm.li'">작성하기</button>
         </div>
         <% } %>
         <!-- 페이징 -->
         <div class="pagingArea" align="center">
         
         	<!-- 이전 페이지 -->
         	<button onclick="location.href='<%= request.getContextPath() %>/list.li?currentPage=1'">&lt;&lt;</button>
         	<button onclick="location.href='<%= request.getContextPath() %>/list.li?currentPage=<%= currentPage - 1 %>'" id="before">&lt;</button>
        	<script>
	        	if(<%= currentPage %> <= 1){
	        		var before = $('#before');
	        		before.attr('disabled', true);
	        	}
        	</script>
        	
        	
        	<!-- 숫자 버튼 -->
        <% for(int p = startPage; p <= endPage; p++) { 
            	if(p == currentPage){
         %>
        	 <button id='choosen' disabled><%= p %></button> 
         <% // 해당 번호일 경우에는 넘어가지 않게 설정
           		 } else {
         %>
           	 <button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.li?currentPage=<%= p %>'"><%= p %></button>
         <%   
            	}
       	  }
         %>
			
			<!-- 다음 페이지 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.li?currentPage=<%=currentPage + 1 %>'" id="after">&gt;</button>   
			<script>
				if(<%= currentPage %> >= <%= maxPage %>){
					var after = $('#after');
					after.attr('disabled', true);
				}
			</script>  
			<button onclick="location.href='<%= request.getContextPath() %>/list.li?currentPage=<%= maxPage %>'">&gt;&gt;</button>
         </div>
      </div>
	<br><br><br>
	
	<%@ include file = "../common/footer.jsp" %>
	
	<script>
		$(function(){
			$('#listArea td').on({'mouseenter' : function(){
				$(this).parent().css({'background' : 'lightgray', 'cursor' : 'pointer'});
			}, 'mouseout' : function(){
				$(this).parent().css('background', 'none');
			}, 'click' : function(){
				<%if(loginMember != null) {%>
				var num = $(this).parent().children().eq(0).text();
				location.href='<%= request.getContextPath() %>/detail.li?li=' + num;
				<%} else if(loginMember == null){%>
				alert("상세 게시글은 회원만 조회가 가능합니다.");
				location.href = '<%= request.getContextPath()%>/Login.me';
				<% }%>
			}});
		});
		
	
	</script>
	
</body>
</html>