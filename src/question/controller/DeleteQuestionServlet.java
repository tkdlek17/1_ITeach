package question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import question.model.service.QuestionService;
import question.model.vo.Board;

/**
 * Servlet implementation class DeleteQuestionServlet
 */
@WebServlet("/delete.que")
public class DeleteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Member member = (Member)request.getSession().getAttribute("loginUser");
		Board board = new QuestionService().getQuestion(no);
		int result = 0;
		if(member != null && member.getMemNum() == board.getMemNum()) {
			result = new QuestionService().deleteQuestion(no);			
		}
		
		String page = null;
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/list.que");
		} else {
			request.setAttribute("msg", "질문 삭제에 실패했습니다.");
			page = "WEB-INF/views/common/errorPage.jsp";
			request.getRequestDispatcher(page).forward(request, response);
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
