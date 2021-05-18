<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList, Book.model.vo.Files, Book.model.vo.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
	*{font-family: 'Noto Sans KR', sans-serif;}
	body{width: 1100px; margin: auto;} /* 너비 맞추고 가운데 정렬하기 */
	
	
	
	/*헤더 중간 포인트 위치와 색상 지정*/
	#point{
		width: 1100px;
		height: 5px;
		background-color:rgb(52, 152, 219);
	}
	
	/* **************** middle *********************** */
	div #middle1{background: #1374F2; height: 350px;}
	#middle1 img{display: block; margin: auto;}
	#middle1 h2{color: white; text-align: center; width: 100%;margin-bottom: 20px;}
	#middle1 h5{color: white; text-align: center; width: 100%; margin-bottom: 20px;}
	#middle1 button{
		
		color: white; background:rgba(95, 217, 243, 0.73);
		font-weight: bold;
		display: block; 
	}
	
	@keyframes big {
        from {
          width: 20px;
          height: 20px;
        }
        to {
          width: 100px;
          height: 100px;
        }
      }
     #middle1 img {
        margin: 30px auto;
        width: 100px;
        height: 100px;
        animation-name: big;
        animation-duration: 1s;
        animation-timing-function: linear;
        animation-delay: 2s;
        animation-iteration-count: 3;
        animation-direction: alternate;
        animation-fill-mode: none;
        animation-play-state: running;
      }
	
	#start{ border-radius: 7px; border: 0px; text-align: center; width: 130px; height: 35px; }
	
	#middle1 #start {
	    display: block;
	    margin: auto ;
	    text-align: center;
	    color: white; background:rgba(95, 217, 243, 0.73);
	    border-radius: 3px;
	    box-shadow: 8px 5px 7px rgba(0, 0, 255, .3);
	    padding: auto;
	    font-size: 18px;
	    cursor: pointer;
	    border: none;
	    outline: none;
	    text-decoration: none;
	    -webkit-transition: 0.3s ease;
	    transition: 0.3s ease;
	}
	#middle1 #start:hover {
	    transform: translateY(-3px);
	}
	#middle1 #start .fa {
	    margin-right: 5px;
	}
	#animate-like {
	  animation-name: likeAnimation;
	  animation-iteration-count: 1;
	  animation-fill-mode: forwards;
	  animation-duration: 0.65s;
	}
	@keyframes likeAnimation {
	  0%   { transform: scale(30); }
	  100% { transform: scale(1); }
	}
	.btn1{
		border: 1px solid  #1374F2; width: 25px; 
		padding: auto;
		border-radius: 100%; margin: 0 3px;
		background:  #1374F2; color: white; 
		font-size: 20px;
		float: right;
	}
	.information1_inner{text-align: center; width: 800px; height: 200px;
	}
	.information1{ display: inline-block; width: 200px; height: 250px; }
	.information1_inner>b{font-size: 20px;}
	.hireCompany { display: block;}
	
	
	.information2_inner{text-align: center; width: 1000px; margin: auto; }
	.information2_inner>b{font-size: 20px;}
	.information2{display: inline-block; padding: 10px; }
	.information2>div{width: 200px; }
	.information2_inner button{align: center;}
	
	.btn2-1{
		border: 1px solid  #1374F2;
		width: 25px; 
		border: 0px; 
		padding: 2px;
		border-radius: 100%;
		background:  #1374F2; color: white; 
		font-size: 20px;
	}
	
	.btn2-2{
		border: 1px solid gray;
		border-radius: 40px;
		background:  gray; 
		font-size: 20px;  width: 20px;
	}
	
	.pointbar	{
		display: inline-block;
		width: 60px;
		height: 5px;
		background: #DFF2FD;
		margin-left: 520px;
	}
	  
	  #hire {
		font-size: 22px; font-weight: bold; display: inline-block; margin-left: 390px; }
	 #itbook {
		font-size: 22px; font-weight: bold; display: inline-block; margin-left: 390px; }
		
		#plus1{
			display: inline-block;
			margin-left: 348px;
			font-size: 12px;
			cursor: pointer; 
	
		}
		
		#plus2{
			display: inline-block;
			margin-left: 348px;
			font-size: 12px;
			cursor: pointer; 
		}
</style>
</head>

