package license.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import license.model.service.LicenseService;
import license.model.vo.Comments;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertComments
 */
@WebServlet("/insertComments.li")
public class InsertComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNum = Integer.parseInt(request.getParameter("memNum"));
		String writer = request.getParameter("writer");
		int li = Integer.parseInt(request.getParameter("li"));
		String content = request.getParameter("content");
		
		System.out.println("writer : " + writer + "li : " + li + "content : " + content);
		
		Comments c = new Comments();
		c.setMemNick(writer);
		c.setContent(content);
		c.setLicenseNo(li);
		c.setMemNum(memNum);
		
		
		ArrayList<Comments> list = new LicenseService().insertComments(c);
		
		
		response.setContentType("application/json; charset=UTF-8");
		
		GsonBuilder gb = new GsonBuilder();
		GsonBuilder gbDate = gb.setDateFormat("yyyy-MM-dd");
		Gson gson = gbDate.create();
		gson.toJson(list, response.getWriter());
		
		System.out.println(list);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
