package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import notice.model.vo.Comments;
import notice.model.service.NoticeService;

/**
 * Servlet implementation class CommentsnInsertServlet
 */
@WebServlet("/insertComments.no")
public class CommentsnInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsnInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int writer = Integer.parseInt(request.getParameter("writer"));
		int no = Integer.parseInt(request.getParameter("no"));
		String content = request.getParameter("content");
		
		Comments c = new Comments();
		c.setMemNum(writer);
		c.setContent(content);
		c.setNoticeNo(no);
		
		ArrayList<Comments> list = new NoticeService().insertnComments(c);
		
		response.setContentType("application/json; charset=UTF-8");
		
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
