package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.dao.CommonDAO;
import common.model.vo.Category;
import common.service.CommonService;
import member.model.vo.Member;
import question.model.service.QuestionService;

/**
 * Servlet implementation class QuestionInsertServlet
 */
@WebServlet("/insertForm.que")
public class QuestionInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsertFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginMember = (Member)request.getSession().getAttribute("loginUser");
		if(loginMember != null) {
			ArrayList<Category> categoryList = new CommonService().getCategory(10);
			System.out.println(categoryList);
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("/WEB-INF/views/question/insertQuestionForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Login.me").forward(request, response);
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
