package grammar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grammar.model.vo.Grammar;
import grammar.service.GrammarService;
import member.model.vo.Member;
import question.model.service.QuestionService;
import question.model.vo.Board;

/**
 * Servlet implementation class GrammarInsertServlet
 */
@WebServlet("/insert.gr")
public class GrammarInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrammarInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title= request.getParameter("title");
		int category = Integer.parseInt(request.getParameter("category"));
		String content = request.getParameter("content");
		
		Member member = (Member)request.getSession().getAttribute("loginUser");
		
		Board board = new Board();
		board.setBoardTitile(title);
		board.setCateNum(category);
		board.setBoardContent(content);
		board.setMemNum(member.getMemNum());
		
		
		int result = new GrammarService().insertGrammar(board);
		String page = null;
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/main.gr");
		} else {
			page="/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 작성에 실패했습니다.");
			request.getRequestDispatcher(page).forward(request, response);
		}
		
	}

}
