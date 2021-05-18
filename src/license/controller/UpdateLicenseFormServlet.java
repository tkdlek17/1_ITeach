package license.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import license.model.vo.License;

/**
 * Servlet implementation class UpdateLicenseFormServlet
 */
@WebServlet("/licenseUpdateForm.li")
public class UpdateLicenseFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLicenseFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int li = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String date = request.getParameter("createDate");
		String content = request.getParameter("content");
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String q3 = request.getParameter("q3");
		String q4 = request.getParameter("q4");
		String q5 = request.getParameter("q5");
		int a1 = Integer.parseInt(request.getParameter("a1"));
		int a2 = Integer.parseInt(request.getParameter("a2"));
		int a3 = Integer.parseInt(request.getParameter("a3"));
		int a4 = Integer.parseInt(request.getParameter("a4"));
		int a5 = Integer.parseInt(request.getParameter("a5"));
		
		String dateArr[] = date.split("-");
		int year = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]) - 1;
		int day = Integer.parseInt(dateArr[2]);
		
		Date dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		
		License l = new License();
		l.setLicenseNo(li);
		l.setLicenseTitle(title);
		l.setLicenseWriter(writer);
		l.setLicenseContent(content);
		l.setCreateDate(dat);
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
		
		
		request.setAttribute("l", l);
		request.getRequestDispatcher("WEB-INF/views/license/licenseUpdateForm.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
