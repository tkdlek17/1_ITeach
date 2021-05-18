package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.vo.Category;
import common.service.CommonService;
import question.model.service.QuestionService;
import question.model.vo.Board;
import question.model.vo.PageInfo;

/**
 * Servlet implementation class selectQuestionServlet
 */
@WebServlet("/list.que")
public class SelectQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionService qService = new QuestionService();
		String categoryNoString = request.getParameter("categoryNo");
		String searchText = request.getParameter("searchText");
		String searchMethodString = request.getParameter("searchMethod");
		
		int category = 11;
		int listCount;
		int currentPage;
		int maxPage;
		int startPage;
		int endPage;
		int boardLimit;
		int pageLimit;
		
		
		if(categoryNoString != null) {
			int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
			if(searchText != null && searchMethodString != null) {
				int searchMethod = Integer.parseInt(searchMethodString);
				listCount = qService.getSearchedSubListCount(category, searchMethod, searchText);
			} else {	
				listCount = qService.getSubListCount(categoryNo);
			}
		} else {
			if(searchText != null && searchMethodString != null) {
				int searchMethod = Integer.parseInt(searchMethodString);
				listCount = qService.getSearchedListCount(searchMethod, searchText);
				
			} else {	
				listCount = qService.getListCount(10);
			}
		} 
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) { 
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage);
		}
		
		pageLimit = 10; 
		boardLimit = 10; 
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		System.out.println("maxPage: " + maxPage);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = null;

		if(categoryNoString != null) {
			int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
			if(searchText != null && searchMethodString != null) {
				int searchMethod = Integer.parseInt(searchMethodString);
				list = qService.getSearchedSubList(pi, category, searchMethod, searchText);
			} else {	
				list = qService.getSubList(pi, categoryNo);
			}
		} else {
			if(searchText != null && searchMethodString != null) {
				int searchMethod = Integer.parseInt(searchMethodString);
				list = qService.getSearchedList(pi, searchMethod, searchText);
			} else {	
				list = qService.selectQuestionList(pi, category);
			}
		} 
		
		ArrayList<Category> categoryList = new CommonService().getCategory(10);
		String page = null;
		System.out.println("마지막 pi : "+pi);
		if(list != null) {
			page ="WEB-INF/views/question/questionList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("category", categoryNoString);
			request.setAttribute("pi", pi);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "질문조회에 실패했습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
