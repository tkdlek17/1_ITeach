<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="common.model.vo.Category, java.util.ArrayList, question.model.vo.Attachment, question.model.vo.Board"%>
    <% 
    Board board = (Board)request.getAttribute("board");
    ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList"); 
    ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
    %>
	<%@ include  file="/WEB-INF/views/common/menuBar.jsp" %>
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
		
	#gg {
	color: rgb(75, 148, 242);
	border-bottom: 4px solid rgb(75, 148, 242);
	}
	#submitbtn {
	background: rgb(75, 148, 242);
	margin: auto;
	color: white;
	font-weight: bold;
	width: 80px;
	height: 30px;
	padding: auto;
	font-size: 16px;
	color: #fff;
	border: 1px solid #0554f2;
	border-radius: 2em;
	background: #0554f2;
	letter-spacing: -0.8px;
	font-weight: bold;
	}
	#resetbtn {
	background: rgb(75, 148, 242);
	margin: auto;
	color: white;
	font-weight: bold;
	width: 80px;
	height: 30px;
	padding: auto;
	font-size: 16px;
	color: #fff;
	border: 1px solid #0554f2;
	border-radius: 2em;
	background: #0554f2;
	letter-spacing: -0.8px;
	font-weight: bold;
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
	<br>
	<br>

	
	<div>
	<form action="<%= request.getContextPath() %>/update.que?no=<%=board.getBoardNo() %>" method="post" enctype="multipart/form-data" onsubmit="return formValidate();" >
		<div class="row">
		<label for="title">제목 : </label><input type="text" name="title" id="title" class="form-control" value="<%=board.getBoardTitile() %>"><br>
		<label>카테고리 : </label><br>
		<select id="categorySelect" name="category" class="form-control">
			<% for(Category i : categoryList){ %>
				<option value="<%= i.getCateNo() %>" <% if(i.getCateNo() == board.getCateNum()){ %> selected <% } %>><%= i.getCateName() %></option>
			<% } %>
		</select><br>
		<label>내용 :</label><textarea name="content" id="contentArea" cols="60" rows="6" style="resize: none;" class="form-control"><%= board.getBoardContent() %></textarea>
		<div>						
		</div>
		<br>
		<div id="fileArea">
			<input type="file" id="questionFile1" multiple="multiple" name="questionFile1" onchange="">
			<input type="file" id="questionFile2" multiple="multiple" name="questionFile2" onchange="">
			<input type="file" id="questionFile3" multiple="multiple" name="questionFile3" onchange="">
			<input type="file" id="questionFile4" multiple="multiple" name="questionFile4" onchange="">
		</div>
		<br>
		<br>
		<div>
		<br>
		<button id="submitbtn" type="submit">제출</button><button id="resetbtn" type="reset" class="cancel">초기화</button></div>
		</div>
		<br>
	</form>
	</div>
	<script>
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	