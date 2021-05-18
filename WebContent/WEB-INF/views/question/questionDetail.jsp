<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="board.model.vo.Attachment, java.util.ArrayList, question.model.vo.Board, common.model.vo.Category"%>
<%
	Board board = (Board) request.getAttribute("board");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
	ArrayList<Category> cList = (ArrayList<Category>)request.getAttribute("cList");
	String category = null;
	 for(Category c: cList){
		 if(c.getCateNo() == board.getCateNum()){
			 category = c.getCateName();
		 }
	}
	
%>
<%@ include file="/WEB-INF/views/common/menuBar.jsp"%>
<style>
	
	.tA{width: 100%; height: 190px; background: rgb(19, 116, 242); }
	#lA{text-align: center; vertical-align: middle; width: 50%; height: 100px;}
	#c1{font-size: 30px; color: white; font-weight: bold;}
	#c2{color: white; font-weight: bold;}
	
	#listArea{border: 2px solid lightgray; border-collapse:collapse;}
	.ts{width: 100px; font-size: 15px;}
	.ts:hover{cursor: pointer;}
	.www{background: white; width: 100%; height: 40px;}
	#mmm{
		background: white; text-align: center;
		vertical-align: middle; width: 50%; height: 40px;
	}
	#updateNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
		
	#updateNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
		
	#deleteNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	
	#listNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
		
	#submitBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	
	#cancelBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	#gg {
	color: rgb(75, 148, 242);
	border-bottom: 4px solid rgb(75, 148, 242);
}
#content{
	text-indent: 10px;
}

h4{color: rgb(75, 148, 242); margin-top: 30px;}
	hr{border:1px solid rgb(75, 148, 242);}
	#title{font-size: 30px; font-weight: bold;}
	#writer{color: darkgray; font-size: 20px; font-weight: bold;}
	#date{color: darkgray; font-size: 20px; font-weight: bold;}
	#category{color: darkgray; font-size: 18px; font-weight: bold;}
	#answerinfo{color: darkgray; font-size: 18px; font-weight: bold;}
	.jj{font-size: 15px; color: gray;}
	#ap{font-size: 20px; font-weight: bold;}
	#tcontent{margin-top: 20px; width: 100%; font-size: 17px;}
	#updateNoBtn{background: rgb(75, 148, 242); 
		color: white; font-weight: bold; width: 80px; height: 30px;	}
	#deleteNoBtn{background: rgb(192, 57, 43); 
		color: white; font-weight: bold; width: 80px; height: 30px;}
	#cancelBtn{background: rgb(22, 160, 133); 
		color: white; font-weight: bold; width: 80px; height: 30px;}
	#addComments{background: rgb(75, 148, 242); border: 0px;border-radius: 4px;
		color: white; font-weight: bold; width: 80px;height: 70px;}
	#cnickName{color: darkgray; font-weight: bold;}
	#commentsContent{margin-top: 5px; width: 980px; height: 75px; font-size: 15px}
	#cNick{font-weight: bold;}
	button:hover{cursor: pointer;}
	#date{
	float: right;}
	.text-style{color: darkgray; font-size: 16px; font-weight: bold;}
	#mainTitle{color: SlateGray; font-size: 24px; font-weight: bold;}
	.center {
  		margin-left: auto;
  		margin-right: auto;
	}
	
	td {
  padding-top:20px;
  padding-bottom:20px;
  padding-right:20px;   
}
</style>
	<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" id="gg" onclick="location.href='list.que'">질문/답변</th>
				<th class="ts" id="fb" onclick="location.href='main.gr'">프로그래밍 문법</th>
			</tr>
		</table>
	</div>
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">질문/답변</th>
			</tr>
			<tr>
				<th id="c2">Home > 질문/답변 > 질문/답변 </th>
			</tr>
		</table>
	</div>
	<br>
	<div id="question" class="px-5">
	<div id="title" class="mx-2">
		<span class="font-weight-bold" id="mainTitle">제목  <%=board.getBoardTitile()%></span>
	</div>
	<hr>
	<div id="date">작성일 : <%=board.getBoardCreateAt() %></div>
	<div id="writer">작성자  <%=board.getNickName()%></div>
	<br>
	<%-- 카테고리를 표시한다. --%>
	
	
	<div id="category">카테고리  <%=category %></div>
	<br>
	<br>
	<div id="content">
	<div class="text-style">내용</div>
	<p class="text-style">
	<%=board.getBoardContent()%>
	</p>
	</div>
	<br>
	<div id="attachment">
		<% if(list != null){ %>
		<div class="text-style">첨부파일</div>
		<% for(Attachment a : list){ %>
		<a style="color: darkgray;" href="<%=request.getContextPath() %>/question_uploadFiles/<%=a.getChageName() %>" download="<%= a.getOriginName() %>"><%= a.getOriginName()  %></a>
		<% } %>
		<% } %>
	</div>
	<div align="center">
					<% if(loginMember != null && loginMember.getMemNum() == board.getMemNum()){ %> 
						<input type="submit" id="updateNoBtn" value="수정" onclick="location.href='<%=request.getContextPath() %>/updateForm.que?no=<%=board.getBoardNo() %>'" >
						<input type="button" id="deleteNoBtn" value="삭제" onclick="return deleteQuestion();">
					<% } %> 
					<input type="button"  id="listNoBtn" onclick="location.href='<%=request.getContextPath()%>/list.que'" id="cancelBtn" value="목록">
	
				</div>
				<hr>
	</div>
	
	<div class="px-5" id="answerinfo">답변 목록</div>
	
	<div id="commentsSelectArea" class="px-5"><!-- 답변 조회 부분 -->
			<table id="commentsSelectTable" class="px-5 text-style">
					<tr><td>답변이 없습니다.</td></tr>
			</table>
		</div>
	<br>
	
	<br>
	<% if(loginMember != null){ %>
	<div class ="answerArea" align = "center">
			<div class="replyWriterArea">
			<br><br>
				<table>
					<tr><td><textarea rows = "1" cols ="30" id="answerTitle" style="resize:none;" placeholder="답변 제목을입력해 주세요."></textarea></tr>
					<tr>
						<td><textarea rows = "3" cols ="90" id="answerContent" style="resize:none;" placeholder="답변 내용을 입력해주세요."></textarea>
						<td ><button id="addReply" onclick="insertAnswer();">등록</button></td>
					</tr>
				</table>
			</div>
	<br>
	</div>
	<% }  %>
