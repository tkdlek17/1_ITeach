package license.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import license.model.service.LicenseService;
import license.model.vo.License;
import license.model.vo.PageInfo;

/**
 * Servlet implementation class LicenseListServlet
 */
@WebServlet("/list.li")
public class LicenseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicenseListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("search");
		String searchText = request.getParameter("searchText");
		
		LicenseService lService = new LicenseService();
		
		int listCount;		// 해당 게시판에 대한 총 게시글 개수
		int currentPage;	// 현재 페이지
		int pageLimit;		// 한 페이지에 표시될 페이지 수
		int licenseLimit;		// 한 페이지에 보일 게시글 최대 개수
		int maxPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지
		
		if(searchText == null) {
			listCount = lService.getListCount();
		} else {
			listCount = lService.searchListCount(search, searchText);
		}
		
		System.out.println("검색된 게시글 수 : " + listCount);
		
		currentPage = 1; 
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		licenseLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/licenseLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, licenseLimit, maxPage, startPage, endPage);
		
		// 게시판 전체 데이터 가져오기 
		ArrayList<License> list = null;
				
		if(searchText == null) {
			list = lService.selectLicenseList(pi);
		} else {
			list = lService.sList(search, searchText, pi);
		}
		
		String page = null;
		
		if(list != null) {
			page = "WEB-INF/views/license/licenseList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "기출문제 조회에 실패했습니다.");
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
