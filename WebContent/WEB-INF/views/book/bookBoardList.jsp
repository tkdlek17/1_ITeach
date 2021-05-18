<%@page import="java.util.ArrayList, Book.model.vo.Files, Book.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
  
 <%
 	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
 	int listCount = pi.getListCount();
 	int currentPage = pi.getCurrentPage();
 	int maxPage = pi.getMaxPage();
 	int startPage = pi.getStartPage();
 	int endPage = pi.getEndPage();
 	
 	System.out.println(pi);
 			
 	ArrayList<Files> files = (ArrayList<Files>)request.getAttribute("files");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
	body{width: 1100px; margin: auto;} /* 너비 맞추고 가운데 정렬하기 */
	
	/* **************** middle *********************** */
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
	
	
	select{font-weight: bold; width: 100px; height: 34px;}
	.search{width: 100%; height: 30px; margin-top: 50px;}
	#searchtext{height: 30px;}
	#searchBtn{
    color: white;
    font-weight: bold;
    width: 80px;
    height: 30px;
    font-size: 16px;
    border: 1px solid #0554f2;
    border-radius: 2em;
    background: #0554f2;
    letter-spacing: -0.8px;}
    
	#searchBtn:hover{background:#fff;color:#0554f2;}	
	#bookarea{width: 1000px; min-height:500px;  margin-left: 80px ; margin-right:auto;  } 
	
	.bookimage{min-width: 100px; min-height: 100px; display: inline-block; vertical-align:top; }
	.bookdetail{width : 460px; min-height: 200px; display: inline-block;
		position: relative; border: 1px solid gray; margin-top: 20px; margin-right: 5px; margin-left: 5px}
	
	.bookinfo{ margin-left : 30px; display: inline-block; width: 260px; height: 200px; position: relative; }
	
	p.no {display: inline-block; font-size: 14px; margin-top: 10px}
	P.title {
    font-size: 18px;
    font-weight: bold;
    display: -webkit-box;
    position: relative;
    overflow: hidden;
    text-overflow: ellipsis;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;

    }
	p.author{ font-size : 15px; position: absolute; margin-bottom: 10px;}
	p.company{font-size : 15px; position: absolute; margin-top: 30px; }
	p.content{
	 margin-top: 80px; font-size : 15px;
    display: -webkit-box;
    position:relative;
    overflow: hidden;
   
    height: 40px; 
    line-height: 20px; /*라인 높이*/
    text-overflow: ellipsis; /*글줄임표시*/
    word-wrap: break-word;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;}
	
	#writerbookBtn{ color: white; font-weight: bold; width: 80px; height: 30px;font-size: 16px; border: 1px solid #0554f2;
    border-radius: 2em; background: #0554f2; letter-spacing: -0.8px;}
	#writerbookBtn:hover{background:#fff;color:#0554f2;}	
	
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	#listArea{text-align: center;}
	.tableArea{width:650px;  height:350px; margin-left:auto; margin-right:auto;}
	th{border-bottom: 1px solid grey;}
	
	#numBtn{background: rgb(75, 148, 242);}
	#choosen{background: skyblue;}
	.pagingArea button{border-radius: 5px; background: #D5D5D5; width: 25px; height: 25px; font-weight: bold; border: 0px;}

	
	button:hover{cursor: pointer;}
	

</style>
</head>

<body>
		<%@ include file="../common/menuBar.jsp" %>
	  	
	  	<div class="www" align="center">

			<table id="mmm">
				<tr>
					<th class="ts" id="gg" onclick="location.href='bookListServlet'">추천 IT서적</th>
				</tr>
			</table>	
		</div>
	
	
		<div class="tA" align="center"><br><br>
			<table id="lA">
				<tr>
					<th id="c1">추천IT서적</th>
				</tr>
				<tr>
					<th id="c2">Home > 추천IT서적 </th>
				</tr>
			</table>
		</div>
	  	

	  	<form action="<%= request.getContextPath()%>/bookListServlet" method="get" ><br><br>
	  	<div id= "search" align="center">
	  	<select name = "search">
	  		<option value="book_title">제목</option>
	  		<option value="book_content" >내용</option>
	  		<option value="book_author">저자</option>
	  	</select>
	  	<input id ="searchtext" name="searchtext"  type ="text" size= 50 placeholder = "검색">
	  	<button id="searchBtn">검색</button>
	  	</div>
	  	</form>
	  	
	  	<br><br>
	  	
		<div id ="bookarea" >
		
						<%if (list.isEmpty() ){ %>
							<p> 존재하는 게시물이 없습니다.</p>
						<% } else {
								for(Book book : list ) {   %>
								<div  class = "bookdetail">
									<div class = "bookimage">
										<%for (int j =0; j< files.size(); j++){ %>
											<% Files f = files.get(j); %>
											<%if(book.getBookNo() == f.getBookNo()) {%>
										<img src= "<%= request.getContextPath() %>/image_uploadFiles/<%= f.getChangeName() %>" width="150" height="215">
										<%} %>
									<%} %>
									</div>
									
									<div class="bookinfo">
										No.<p class= "no"><%=book.getBookNo()%></p><br>
										<p class="title"> <%= book.getBookTitle()%></p>
										<p class="author"><b>저자</b>  <%= book.getBookAuthor()%></p>
										<p class="company"><b> 출판사</b>  <%= book.getBookCompany()%></p>
										<p class="content"><b>책 소개</b>
										 <%= book.getBookContent()%></p>
									</div>
								</div>
							<% }%>
						<% }%>
				

		</div>
		<br>
		
		<!-- 페이징 -->
		<div class ="pagingArea" align="center">
		<!--  맨 처음으로 -->
	
		<button onclick ="location.href='<%= request.getContextPath()%>/bookListServlet?currentPage=1'"> &lt;&lt; </button>
		<!-- 이전 페이지 -->
		<button onclick="location.href='<%= request.getContextPath()%>/bookListServlet?currentPage=<%= currentPage-1 %>'" id="beforeBtn">&lt;</button>
		
		<script>
			if(<%= currentPage %> <=1 ){
				var before = $('#beforeBtn');
				before.attr('disabled', true);
			}
		</script>
		
		<!-- 숫자 버튼 -->
		<%
		for (int p= startPage; p <=endPage; p++){
			if(p ==  currentPage){
		%>		
			<button id="choosen" disabled><%= p %></button>
		<%
			}else {
		%>	
			<button id="numBtn" onclick ="location.href='<%=request.getContextPath() %>/bookListServlet?currentPage=<%=p %>'"><%= p %></button>
		<% }
		}
		%>
		
		<!--  다음페이지  -->
		<button onclick="location.href='<%= request.getContextPath()%>/bookListServlet?currentPage=<%= currentPage + 1 %>'" id="afterBtn">&gt;</button>
		<script>
			if(<%= currentPage %> >= <%= maxPage%> ){
				var before = $('#afterBtn');
				before.attr('disabled', true);
			}
		</script>
		<!-- 맨 끝으로 -->
		<button onclick ="location.href='<%= request.getContextPath()%>/bookListServlet?currentPage=<%=maxPage%>'">&gt;&gt;</button>
		</div>
		
		
	
		<br>
		<% if(loginMember != null && loginMember.getMemId().equals("admin")){ %> 
		<div id="writeBtnArea" align="center">
			<button onclick="location.href='bookWriteForm.bo'" id= "writerbookBtn">작성하기</button> 
		</div>
		<%} %>
	
	<br>

	<footer>
	<%@ include file = "../common/footer.jsp" %>
	</footer>
	
	
	<script>
	

    
	$(function(){
		$('.bookinfo').on('mouseenter', function(){
			$(this).css('cursor' , 'pointer');
		});
		
		
		$('.bookinfo').on( 'click' , function(){
		<% if(loginMember == null){ %> 
			alert("상세 게시글은 회원만 조회가 가능합니다.");
			location.href = '<%= request.getContextPath()%>/Login.me';
		<%} %>
		});
		
		$('.bookinfo').on( 'click' , function(){
		<% if(loginMember != null){%>
			var num = $(this).children().eq(0).text();
			console.log(num);
			location.href = '<%= request.getContextPath()%>/bookDetail.bo?no='+num;
		<%} %>
		});
	});
	</script>
</body>

</html>
	  	 