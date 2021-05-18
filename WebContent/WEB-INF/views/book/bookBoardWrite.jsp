<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>

<style>
	body{width: 1100px; margin: auto; min-height: 500px;} /* 너비 맞추고 가운데 정렬하기 */
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

	#bookarea {width: 1000px; height: 450px; border: 1px solid black; 	margin-left:auto; margin-right:auto; text-align: center;  }
	#bookimg{width: 200px; height: 300px; border: 1px solid black; display: inline-block; vertical-align:top;  margin-top:20px;}
	#bookinfo{width: 500px; height: 300px; display: inline-block; margin-top:20px; margin-left: 40px ;text-align: left;}
	
	#bookinfo h5 {display: inline-block;}
	
	.title{font-size : 15px;   margin-left: 70px; margin-bottom: 12px;}
	.author{font-size : 15px; margin-left: 70px;margin-bottom: 12px;}
	.company{font-size : 15px; margin-left: 55px; margin-bottom: 12px;}
	.content{font-size : 15px; margin-left: 102px; vertical-align:top;  resize: none; overflow-y:scroll; }

	
	#insertBtn{color: white; font-weight: bold; width: 80px; height: 30px;font-size: 16px; border: 1px solid #0554f2;
    border-radius: 2em; background: #0554f2; letter-spacing: -0.8px;}
	#insertBtn:hover{background:#fff;color:#0554f2;}	

	#backBtn{color: white; font-weight: bold; width: 80px; height: 30px;font-size: 16px; border: 1px solid #0554f2;
    border-radius: 2em; background: #0554f2; letter-spacing: -0.8px;}
	#backBtn:hover{background:#fff;color:#0554f2;}	
	

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
					<th id="c2">Home > 추천IT서적 > 서적 게시판 작성</th>
				</tr>
			</table>
		</div>
	  	<br>
	  	<hr>
	  	<br>
	  	<h3 align ="center">서적 게시판 작성</h3>
	  	<br><br>
	<form action = "<%= request.getContextPath() %>/insertbook.bo" method="post" encType="multipart/form-data" >
	  	<div id="bookarea"> 
	  		<br>
	  			<b>작성자 : 운영자</b>
	  		<br>
	  		<div id="bookimg">
	  				<img id= "imgArea"src="" width="200px" height="300" >
	  		</div>
	  		
	  		<div id="bookinfo">
	  		<br>
	  			<h5>제목</h5><input type="text" name ="title" class ="title" required ><br><br>
				<h5>저자</h5><input type="text" name ="author" class = "author"required ><br><br>
				<h5>출판사</h5><input type="text" name ="company" class = "company" required ><br><br>
				<h5>서적 내용</h5>&emsp;&nbsp;&nbsp; <span id= "counter">(0</span>/130)<br>
				
				<textarea rows="4" cols="50" name="content" class = "content" required ></textarea><br><br>
	  
	  		</div>
	  		
	  			<br><br><br><br>
	  	
	  		<input type="button" id="backBtn" onclick="location.href='<%= request.getContextPath() %>/bookListServlet'" value="목록">
	  		<input type="submit" id="insertBtn" value="작성완료">
	  	
	  	</div>
	
		
		<!-- 파일 업로드 -->
			<div id="fileArea">
					<input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this)">
			</div>
			
		<br><br><br><br><br><br>
			
		<footer>
			<%@ include file = "../common/footer.jsp" %>
		</footer>	
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
			
			$(function () {
				$('textarea').keyup(function(){
					var input = $(this).val();
					var text =$(this).val().length;
					
					$('#counter').html( "(" +text );
					
					if(text <= 130){
						$('#counter').css('color' , 'black'); 	
					} else{
						$('#counter').css('color' , 'red'); 
						
						var pieceStr = input.substr(0, 130);
						$(this).val(pieceStr);
					}
				
		
				});
			});
		
			</script>
	  	</form>
		
</body>
</html>