<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!Teach</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<style>
	.a{font-size: 70px; color: rgb(75, 148, 242); font-weight: bold;}
	#userId, #userPwd1, #userPwd2, #userName, #nickName, #emailId{
		margin-bottom: 10px; width:400px; height: 40px; 
	}
	.lbl{
		margin-right: 340px; margin-bottom: 5px; font-weight: bold;
	}
	#Pwd{margin-left: 15px;}
	#PwdCheck{margin-left: 52px;}
	#userName1{padding-right: 15px;}
	#gender{margin-right: 70px;}
	#genderot{width:400px; height: 40px;}
	#signup{
		width:400px; height: 50px; background: rgb(75, 148, 242); color: white;
		margin-bottom: 10px; 
	}
	#goMain{
		margin-left: 320px; font-weight: bold;   
	}
	button:hover{cursor: pointer;}
	#goMain:hover{cursor: pointer;}
	
	#signupCheck1, #signupCheck2, #signupCheck3{font-weight: bold; margin-bottom: 5px;}
	#signupCheck1{margin-right: 190px;}
	#signupCheck2{margin-right: 210px;}
	#signupCheck3{margin-right: 160px;}
	
	<%-- 셀렉트 버튼 디자인 --%>
	.select {
    padding: 10px 5px; margin-right: 90px; margin-top: 20px;
	}
	.select input[type=radio]{
    display: none;
	}
	.select input[type=radio]+label{
    display: inline-block;
    cursor: pointer;
    height: 24px;
    width: 90px;
    border: 1px solid #333;
    line-height: 24px;
    text-align: center;
    font-weight:bold;
    font-size:13px;
	}
	.select input[type=radio]+label{
    background-color: #fff;
    color: #333;
	}
	.select input[type=radio]:checked+label{
    background-color: rgb(75, 148, 242);
    color: #fff;
	}
	
</style>
</head>
<body>
	<%@ include file="../common/menuBar.jsp" %>
	<br><br><br>	
	 	
	<form action="<%= request.getContextPath() %>/insert.me" method="post" id="joinForm" name="joinForm" onsubmit="return insertValidate()">
	<div id="content" align="center">
		
		<h1 class="a">!TEACH</h1>
		
		<br><br>
		
		<label for='ID' class="lbl">아이디 <span id="existId"></span></label>
		
		<br>
		<input type="text" id="userId" name="userId">
		
		
		<br>
		
		<label id="Pwd" class="lbl">비밀번호</label><br> 
		<input type="password" id="userPwd1" name="userPwd1">
		
		<br>
		
		<label id="PwdCheck" class="lbl">비밀번호 확인</label><br> 
		<input type="password" id="userPwd2" name="userPwd2">
		<span id="equalsPwd"></span>
		
		<br>
		
		<label id="userName1" class="lbl">이름</label><br>
		<input type="text" id="userName" name="userName">
		<span id="existId"></span>
		
     	<br>
     	
		<label for='PwdCheck' class="lbl">닉네임<span id="existNick"></span></label>
		<br>
		<input type="text" id="nickName" name="nickName">
		
		
		<br>
		
        <div class="select">
        <label id="gender" class="lbl">성별</label>
     	<input type="radio" id="gender1" name="genderradio" value="남자" class="radiobtn" checked><label for="gender1">남자</label>
    	<input type="radio" id="gender2" name="genderradio" value="여자" class="radiobtn"><label for="gender2">여자</label>
		</div>
		
		<br>
	
		<label for='email' class="lbl">이메일</label><br>
		<input type='email' name='email' id='emailId'>
		
		<br><br><br><br>
		<label id="signupCheck1">※ 개인정보 수집 동의(필수)<input type="checkbox" ></label>
		<br>
    	<label id="signupCheck2">※ !Teach 이용약관(필수)<input type="checkbox" ></label>
    	<br>
    	<label id="signupCheck3">※ 만 12세 미만 가입 제한(필수)<input type="checkbox" ></label>
    	<br><br>
    	
    <div class="btns" id="signUpBtns">
    	<input id="signup" type="submit" value="가입하기"><br>
    	<label id="goMain" onclick="goHome();">메인으로</label>
	</div>
<br>
<br>
<br>
<br>
	</div>
	</form>

		<%@ include file="../common/footer.jsp" %>
	
	<script>
	function insertValidate(){

        var Pwd = $('#userPwd1');
        var Pwd2 = $('#userPwd2');
        
        if(Pwd.val().trim() != Pwd2.val().trim()){
           alert('비밀번호가 다릅니다.');
           Pwd2.val();
           Pwd2.focus();
           
           return false;
           
        } else if(Pwd.val().trim() == '' || Pwd2.val().trim() == ''){
           alert('비밀번호를 입력해주세요');
           return false;
           
        }
        
        return true;
     
     }
		
		$('#userId').change(function(){
			var userId = $('#userId');
			
			if(!userId || userId.val().length < 4){
				alert('아이디는 최소 4자리 이상이여야 합니다.');
				userId.focus();
			} else{
				$.ajax({
					url: '<%=request.getContextPath()%>/checkId.me',
					data : {inputId : userId.val()},
					success : function(data){
						console.log(data);
						
						// * 데이터의 값에 공백이 들어가있는지 확인 
						if(data.trim() == '1'){
							$('#existId').text('사용 불가').css({'color':'red', 'float':'center', 'display':'block'});
							userId.focus();
							isUsable = false;
							isIdChecked = false;
						} else{
							$('#existId').text('사용 가능').css({'color':'green', 'float':'center', 'display':'block'});
							isUsable = true;
							isIdChecked = true;
						}
					}
				});
			}
		});
		
		$('#nickName').change(function(){
	         var nickName = $('#nickName');
	         
	         if(!nickName || nickName.val().length < 1){
	            alert('닉네임은 최소 1자리 이상이여야 합니다.');
	            nickName.focus();
	         } else{
	            $.ajax({
	               url: '<%=request.getContextPath()%>/checkNick.xx',
	               data : {inputNick : nickName.val()},
	               success : function(data){
	                  console.log(data);
	                  
	                  // * 데이터의 값에 공백이 들어가있는지 확인 
	                  if(data.trim() == '1'){
	                     $('#existNick').text('사용 불가').css({'color':'red', 'float':'center', 'display':'block'});
	                     nickName.focus();
	                     isUsable = false;
	                     isNickChecked = false;
	                  } else{
	                     $('#existNick').text('사용 가능').css({'color':'green', 'float':'center', 'display':'block'});
	                     nickName = true;
	                     isNickChecked = true;
	                  }
	               }
	            });
	         }
	      });
		
		
		/* $('#nickCheck').on('click', function(){
			window.open('checkNickForm.zz', 'nickCheckForm', 'width=300, height=300');
			
		}); */
		/* 
		$('#joinUserId').on('click', function(){
			window.open('checkIdForm.me', 'idCheckForm', 'width=300, height=300');
			
		}); */
	</script>
    
</body>

</html>