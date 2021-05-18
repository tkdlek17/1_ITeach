package grammar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grammar.service.GrammarService;
import member.model.vo.Member;
import question.model.vo.Board;

/**
 * Servlet implementation class DeleteGrammarServlet
 */
@WebServlet("/delete.gr")
public class DeleteGrammarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGrammarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Member loginMember = (Member)request.getSession().getAttribute("loginUser");
		int result = 0;
		Board board =new GrammarService().getGrammar(no);
		
		if(loginMember != null && loginMember.getIsStaff().equals("Y")) {
			result = new GrammarService().deleteGrammar(no);
		}
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/main.gr");
			
		} else {
			request.setAttribute("msg", "게시글 삭제에 실패했습니다.");
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
