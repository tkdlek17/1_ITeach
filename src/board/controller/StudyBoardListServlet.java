package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Fboard;
import board.model.vo.PageInfo;


/**
 * Servlet implementation class StudyBoardListServlet
 */
@WebServlet("/list.st")
public class StudyBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService bService = new BoardService();
		
		String search = request.getParameter("search");
		String searchtext = request.getParameter("searchtext");
		
		int listCount; 		
		int currentPage; 	
		int pageLimit;		
		int boardLimit; 	
		int maxPage;		
		int startPage;		
		int endPage;
		
		listCount = bService.getListCount();
		
		if(searchtext == null) {
			listCount = bService.getListCount();
		} else {
			listCount = bService.searchlistCount(search, searchtext);
		}
		System.out.println("�˻� �� �Խñ� �� : " + listCount);
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Fboard> flist = null;
		if(searchtext == null) {
			flist = bService.selectSList(pi);
		} else {
			flist = bService.SESList(search, searchtext, pi);
		}
		
		String page = null;
		if(flist != null) {
			page = "WEB-INF/views/board/studyboardList.jsp";
			request.setAttribute("flist", flist);
			request.setAttribute("pi", pi);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "스터디 조회에 실패했습니다.");
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
