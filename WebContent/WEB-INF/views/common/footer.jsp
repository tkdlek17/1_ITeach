<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
	body{width: 1100px; margin: auto;} /* 너비 맞추고 가운데 정렬하기 */
	
	/********************************* header *****************************/
	ul{list-style: none;} /* 리스트 앞에 . 같은거 제거*/
	a{text-decoration: none; color: white;} /* 링크에 밑줄 같은거 제거*/
	  *{margin: 0px; padding: 0px;}
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
	}
	
	/* top_menu a의 글시 하얀색으로 */
	#main-menu a{color: white; font-weight:bold;}
	
	/* 메뉴 바들 안에 서브메뉴 폰트크기 설정 */
	nav{
	    position: absolute;
	    top: 1px;
	    bottom: 10px;
	    left: 220px;
	    font-size: 10px;
	}
	
	/* 메뉴 바 인라인 속성으로 바꾸고 마진 값 설정 */
	nav a{
	margin-right: 5px;
	margin-left: 5px;

	}
	/*메뉴 글씨 싸이즈 */
	#main-menu > li > a {
	  font-size: 13px;
	  text-align: center;
	  text-decoration: none;
	  letter-spacing: 0.05em;
	  display: block;
	  padding: 14px 32px;

	}
	
	/*서브 메뉴가 보여질 때의 속성 설정*/
	#sub-menu {
	  background: rgba(81, 150, 197, 0.65);
	  opacity: 1;
	  visibility: hidden;
	  text-align: center;

	}
	/*서브 메뉴가 보여질 때의 크기 지정*/	
	#sub-menu > li {
	  padding: 10px 14px;
	
	}
	
	/*서브메뉴안 글씨*/ 
	#sub-menu > li >  a {
	  color: white;
	  text-align: center;
	  text-decoration: none;
	  
	}
	
	#main-menu > li:hover #sub-menu {
	  opacity: 1;
	  visibility: visible;
	}
	
	#sub-menu > li >  a:hover {
	 text-decoration: underline;
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
	}
	
	/* **************** middle *********************** */
	#middle1{background: #1374F2; height: 300px;}
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
	
	footer{
		width: 100%;
		text-align: center; /* 중앙정렬 */
		font-size: 13px;
		height: 150px;
		padding: 13px;
	}
	#wrap-footer{
		max-width: 960px;
		margin: auto;
	}
	#footer-line{
		width: 100%;
		height: 1px;
		background: rgb(31, 31, 31);
	}
	/* 연락정보 */
	#contact-info{
		padding-top: 10px;
		text-align: left;
	}
	/* 카피라이트 */
	#copyright{
		text-align: left;
		padding-top: 10px;
	}

	/* 메뉴 패딩 */
	.menu{
		padding: 0px 30px;
		
	}
	#introduce-company ul li{
		display: inline-block;
	}
	
	

</style>
</head>

<body>

	
	<div id="footer-line"></div>
	<footer>
		<div id="wrap-footer">
		<span id="introduce-company">
			<ul>
				<li>회사소개</li>
				<li>이용약관</li>
				<li>개인정보 처리방침</li>
				<li>FAQ/문의</li>
			</ul>
		</span>
		<span id="sns-link">
	         <ul>
	            <li><img alt="페이스북" src="source/image/페이스북로고.png" width="30px" height="30px"></li>
	            <li><img alt="인스타그램" src="source/image/인스타그램로고.png"width="30px" height="30px"></li>
	            <li><img alt="트위터" src="source/image/트위터로고.png"width="30px" height="30px"></li>
	         </ul>
		</span>
		<div id="company-name"><br>(주)아이티치</div> 
		<div id="contact-info">(11111)서울특별시 강남구 역삼동 대표이사: 김상수 사업자 등록번호: 352-44-3588 전화: 2659-2005 팩스: 02-3345-2005</div>
		<div id="copyright">COPYRIGHT(C)2021 ITEACH,ALL RIGHTS RESERVED.</div>
		</div>
	</footer>
   
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    
   
</body>

</html>