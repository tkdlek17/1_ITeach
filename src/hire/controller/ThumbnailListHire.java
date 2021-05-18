package hire.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import hire.model.service.HireService;
import hire.model.vo.Files;
import hire.model.vo.Hire;

/**
 * Servlet implementation class ThumbnailListHire
 */
@WebServlet("/ThumbnailListHire")
public class ThumbnailListHire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailListHire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HireService hService = new HireService();
		
		ArrayList<Hire> hList = hService.selectHList(1); // 게시판 리스트용
		ArrayList<Files> fList = hService.selectHList(2); // 사진 파일 리스트용
		
		//String page = null;
		if(hList != null && fList != null) {
			/*
			 * request.setAttribute("hList", hList); request.setAttribute("fList", fList);
			 * page = "WEB-INF/views/common/mainPage.jsp";
			 */
			response.setContentType("application/json; charset=UTF-8");
			
			JSONArray jArray = new JSONArray();
			JSONObject jObject = null;
			
			for(Hire hire : hList) {
				for(Files files : fList) {
					if(files.getHireNo() == hire.getHireNo()) {
						jObject = new JSONObject();
						
						jObject.put("hireCompany", hire.getHireCompany());
						jObject.put("hireNo", files.getHireNo());
						jObject.put("changeName", files.getChangeName());
						jArray.add(jObject);
						
					}
				}
			}
			
			PrintWriter out = response.getWriter();
			out.println(jArray);
			
			
			
		} else {
			request.setAttribute("msg", "사진 조회에 실패했습니다.");
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
