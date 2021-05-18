package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Fboard;
import member.model.vo.Member;

/**
 * Servlet implementation class FboardInsertServlet
 */
@WebServlet("/insert.fbo")
public class FboardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FboardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer = ((Member)(request.getSession().getAttribute("loginUser"))).getMemNum();
		
		Fboard fb = new Fboard();
		fb.setBoardTitle(title);
		fb.setBoardContent(content);
		fb.setMemNum(writer);
		fb.setCateNo(30);
	
		int result = new BoardService().insertBoard(fb);
		
		
		if(result > 0) {
			response.sendRedirect("list.fbo");
		} else {
			request.setAttribute("msg", "게시판 작성에 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