<script>
   function updateQuestionForm(){
		location.href="<%=request.getContextPath()%>/updateForm.que?no=<%=board.getBoardNo()%>";   
   };
   
   function deleteQuestion(){
	   var result = confirm("정말로 삭제하시겠습니까?");
	   if(result){
		   location.href="<%=request.getContextPath() %>/delete.que?no=<%=board.getBoardNo() %>";
	   }
	   
	   return false;
   };
	var getAnswer = function(){
		var qno = <%=board.getBoardNo()%>;
		$.ajax({
			url: '<%=request.getContextPath()%>/getAnswer',
			method: 'post',
			data: {
				qno: qno
			},
			success: function(data){
				console.log(data);
				var $answer = $("#commentsSelectArea").css({"align-items": "center"});
				if(data.length > 0){
					$answer.empty();
					var $div = $('<div>').addClass("px-5");
					for(var i = 0; i < data.length; i++){
						var $table = $('<table>').attr('id','commentsSelectTable').css({"align-items": "center", "width": "90%", "margin": "auto", "text-align":"left", "border-spacing":"20px", "border-collapse":"seperate"});
						var $trtitle = $('<tr>');
						var $trcontent= $('<tr>');
						var $title = $('<td>').text(data[i].answerTitle).attr({"width":"150px", "id":"cNick"}).addClass("text-style");
						var $content = $('<td>').text(data[i].content).attr({"width":"700px"}).addClass("text-style");
						var $create = $('<td>').text(data[i].andwerCreateAt).attr({"width":"120px", "padding":"10px"}).addClass("text-style");
						var $buttongroup = $('<div>');
						var $br =$('<br>');
						$trtitle.append($title);
						$trcontent.append($content);
						$trcontent.append($create);
						$table.append($trtitle);
						$table.append($trcontent);
						$div.append($table);
						$answer.append($br);
						$answer.append($div);
						$answer.append($br);
						<%-- <% if(loginMember != null ) { %>
						if(data[i].writer == '<%=loginMember.getMemNum()%>'){
							var $modifyBtn =$('<button>').text("삭제");
							var $deleteBtn =$('<button>').text("수정");
							$buttongroup.append($modifyBtn);
							$buttongroup.append($deleteBtn);
							$answer.append($buttongroup);
						}
						<% } %> --%>
						
					}
				}
				
				
				
			}
		});		
	};
	
	function insertAnswer(){
		var qno = <%=board.getBoardNo()%>;
		var title = $('#answerTitle').val();
		var content =$('#answerContent').val();
	
		$.ajax({
			url: '<%=request.getContextPath()%>/insertAnswer',
			method : 'post',
			data : {
				qno : qno,
				title : title,
				content : content
			},
			complete: function() {
				getAnswer();
			}
		});

	};

	$(document).ready(getAnswer());
	
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>