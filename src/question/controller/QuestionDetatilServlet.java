package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.model.service.QuestionService;
import board.model.vo.Attachment;
import common.model.vo.Category;
import common.service.CommonService;
import question.model.vo.Board;

/**
 * Servlet implementation class QuestionDetatilServlet
 */
@WebServlet("/detail.que")
public class QuestionDetatilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetatilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		QuestionService qService = new QuestionService();
		Board board = qService.getQuestion(no);
		String page = null;
		
		ArrayList<Attachment> list = qService.getAttachment(no); 
		ArrayList<Category> cList = new CommonService().getCategory(10);
				
		if(board != null) {
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			request.setAttribute("cList", cList);
			page="/WEB-INF/views/question/questionDetail.jsp";
		} else {
			page="WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "질문 상세보기에 실패했습니다.");
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
