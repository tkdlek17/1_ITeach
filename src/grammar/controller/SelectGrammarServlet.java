package grammar.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grammar.service.GrammarService;
import question.model.service.QuestionService;
import question.model.vo.Board;
import question.model.vo.PageInfo;

/**
 * Servlet implementation class SelectGrammarServlet
 */
@WebServlet("/list.gr")
public class SelectGrammarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectGrammarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = 20;
		
		GrammarService gService = new GrammarService();
		
		int listCount; 
		int currentPage; 
		int maxPage; 
		int startPage; 
		int endPage; 
		int boardLimit; 
		int pageLimit; 
		
		
		listCount = new GrammarService().getListCount(no);
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit); 
		
		startPage = (currentPage -1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, maxPage ,boardLimit, startPage, endPage);

		ArrayList<Board> list = new GrammarService().selectGrammar(pi, no);
		
		String page = null;
		
		System.out.println("list : " + list);
		System.out.println("pi : " + pi);

		if (list != null) {
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			page = "WEB-INF/views/grammar/grammarList.jsp";
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "조회에 실패했습니다.");
		}
		

		request.getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
