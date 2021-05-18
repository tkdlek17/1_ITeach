<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="Book.model.vo.* , member.model.vo.Member"%>
 <% 
 	
 	Book book = (Book)request.getAttribute("book");
 	ArrayList<Files> files = (ArrayList<Files>)request.getAttribute("files");
 	Files img = files.get(0);
 	ArrayList<Comment> comment = (ArrayList<Comment>)request.getAttribute("comment");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js" ></script>

<style>
	body{width: 1100px; margin: auto; min-height: 1000px;} /* 너비 맞추고 가운데 정렬하기 */
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

	#bookinfo1{text-align:right; margin-right: 100px; min-width: 300px; height: 20px; font-size : 12px; }
	.no{display: inline-block; margin-left: 20px;}
	.writer{display: inline-block; margin-left: 20px;}
	.count{display: inline-block; margin-left: 20px;}
	
	
	#bookarea {width: 1000px; height: 450px; border: 1px solid black; 	margin-left:auto; margin-right:auto; text-align: center;  }
	#bookimg{width: 200px; height: 300px;  display: inline-block; vertical-align:top;  margin-top:20px; margin-right: 40px;}
	#bookinfo2{	width: 500px; height: 300px;  display: inline-block; margin-top:20px; text-align: left;}
	#bookinfo2 p {display: inline-block;}
	
	.title{font-size : 23px; font-weight: bold;  margin-left: 30px; }
	.author{font-size : 18px; margin-left: 30px; margin-top: 5px}
	.company{font-size : 18px; margin-left: 30px; margin-top: 5px}
	.content{font-size : 18px; margin-left: 30px; margin-top: 5px; line-height: 30px;}
	
	
	#addReply{margin-left:20px;color: white; font-weight: bold; width: 80px; height: 70px;font-size: 16px; border: 1px solid #0554f2;
    border-radius: 4px; background: #0554f2; letter-spacing: -0.8px;}
	#addReply:hover{background:#fff;color:#0554f2;}	
	
	#backBtn{color: white; font-weight: bold; width: 80px; height: 30px;font-size: 16px; border: 1px solid #0554f2;
    border-radius: 2em; background: #0554f2; letter-spacing: -0.8px;}
	#backBtn:hover{background:#fff;color:#0554f2;}	
	
	#likeBtn{color: white; font-weight: bold; width: 80px; height: 30px;font-size: 16px; border: 1px solid #0554f2;
    border-radius: 2em; background: #0554f2; letter-spacing: -0.8px;}
	#likeBtn:hover{background:#fff;color:#0554f2;}	
	
	
	#delBtn{color: white; font-weight: bold; width: 80px; height: 30px;font-size: 16px; border: 1px solid #0554f2;
    border-radius: 2em; background: #0554f2; letter-spacing: -0.8px;}
	#delBtn:hover{background:#fff;color:#0554f2;}	



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
					<th id="c2">Home > 추천IT서적 > 서적 상세페이지</th>
				</tr>
			</table>
		</div>
	  	<br>

	  	<br>
	  	<h3 align ="center">서적 상세 페이지</h3>
	  	<div id="bookinfo1">
		  	<p class="likeCount"> </p><br>
			<p class="no"> 글 번호 : <%= book.getBookNo() %> </p>
		  	<p class="count">조회수 : <%= book.getBookCount() %> </p>
		  	<p class="writer">작성자 : <%= book.getNickName() %> </p>
		</div>
				  	
		<br><br>
	  	<div id="bookarea"> 
	  		<br>
	  		<div id="bookimg">
	  		<img src="<%= request.getContextPath() %>/image_uploadFiles/<%=img.getChangeName()%>" width="200px" height="300" name="img">
	  		</div>
	  		
	  		<div id="bookinfo2">
	  			<input type="hidden" class="title" name ="title" value="<%= book.getBookTitle() %>"> 
	  			<p class="title">  <%= book.getBookTitle() %></p>
	  			<br><br>
				<input type="hidden"class="author" name ="author" value="<%= book.getBookAuthor()%>">
				<p class="author"><b>저자</b> <%= book.getBookAuthor()%></p>
				<br><br>
				<input type="hidden" class="company" name ="company"  value="<%= book.getBookCompany()%>">
				<p class="company"><b>출판사</b> <%= book.getBookCompany()%></p>
				<br><br>
				<input type="hidden" class="content" name ="content" value="<%= book.getBookContent() %>">
				<p class="content"><b>서적 내용</b> <%= book.getBookContent() %></p>
				<br><br>
				
	  		</div><br>
	  			
			
	  	</div>
	  	<br><br>
	  		<div id="BtnArea" align="center">
		  		<input type="button" id="backBtn" value="목록">
		  	<% if(loginMember != null && loginMember.getMemId().equals("admin")){ %> 
		  		<input type="button" id="delBtn" value="삭제">
		  	<%} %>
			  	<input type="button" id="likeBtn" value="추천">
	  		</div>	  	
	  		
		<br>
		

		<div class ="replyArea" align = "center">
			<div class="replyWriterArea"><!-- 댓글 작성 부분 -->
			<br><br>
				<table>
					<tr>
						<td><textarea rows = "3" cols ="90" id="replyContent" style="resize:none;"></textarea>
						<td ><button id="addReply">등록</button></td>
					</tr>
				</table>
			</div>
			
			<div id="replySelectArea"><!-- 댓글조회 부분 -->
				<table id ="replySelectTable" >
					
					<%if(comment.isEmpty()){ %>
						
						<tr><td colspan = "3">댓글이 없습니다. </td>
						<% } else { 
						for(int i = 0; i <comment.size(); i++) {
						%>
						</tr>
						<tr>
							<td width ="100px"><%=comment.get(i).getNickname()%></td>
							<td width ="400px"><%=comment.get(i).getContent() %></td>
							<td width ="200px"><%=comment.get(i).getCreateDate() %></td>
						</tr>
						
						<% } %>
					<% } %>
					
				</table>
				
			</div>		
    	</div>	
    <br><br>
    	
 	 <footer>
		<%@ include file = "../common/footer.jsp" %>
	</footer>
	  	
    	<script>
    	
    		$('#backBtn').on('click' , function(){
    			location.href= '<%=request.getContextPath()%>/bookListServlet';

    		});
    		$('#delBtn').on('click' , function(){
    			var msg = confirm('게시물을 삭제하시겠습니까?');
    			
    			if(msg) {
    				location.href='<%=request.getContextPath()%>/delete.book?no='+<%=book.getBookNo()%>;
    			}
    		})
    		
   	
    
    			$('#addReply').on('click' , function(){
	    				var writer = <%=loginMember.getMemNum()%>
	    				var bookNo = <%=book.getBookNo()%>
	    				var content = $('#replyContent').val();
	    				
    				$.ajax({
    					url : 'insertComment',
    					data : {writer:writer, bookNo : bookNo ,content : content},
    					success : function(data){
    						console.log(data);
    						$replyTable = $('#replySelectTable');
    						$replyTable.html('');
    						
    						for(var key in data){
    							var $tr = $('<tr>');
    							var $nickname =  $('<td>').text(data[key].nickname).css('width' , '100px');
    							var $content =  $('<td>').text(data[key].content).css('width' , '400px');
    							var $createdate =  $('<td>').text(data[key].createDate).css('width' , '200px');
    							
    							$tr.append($nickname);
    							$tr.append($content);
    							$tr.append($createdate);
    							$replyTable.append($tr);
    						}
    						$('#replyContent').val('');
    					}
    					
    				});
    			});
 

    		$(function() {
        		$('#likeBtn').on('click' , function(){
        			var bookNo = <%=book.getBookNo()%>
        			var memNo = <%=loginMember.getMemNum()%>
        			
    	    		$.ajax({
    	    			url : "likeCheck",
    	    			type : "get",
    	    			data : { bookNo : bookNo, memNo: memNo  },
    	    			success : function () {
    	    				BookLike();
    	    			},
    	    			
    	    		})
      			})
      		
      		function BookLike() {
        			var bookNo = <%=book.getBookNo()%>
    	    		$.ajax({
    	    			url : "countBookLike",
    	    			type : "get",
    	    			data : { bookNo : bookNo },
    	    			success : function(count) {
    	    			console.log(count);
    	    			
						
    	    			$("#likeBtn").attr("value" , "추천 " + count);
    	    		},
        		})
        		
	        };
	       	 BookLike(); 
	    	});
    		
    		
    		
    	</script>
		
		

		
		
		
</body>
</html>