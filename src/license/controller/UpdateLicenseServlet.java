package license.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import license.model.service.LicenseService;
import license.model.vo.License;

/**
 * Servlet implementation class UpdateLicenseServlet
 */
@WebServlet("/licenseUpdate.li")
public class UpdateLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLicenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int li = Integer.parseInt(request.getParameter("li"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String q3 = request.getParameter("q3");
		String q4 = request.getParameter("q4");
		String q5 = request.getParameter("q5");
		int a1 = Integer.parseInt(request.getParameter("chk_info1"));
		int a2 = Integer.parseInt(request.getParameter("chk_info2"));
		int a3 = Integer.parseInt(request.getParameter("chk_info3"));
		int a4 = Integer.parseInt(request.getParameter("chk_info4"));
		int a5 = Integer.parseInt(request.getParameter("chk_info5"));
		
		
		License l = new License();
		l.setLicenseNo(li);
		l.setLicenseTitle(title);
		l.setLicenseWriter(writer);
		l.setLicenseContent(content);
		l.setAnswer1(a1);
		l.setAnswer2(a2);
		l.setAnswer3(a3);
		l.setAnswer4(a4);
		l.setAnswer5(a5);
		l.setQuestion1(q1);
		l.setQuestion2(q2);
		l.setQuestion3(q3);
		l.setQuestion4(q4);
		l.setQuestion5(q5);
		
		System.out.println("update : " + l);
		
		int result = new LicenseService().updateLicense(l);
		
		if(result > 0) {
			response.sendRedirect("detail.li?li=" + li);
		} else {
			request.setAttribute("msg", "기출문제 게시글 수정을 실패했습니다.");
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
