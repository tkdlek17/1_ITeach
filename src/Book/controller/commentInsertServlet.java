package Book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Book.model.service.BookService;
import Book.model.vo.Comment;

/**
 * Servlet implementation class insertComment
 */
@WebServlet("/insertComment")
public class commentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int writer = Integer.parseInt(request.getParameter("writer"));
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		String content =request.getParameter("content");
		
		Comment com = new Comment();
		com.setmemNum(writer);
		com.setContent(content);
		com.setBookNo(bookNo);
		
		
		ArrayList<Comment> list = new BookService().insertComment(com);
		response.setContentType("application/json; charset = UTF-8"); 

		GsonBuilder gb = new GsonBuilder();
		GsonBuilder gbDate = gb.setDateFormat("yyyy-MM-dd");
		Gson gson = gbDate.create();
		gson.toJson(list, response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
