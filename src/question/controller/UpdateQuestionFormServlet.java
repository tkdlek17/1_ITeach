package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.vo.Category;
import member.model.vo.Member;
import question.model.service.QuestionService;
import board.model.vo.Attachment;
import question.model.vo.Board;

/**
 * Servlet implementation class UpdateQuestionFormServlet
 */
@WebServlet("/updateForm.que")
public class UpdateQuestionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestionFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int no = Integer.parseInt(request.getParameter("no"));
		QuestionService qService = new QuestionService();
		ArrayList<Attachment> list = qService.getAttachment(no);
		ArrayList<Category> categoryList = qService.selectQuestionCategory();
		Board board = qService.getQuestion(no);
		Member member = (Member) request.getSession().getAttribute("loginUser");
		
		String page = null; 
		if(board != null && (member.getMemNum() == board.getMemNum())) {
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			request.setAttribute("categoryList", categoryList);
			page="/WEB-INF/views/question/updateQuestionForm.jsp";
		} else {
				page="/WEB-INF/views/common/errorPage.jsp";
				request.setAttribute("msg", "질문 수정에 실패했습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
