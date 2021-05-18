<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
    
<% Member loginMember = (Member)session.getAttribute("loginUser");
   System.out.println("test:" + loginMember);
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
body{width: 1100px; margin: auto;} /* 너비 맞추고 가운데 정렬하기 */
	
	/********************************* header *****************************/
	ul{list-style: none;} /* 리스트 앞에 . 같은거 제거*/
	a{text-decoration: none; color: black;} /* 링크에 밑줄 같은거 제거*/
	*{margin: 0px; padding: 0px; font-family: 'Noto Sans KR', sans-serif;}
	header{
		width: 1100px;
		height: 50px;
		background-color: rgb(5, 84, 242);
		position: relative;
		/* header 안에 요소들을 모두 absolute 포지션으로 배치할 것이라서 */
	    /* absolute 요소가 header의 좌상단을 기준으로 하려면 */
	    /* header의 position이 relative 여야만 함 */
	}

	
	/* 제목영역안에 있는 메인 로고 이미지 위치 지정 */
	#logo{
		position: absolute;
		top: 10px;
	    left: 40px;
	    color:white;
	    font-weight:bold;
	    font-size:20px;
	}
	
		/* top_menu a의 글시 하얀색으로 */
	#main-menu a{color: white; font-weight:bold;}
	
	/* 메뉴 바들 안에 서브메뉴 폰트크기 설정 */
	nav{
	    position: absolute;
	    top: 1px;
	    bottom: 10px;
	    left: 220px;
	    font-size: 15px;
	}
	
	/* 메뉴 바 인라인 속성으로 바꾸고 마진 값 설정 */
	nav a{
	margin-right: 5px;
	margin-left: 5px;

	}
	
	
	#main-menu,
	#sub-menu{
		margin: 0;
		padding: 0;
		list-style-type: none;
	}
	#main-menu > li{
		float: left;
	
	}
	#main-menu > li > a{
		text-align: center;
		padding: 8px 16px;
		display: block;
	}
	
	/*메뉴 글씨 싸이즈 */
	#main-menu > li > a {
	  font-size: 0.85rem;
	  color :white;
	  text-align: center;
	  text-decoration: none;
	  letter-spacing: 0.05em;
	  display: block;
	  padding: 12px 36px;

	}
	
	/*서브 메뉴가 보여질 때의 속성 설정*/
	#sub-menu {
	  background: rgba(81, 150, 197, 0.65);
	  pacity: 1;
	  font-size: 12px;
	  visibility: hidden;
	  text-align: center;
	  position: absolute;

	}
	
	/*서브 메뉴가 보여질 때의 크기 지정*/	
	#sub-menu > li {
	  padding: 16px 28px;
	  width: 125px;
	
	}
	
	/*서브메뉴안 글씨*/ 
	#sub-menu > li >  a {
	  color: white;
	  text-decoration: none;
	  
	}
	
	#main-menu > li:hover #sub-menu {
	  opacity: 1;
	  visibility: visible;
	}
	

	
	/* 헤더 오른쪽 상단에 login_menu 배치 */
	#login_menu{
	    position: absolute;
	    top: 12px;
	    right: 10px;
	}
	/* login_menu 폰트 속성 지정 */
	#login_menu a {
	    color: white;
	    font-weight: bold;
	    font-size: 10px;
	    margin-left: 10px;
	    margin-right:10px;
	}
	
	/*헤더 중간 포인트 위치와 색상 지정*/
	#point{
		width: 1100px;
		height: 5px;
		background-color:rgb(52, 152, 219);
		opacity: 0.5;
	}
	
		/* top_menu a의 글시 하얀색으로 */
	#main-menu a{color: white; font-weight:bold;}
	
	/* 메뉴 바들 안에 서브메뉴 폰트크기 설정 */
	nav{
	    position: absolute;
	    top: 1px;
	    bottom: 10px;
	    left: 220px;
	    font-size: 15px;
	}
	
	/* 메뉴 바 인라인 속성으로 바꾸고 마진 값 설정 */
	nav a{
	margin-right: 5px;
	margin-left: 5px;

	}
	
	/* **************** middle *********************** */
	div #middle1{background: #1374F2; height: 350px;}
	#middle1 img{display: block; margin: auto;}
	#middle1 h1{color: white; text-align: center; width: 100%;}
	#middle1 h3{color: white; text-align: center; width: 100%;}
	#middle1 input{
		color: white; background:rgba(95, 217, 243, 0.73);
		width: 100px; height: 30px; 
		display: block; margin: auto;
	}
	
	#start{ border-radius: 7px; border: 0px;  }
	
	.btn1{
		border: 1px solid  #1374F2; width: 25px; 
		border: 0px; 
		padding: 2px;
		border-radius: 100%; margin: 0 3px;
		background:  #1374F2; color: white; 
		font-size: 20px;
	}
	.information1_inner{text-align: center; width: 1000px; margin: auto; padding: 5px;}
	.information1{
		display: inline-block; padding: 10px; width: 400px; text-align: center; 
	}
	.information1_inner>b{font-size: 20px; margin-right: 65%;}
	
	
	
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
	
	/******************** footer ************************/
	#introduce-company{
		float: left; /* 왼쪽으로 엘리먼트 띄움 */
		text-align: left;
		margin-left: 0px;
		
	}
	#introduce-company ul li {
		padding-right: 25px;
		
	}
	#introduce-company ul{
		padding-left: 0px;
	}
	#sns-link{
		float: right;
		 /* 오른쪽으로 엘리먼트 붙임 */
	}

	#sns-link ul li {
		display: inline-block; /* sns 리스트를 inline으로 표시함*/
		padding: 0px 5px; /* 위아래 좌우 패딩*/
	}
	#company-name{
		clear: both; /* 양쪽에 엘리먼트 오지 않게 함 */
		font-weight: bold; /* 볼드 */
		text-align: left;

	}
	
	
	#nologin{
	    position: absolute;
	    top: 12px;
	    right: 10px;
	   
	}
	/* login_menu 폰트 속성 지정 */
	
	#nologin, #loginhome{
	    
	    position: absolute;
	    right: 10px;
	    font-weight: bold;
	    font-size: 15px;
	    margin-left: 10px;
	    margin-right:10px;
	    
	    
	}
	
	/*헤더 중간 포인트 위치와 색상 지정*/
		#point{
			width: 1100px;
			height: 5px;
			background-color:rgb(52, 152, 219);
		}
		
		#loginhome{
		 height: 300px;
		}
		#loginBtn, #SignUpBtn, #myPageBtn, #logout{
		 background:rgb(52, 152, 219);
		  color:#fff;
		  border:none;
		  position:relative;
		  height:20px;
		  font-size:0.7em;
		  padding:0.3em;
		  cursor:pointer;
		  transition:800ms ease all;
		  outline:none;
		  border-radius : 7px;
		}

		
		#grammar-title, #grammar-list-item{
			color: black;
		}
		
	#main-menu > li:hover{cursor: pointer;}

