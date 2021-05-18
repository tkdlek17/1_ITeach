<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Book.model.vo.*"%>
 
 <% Book b= (Book)request.getAttribute("b");
 	String img =(String)request.getAttribute("img");
 	%>
 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>

<style>
	body{width: 1100px; margin: auto; min-height: 500px;} /* 너비 맞추고 가운데 정렬하기 */
	#middle{background: #1374F2; height: 200px; }
	#middle h3{color: white; text-align: center;}
	#middle h5{color: white; text-align: center; width: 100%; margin-top: 80px;}



	#bookarea {width: 1000px; height: 450px; border: 1px solid black; 	margin-left:auto; margin-right:auto; text-align: center;  }
	#bookimg{	width: 200px; height: 300px; border: 1px solid black; display: inline-block; vertical-align:top;  margin-top:20px;}
	#bookinfo{	width: 500px; height: 300px; border: 1px solid black; display: inline-block; margin-top:20px; text-align: left;}
	
	.title{font-size : 20px; font-weight: bold;  margin-top: 30px; margin-left: 10px}
	.writer{font-size : 15px; margin-left: 10px; margin-top: 10px}
	.company{font-size : 15px; margin-left: 10px; margin-top: 25px}
	.content{font-size : 15px; margin-left: 10px; margin-top: 25px}
	.recommend{font-size : 15px; margin-left: 10px; margin-top: 25px}
	.count{font-size : 12px;margin-left: 420px;margin-top: 15px }
	#addReply{background: rgb(75, 148, 242); border: 0px;border-radius: 4px;  font-size : 13px; color: white;
	width: 80px;height: 48px;  margin-left: 10px;}
	#likeBtn{background: rgb(75, 148, 242); border: 0px;border-radius: 10px;  font-size : 13px; color: white; width: 80px;height: 30px;}
	#backBtn{background: rgb(75, 148, 242); border: 0px;border-radius: 10px;  font-size : 13px; color: white; width: 80px;height: 30px;}
	#modiBtn{background: rgb(75, 148, 242); border: 0px;border-radius: 10px;  font-size : 13px; color: white; width: 80px;height: 30px;}
	#delBtn{background: rgb(75, 148, 242); border: 0px;border-radius: 10px;  font-size : 13px; color: white; width: 80px;height: 30px;}
</style>

</head>
<body>
		<%@ include file="../common/menuBar.jsp" %>

		<div id = "middle">
	  	 	<h3> 추천IT서적</h3><br>
	  	 	<h5> !Teach > 추천IT서적 </h5>
	  	</div>
	  	<br><br><br>
	  	<hr><br>
	  	<h3 align ="center">서적 수정 페이지</h3>
	  	<br><br>
	<form action = "<%= request.getContextPath()%>/updatebook.bo" method="post" encType="multipart/form-data">
	  	<div id="bookarea"> 
	  		<p class="count">조회수 : </p>
	  		<div id="bookimg">
	  		<img src="" width="200px" height="300" >
	  		</div>
	  		
	  		<div id="bookinfo">
	  			<br>
	  			제목  : <input type="text" name ="title" value="<%=b.getBookTitle()%>"><br><br>
				저자 : <input type="text" name ="writer"><br><br>
				출판사 :  <input type="text" name ="company"><br><br>
				책 내용 : <textarea rows="3" cols="30"></textarea><br><br>
				추천 이유 : <textarea rows="3" cols="30"></textarea>
	  	
	  		</div>
	  		<br><br>
	  		<button id="backBtn" >목록</button>
	  		<button type="submit" id="modiBtn">수정하기</button>
	  		
	  	
	  	</div>
		
		
		<br><br><br>
		
		<hr>
		<!-- 파일 업로드 -->
			<div id="fileArea">
					<input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this)">
			</div>
			
			<script>
			$(function(){
				$("#fileArea").hide();
				
				$("#bookimg").click(function(){
					$("#thumbnailImg1").click();
				});
			});
			
			function LoadImg(value){
					if(value.files && value.files[0]){
						var reader = new FileReader(); 
						
						reader.onload = function(e){								
							$("#imgArea").attr("src", e.target.result);
						}
						
						reader.readAsDataURL(value.files[0]); 
					}
			}
			</script>
		
		</form>
		
    	
</body>
</html>