package Book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Book.model.service.BookService;
import Book.model.vo.Book;
import Book.model.vo.Files;

/**
 * Servlet implementation class bookmainListServlet
 */
@WebServlet("/bookmainListServlet")
public class bookmainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookmainListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Book> list = new BookService().selectmainList();
		ArrayList<Files> files = new BookService().selectFList();
		
		System.out.println(list);
			Book book = null;
	
			
			JSONArray jArray = new JSONArray();
			JSONObject jQbject = null;
			
	
				for(Book bookinfo : list  ) {
					for(Files fileinfo : files) {
				         if(fileinfo.getBookNo() == bookinfo.getBookNo()) {
						jQbject = new JSONObject();
						
						jQbject.put("bookTitle", bookinfo.getBookTitle());
						jQbject.put("ChangeName", fileinfo.getChangeName());
						jQbject.put("bookNo", bookinfo.getBookNo());
						jArray.add(jQbject);
				         }
					}
			}
			

			response.setContentType("application/json; charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println(jArray);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
