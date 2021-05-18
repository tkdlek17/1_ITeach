package grammar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import grammar.service.GrammarService;
import question.model.vo.Board;

/**
 * Servlet implementation class updateGrammarServlet
 */
@WebServlet("/update.gr")
public class UpdateGrammarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGrammarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		int no = Integer.parseInt(request.getParameter("no"));
		int category = Integer.parseInt(request.getParameter("category"));
		String content = request.getParameter("content");
		Member member = (Member)request.getSession().getAttribute("loginMember");
		int result = 0;
		Board board = null;
		if(member != null && member.getIsStaff().equals("Y")) {
			board = new Board();
			board.setBoardTitile(title);
			board.setBoardContent(content);
			board.setBoardNo(no);
			board.setCateNum(category);
			result = new GrammarService().updateGrammar(board);
		}
		
		String page = null;
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/detail.gr?no="+board.getBoardNo());
		} else {
			request.setAttribute("msg", "수정에 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/erroPage.jsp");
		}
		
	}

}
