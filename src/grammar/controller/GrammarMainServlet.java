package grammar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.vo.Category;
import common.service.CommonService;
import grammar.service.GrammarService;
import question.model.vo.Board;

/**
 * Servlet implementation class GrammarMainServlet
 */
@WebServlet("/main.gr")
public class GrammarMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrammarMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> cList = new CommonService().getCategory(20);
		HashMap<String, ArrayList<Board>> map = new HashMap<String, ArrayList<Board>>();
		System.out.println(map);
		GrammarService gService = new GrammarService();
		for(Category c: cList) {
			ArrayList<Board> subList = gService.getSubList(c.getCateNo());
			map.put(c.getCateName(), subList);
		}
		
		String page = null;
		if(map != null) {
			
			request.setAttribute("map", map);
			page="/WEB-INF/views/grammar/grammarMain.jsp";
			 
		} else {
			request.setAttribute("msg", "조회에 실패했습니다.");
			page ="/WEB-INF/views/common/errorPage.jsp";
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
