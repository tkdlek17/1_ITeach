package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Comments;
import board.model.vo.Fboard;

/**
 * Servlet implementation class FboardDetailServlet
 */
@WebServlet("/detail.fbo")
public class FboardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FboardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fbNo = Integer.parseInt(request.getParameter("fbNo"));
		System.out.println(fbNo);
		
		Fboard fboard = new BoardService().selectBoard(fbNo);
		
		ArrayList<Comments> list = new BoardService().selectCommentsList(fbNo);
		
		System.out.println("테스트 : " + fboard);
		
		String page = null;
		if(fboard != null) {
			page = "WEB-INF/views/board/boardDetail.jsp";
			request.setAttribute("fboard", fboard);
			request.setAttribute("list", list);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "자유글 상세보기 조회에 실패했습니다.");
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
