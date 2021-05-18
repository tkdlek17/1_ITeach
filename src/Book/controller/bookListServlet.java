package Book.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Book.model.service.BookService;
import Book.model.vo.Book;
import Book.model.vo.Files;
import Book.model.vo.PageInfo;

/**
 * Servlet implementation class bookLisdtServlet
 */
@WebServlet("/bookListServlet")
public class bookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("search");
		String searchtext = request.getParameter("searchtext");
		
		System.out.println(search);
		System.out.println(searchtext);
		
		
		int listCount;   
		int currentPage; 
		int pageLimit; 	
		int boardLimit;	 
		int maxPage;	 
		int startPage;	 
		int endPage;	 
		int allCount;
		BookService service = new BookService();
	
		
		if(searchtext == null) {
			listCount = service.getListCount();
		} else {
			
			listCount = service.searchlistCount(search, searchtext );
		}
		
		allCount = service.getListCount();

		currentPage = 1;
		if(request.getParameter("currentPage")!= null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage  + pageLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage, allCount);
		
		ArrayList<Book> list = null;
		if( searchtext == null) {
			list = service.selectList(pi);
		} else {
			list = service.SList(search, searchtext ,pi);
		}
	
		
		
		ArrayList<Files> files = service.selectFList();
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/book/bookBoardList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("files", files);
			request.setAttribute("searchtext", searchtext);
			
		}else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "서적 리스트 조회를 실패");
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
