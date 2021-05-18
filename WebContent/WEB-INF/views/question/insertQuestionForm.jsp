<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="common.model.vo.Category, java.util.ArrayList"%>
<%
	ArrayList<Category> categoryList = (ArrayList<Category>) request.getAttribute("categoryList");
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
		
	#gg {
	color: rgb(75, 148, 242);
	border-bottom: 4px solid rgb(75, 148, 242);
}
</style>
<div class="container text-center subcolor">
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
</div>
<div class="container form-width">
	<div class="">
		<form action="<%=request.getContextPath()%>/insert.que"
			method="post" enctype="multipart/form-data";">
			<div class="row">
				<label for="title">제목 : </label><input type="text" name="title"
					id="title" class="form-control"><br> <label>카테고리
					: </label><br> <select id="categorySelect" name="category"
					class="form-control">
					<%
						for (Category i : categoryList) {
					%>
					<option value="<%=i.getCateNo()%>"><%=i.getCateName()%></option>
					<%
						}
					%>
				</select><br> <label>내용 :</label>
				<textarea name="content" id="contentArea" cols="60" rows="6"
					style="resize: none;" class="form-control"></textarea>
				<div id="fileArea">
					<input type="file" id="questionFile1" multiple="multiple"
						name="questionFile1" onchange=""> <input type="file"
						id="questionFile2" multiple="multiple" name="questionFile2"
						onchange=""> <input type="file" id="questionFile3"
						multiple="multiple" name="questionFile3" onchange=""> <input
						type="file" id="questionFile4" multiple="multiple"
						name="questionFile4" onchange="">
				</div>
				<div>
					<br>
					<button type="submit" class="btn btn-primary">제출</button>
					&nbsp;
					<button type="reset" class="btn btn-secondary">초기화</button>
				</div>
			</div>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
