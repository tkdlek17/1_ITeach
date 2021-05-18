package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Fboard;

/**
 * Servlet implementation class StudyBoardUpdateServlet
 */
@WebServlet("/update.st")
public class StudyBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		int id = Integer.parseInt(request.getParameter("id"));
		String region = request.getParameter("region");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Fboard sboard = new Fboard();
		sboard.setBoardNo(no);
		sboard.setId(id);
		sboard.setRegion(region);
		sboard.setBoardTitle(title);
		sboard.setBoardContent(content);
		
		int result = new BoardService().updateSBoard(sboard);
		
		if(result > 0) {
			response.sendRedirect("detail.st?stNo="+no);
		} else {
			request.setAttribute("msg", "스터디 수정에 실패했습니다.");
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
