package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.vo.Category;
import common.service.CommonService;
import question.model.service.QuestionService;
import question.model.vo.Board;

/**
 * Servlet implementation class QuestionSubCategoryServlet
 */
@WebServlet("/subList.que")
public class QuestionSubCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionSubCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int categoryNo = Integer.parseInt(request.getParameter("no"));
//		ArrayList<Board> list = new QuestionService();
//		ArrayList<Category> categoryList = new CommonService().getCategory(10);
//		String page = null;
//		if(list != null) {
//			request.setAttribute("list", list);
//			request.setAttribute("categoryList", categoryList);
//			request.setAttribute("categoryNo", categoryNo);
//			page = "WEB-INF/views/question/questionSubList.jsp";
//			
//		} else {
//			page = "WEB-INF/views/common/errorPage.jsp";
//			request.setAttribute("msg", "게시글 목록 조회에 실패하였습니다.");
//		}
//		
//		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
