package license.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.vo.Files;
import license.model.service.LicenseService;
import license.model.vo.Comments;
import license.model.vo.License;

/**
 * Servlet implementation class DetailLicenseServlet
 */
@WebServlet("/detail.li")
public class DetailLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailLicenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int li = Integer.parseInt(request.getParameter("li"));
		
		License license = new LicenseService().selectLicense(li);
		
		
		ArrayList<Files> fileList = new LicenseService().selectFiles(li);
		
		ArrayList<Comments> list = new LicenseService().selectCommentsList(li);
		
		String page = null;
		if(license != null) {
			request.setAttribute("license", license);
			request.setAttribute("fileList", fileList);
			request.setAttribute("list", list);
			System.out.println(list);
			page = "WEB-INF/views/license/licenseDetail.jsp";
		} else {
			request.setAttribute("msg", "기출문제 게시판 상세보기에 실패했습니다.");
			page = "WEB-INF/views/common/errorPage.jsp";
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