</style>
</head>

<body>
	<div id="page">
	
	 <header>
	  	<div id ="logo" onclick="goHome();">
	  		!ITeach
	  	</div>
	  <nav>
	  	<ul id="main-menu">
		    <li><a href="list.que">질문/답변</a>
				<ul id="sub-menu">
					<li><a href="<%=request.getContextPath()%>/list.que">질문/답변</a></li>
					<li><a href="<%=request.getContextPath()%>/main.gr">프로그래밍
							문법</a></li>
				</ul>
			</li>

	  		<li><a class="menu" onclick="goLicense();">기출문제</a></li>
	  		
	  		<li><a class= "menu" onclick = "goBookBoard();">추천 IT서적</a>
		    </li>
		    
		     <li><a href="list.hire">채용공고</a>
			      <ul id="sub-menu">
			       	<li><a onclick="hireList();">구인구직</a></li>
			       	<%if(loginMember != null){ %>
			       	<li><a onclick="enrollHire();">채용등록</a></li>
			      	<% } %>
			      </ul>
		    </li>
		    
		    <li><a href="list.no">커뮤니티</a>
		    	<ul id="sub-menu">
			        <li><a href="list.no" aria-label="subemnu" onclick="goNotice();">공지 사항</a></li>
			        <li><a href="list.fbo" aria-label="subemnu" onclick="goFreeBoard();">자유글</a></li>
			        <li><a href="list.st" aria-label="subemnu" onclick="goStudy();">스터디모집</a></li>
		     	</ul>
		    </li>
		   </ul>
		 </nav>
	
		<%if(loginMember == null) { %>
			
			<div id=nologin>
				<span><input type="button" id="loginBtn" value="로그인"></span>
				<span><input type="button" id="SignUpBtn" value="회원가입"></span>
			</div>	
			
		<%} else { %>
			<div id="loginhome" align="right">
				<label style="color:white;"><%= loginMember.getMemName() %>님</label>
				<div class="loginBtns">
					<input type="button" id="myPageBtn" value="마이페이지">
					<input type="button" id="logout" onclick="logout();" value="로그아웃">
				</div>
			</div>
			
		<%} %>

	 
    </div>
    
   <!--  <div id="middle1">
		<br>
		<img src="image/icon.PNG" width="100px;" height="100px;">
		<br>
		<h1>IT 초보인 당신도 코딩 고수가 될 수 있다.</h1>
		<br>
		<h3>지금 ITeach를 시작하세요.</h3>
		<br>
		<input type="button" id="start" value="시작하기">
	</div>
 -->
	
	
	<div id="point"></div>
	
    
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
  		
  		 function logout(){
				location.href='<%= request.getContextPath() %>/Logout.me';
			}
		 function goHome(){
				location.href="<%=request.getContextPath()%>";
			}
		 function goLicense() {  // 메뉴바에서 기출문제를 클릭했을 때
			 	location.href="<%= request.getContextPath() %>/list.li"
		   }
		 
		 $('#SignUpBtn').on('click', function(){
				location.href="<%= request.getContextPath() %>/SignUp.me";
			});
		 $('#loginBtn').on('click', function(){
				location.href="<%= request.getContextPath() %>/Login.me";
			});
		 
		 $('#myPageBtn').on('click', function(){
				location.href="<%= request.getContextPath() %>/MyPage.go";
			});
		 
		 function goNotice(){
	  			location.href="<%=request.getContextPath() %>/list.no";
	  		}
	  	function goFreeBoard(){
	  		location.href="<%=request.getContextPath() %>/list.fbo";
	  		}
	  	function goStudy(){
	  		location.href="<%=request.getContextPath() %>/list.st";
	  		}
    
    </script>
</body>

</html>