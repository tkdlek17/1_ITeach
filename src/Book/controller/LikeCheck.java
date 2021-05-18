package Book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import Book.model.service.BookService;
import Book.model.vo.Book;
import Book.model.vo.Likes;


/**
 * Servlet implementation class LikeCheck
 */
@WebServlet("/likeCheck")
public class LikeCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		Likes likes = new Likes();
		likes.setBookNo(bookNo);
		likes.setMemNum(memNo);
		BookService service = new BookService();
		
		int result = service.checkLike(likes);
		if(result == 0 ) {//count결과가 0이면 좋아요 업데이트
			service.bookLikeCountUpdate(likes);
		} else if(result == 1) {	//count결과가 있으면 좋아요 삭제
			service.bookLikeCountDelete(likes);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
