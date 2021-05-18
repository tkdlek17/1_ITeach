package grammar.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grammar.service.GrammarService;
import question.model.vo.Board;

/**
 * Servlet implementation class GrammarDetaileServlet
 */
@WebServlet("/detail.gr")
public class GrammarDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrammarDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		Board board = new GrammarService().getGrammar(no);
		ArrayList<Board> list = new GrammarService().getSubList(board.getCateNum());
		
		String page = null;
		
		if(board != null) {
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			page = "WEB-INF/views/grammar/grammarDetail.jsp";
		} else {
			request.setAttribute("msg", "게시글 상세보기에 실패했습니다.");
			page = "WEB-INF/views/common/errorPage.jsp";		
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
