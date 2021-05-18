package question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import member.model.vo.Member;
import question.model.service.QuestionService;
import question.model.vo.Answer;

/**
 * Servlet implementation class answertInsertServlet
 */
@WebServlet("/insertAnswer")
public class AnswertInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnswertInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int qno = Integer.parseInt(request.getParameter("qno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("loginUser");

		if (member != null) {
			Answer answer = new Answer();
			answer.setAnswerTitle(title);
			answer.setContent(content);
			answer.setBoardNo(qno);
			answer.setWriter(member.getMemNum());
			int result = new QuestionService().insertAnswer(answer);
			Gson gson = new Gson();
			JSONObject json = new JSONObject();
			JSONObject list = new JSONObject();
			json.put("result", result);
			list.put("list", json);
			gson.toJson(list, response.getWriter());
		} else {
			response.sendRedirect("");
		}

	}

}