<body>
	<div id="page">

		<%@ include file="../common/menuBar.jsp" %>
	 
    <div id="middle1">
		<br>
		<img src="source/image/mainLogo.png">
		<br>
		<h2><b>IT 초보인 당신도 코딩 고수가 될 수 있다.</b></h2>
		<h5><b>지금 ITeach를 시작하세요.</b></h5>
		<button id="start"><i class="fa fa-heart" aria-hidden="true"></i>시작하기 </button>

	</div>
	<br><br>
	
	<section>	
		 
		
		<div class="ti" style="text-align: center;">
			 <p id="hire">채용 정보</p>
			  <div id = "plus1" onclick = "list1()"> +더보기 </div>
		</div>
		<div class="pointbar"></div>
		<article class="information">

					<br><br>
					<div class="information1_inner">
					
					</div>
		</article>
							<br>
			<div class="ti" style="text-align: center;">
				<p id="itbook">추천 IT서적</p> 

				 <div id = "plus2" onclick = "list2()"> +더보기 </div>
			</div>
				 <div class="pointbar"></div>
				 		 
			<article class="information">
			
						
						<br><br>
						<div class="information2_inner">
						
						</div>	
					<br><br>
					
		</article>
	</section>
	<br>
	<br>
	</div>
	<%@ include file="../common/footer.jsp" %>
	<br><br>
    <script>
  		function goBookBoard(){
  			location.href="<%=request.getContextPath() %>/bookListServlet";
  	    }
  		function hireList(){
  			location.href='<%= request.getContextPath() %>/list.hire';
  		}
  		function enrollHire(){
  			location.href='<%= request.getContextPath() %>/writeHireForm.hire';
  		}
  		
  		function list1(){
  			location.href="<%= request.getContextPath() %>/list.hire";
  		}
  		
  		function list2(){
  			location.href="<%= request.getContextPath() %>/bookListServlet";
  		}
  		
  		
  		$('#start').on('click', function(){
  			location.href="<%= request.getContextPath() %>/SignUp.me";
		});
  		
  		
  		 $(function() {
  			$.ajax({
	  			url : 'ThumbnailListHire',
	  			success: function(data){
	  				console.log(data);
	  				
	  				var $information1_inner = $('.information1_inner');
	  				$information1_inner.html('');
	  				
	  				for(var i in data){
	  					
	  					console.log(data[i].changeName);
	  					console.log(typeof(data));
	  					console.log(data.length);
	  					
	  					var $div = $('<div id= "div1">').css({'width':'300px', 'height':'200px','display':'inline-block'});
	  					
	  					var $img = $('<img>').attr("src","thumbnail_uploadFiles/"+data[i].changeName).css({'width':'250px', 'height':'100px' });
	  					var $title = $('<div>').text(data[i].hireCompany).css({'width':'200px', 'height':'20px', 'text-align':'right'});
	  					
	  					$div.append($img);
	  					
	  					$div.append($title);
	  					
	  					$information1_inner.append($div);
	  				  
		                $('.information1_inner img').eq(0).on('click', function(){
		                	location.href='<%=request.getContextPath()%>/detail.hire?no='+ data[0].hireNo;
	                     });
		                $('.information1_inner img').eq(1).on('click', function(){
		                	location.href='<%=request.getContextPath()%>/detail.hire?no='+ data[1].hireNo;
	                     });
		                $('.information1_inner img').eq(2).on('click', function(){
		                	location.href='<%=request.getContextPath()%>/detail.hire?no='+ data[2].hireNo;
	                     });
	  				}
	  			}
	  		});
  		});  
  	
  	  $(function(){
	        $.ajax({
	          url : 'bookmainListServlet',
	          success : function(data ) {
	             console.log("통신성공");
	             console.log(data);
	             
	                $information2_inner = $('.information2_inner');   
	                $information2_inner.html('');
	                
	
	                for(var key in data){
		                var $div = $('<div id= "div1">').css({'width' : '200px', 'height' : '250px', 'display' : 'inline-block'});
		                var $img =   $('<img>').attr("src" , "image_uploadFiles/"+ data[key].ChangeName).css({'width' : '130px', 'height' : '180px','box-shadow': '8px 5px 7px #EAEAEA' });
		                var $title = $('<div>').text(data[key].bookTitle).css({'width' : '200px' ,"height" : "50px", "text-overflow"  : "ellipsis" , "white-space" : "nowrap" , "overflow" : "hidden" });
		       	
		                
		                $div.append($img);
		                $div.append($title);
		                $information2_inner.append($div);
		                
		                $('.information2_inner img').eq(0).on('click', function(){
	                        location.href='<%=request.getContextPath()%>/bookDetail.bo?no='+ data[0].bookNo;
	                     });
		                $('.information2_inner img').eq(1).on('click', function(){
	                        location.href='<%=request.getContextPath()%>/bookDetail.bo?no='+ data[1].bookNo;
	                     });
		                
		                $('.information2_inner img').eq(2).on('click', function(){
	                        location.href='<%=request.getContextPath()%>/bookDetail.bo?no='+ data[2].bookNo;
	                     });
		                
		                $('.information2_inner img').eq(3).on('click', function(){
	                        location.href='<%=request.getContextPath()%>/bookDetail.bo?no='+ data[3].bookNo;
	                     });
	             }
           }
      });
   });

  	$(function(){
  	  $(document).one('click', '#start', function(e) {
  	    $(this).html('<i class="fa fa-heart" aria-hidden="true"></i> 환영해요!');
  	    $(this).children('.fa-heart').addClass('animate-like');
  	  });
  	});
    </script>
 
</body>

</html>