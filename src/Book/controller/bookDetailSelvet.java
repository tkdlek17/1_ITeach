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
import Book.model.vo.Comment;
import Book.model.vo.Files;
import board.model.vo.Board;

/**
 * Servlet implementation class bookDetailFormSelvet
 */
@WebServlet("/bookDetail.bo")
public class bookDetailSelvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookDetailSelvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BookService service = new BookService();
		
		Book book = service.selectBook(no);
		ArrayList<Files> files = service.selectBookimg(no);
		ArrayList<Comment> comment = service.selectcomment(no);
		
	
		
		
		
		String page = null;
		if(book != null) {
			page = "WEB-INF/views/book/bookBoardDetail.jsp";
			request.setAttribute("book", book);
			request.setAttribute("files", files);
			request.setAttribute("comment", comment);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "서적게시물 조회에 실패했습니다.");
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
