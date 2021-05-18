package hire.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hire.model.service.HireService;
import hire.model.vo.Files;
import hire.model.vo.Hire;

/**
 * Servlet implementation class DetailHireInfo
 */
@WebServlet("/detail.hire")
public class DetailHireInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailHireInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		HireService service = new HireService();
		
		Hire hire = service.selectHireInfo(no);
		ArrayList<Files> fileList = service.selectHireImg(no);
		
		String page = null;
		if(fileList != null) {
			request.setAttribute("hire", hire);
			request.setAttribute("fileList", fileList);
			page = "WEB-INF/views/hireBoard/hireDetail.jsp";
			
		}else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "채용공고  상세보기에 실패했습니다.");
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
