<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, common.model.vo.Category" %>
    <% 
    	ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList"); 
    %>
<%@ include file="/WEB-INF/views/common/menuBar.jsp" %>
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
<div class="www" align="center">

		<table id="mmm">
			<tr>
				<th class="ts" onclick="location.href='<%=request.getContextPath()%>/list.que'">질문/답변</th>
				<th class="ts" id="gg" onclick="location.href='<%=request.getContextPath()%>/main.gr'">프로그래밍 문법</th>
			</tr>
		</table>
	</div>
	
	<div class="tA" align="center"><br><br>
		<table id="lA">
			<tr>
				<th id="c1">질문/답변</th>
			</tr>
			<tr>
				<th id="c2">Home > 질문/답변 > 프로그래밍 문법 </th>
			</tr>
		</table>
	</div>
	<div>
	
	<form class="form" method="post" action="<%=request.getContextPath() %>/insert.gr">
		<label>제목</label><input type="text" name="title" class="form-control">
		<label>카테고리 : </label><br>
		<select id="categorySelect" name="category" class="form-control">
			<% for(Category c : categoryList){ %>
				<option value="<%= c.getCateNo() %>"><%= c.getCateName() %></option>
			<% } %>
		</select><br>
		<label>내용</label><textarea name="content" rows="10" cols="100" class="form-control"></textarea>
		<button type="submit" class="btn btn-primary">제출</button>&nbsp;<button type="reset" class="btn btn-secondary">초기화</button>
	</form>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>