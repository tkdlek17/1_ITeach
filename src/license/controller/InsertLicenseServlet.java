package license.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.vo.Files;
import common.MyFileRenamePolicy;
import license.model.service.LicenseService;
import license.model.vo.License;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertLicenseServlet
 */
@WebServlet("/insertLicense.li")
public class InsertLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLicenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 50; 
			String root = request.getSession().getServletContext().getRealPath("/"); 
			String savePath = root + "license_uploadFiles/";  
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs(); 	
			}
	
			MultipartRequest multipartRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());	
																											
			ArrayList<String> saveFiles = new ArrayList<String>();		// 바뀐 이름의 파일을 저장할 용도
			ArrayList<String> originFiles = new ArrayList<String>(); 	// 원본 이름의 파일을 저장할 용도
			
			Enumeration<String> files = multipartRequest.getFileNames(); 
											
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				if(multipartRequest.getFilesystemName(name) != null) {
					saveFiles.add(multipartRequest.getFilesystemName(name));
					originFiles.add(multipartRequest.getOriginalFileName(name));
				}
			}
			
			
			String title = multipartRequest.getParameter("title");
			String writer = ((Member)(request.getSession().getAttribute("loginUser"))).getMemId();
			String content = multipartRequest.getParameter("content");
			String date = multipartRequest.getParameter("date");
			int answer1 = Integer.parseInt(multipartRequest.getParameter("chk_info1"));
			int answer2 = Integer.parseInt(multipartRequest.getParameter("chk_info2"));
			int answer3 = Integer.parseInt(multipartRequest.getParameter("chk_info3"));
			int answer4 = Integer.parseInt(multipartRequest.getParameter("chk_info4"));
			int answer5 = Integer.parseInt(multipartRequest.getParameter("chk_info5"));
			String q1 = multipartRequest.getParameter("q1");
			String q2 = multipartRequest.getParameter("q2");
			String q3 = multipartRequest.getParameter("q3");
			String q4 = multipartRequest.getParameter("q4");
			String q5 = multipartRequest.getParameter("q5");
			
			
			Date dat = null;
			
			if(date.equals("")) {
				dat = new Date(new GregorianCalendar().getTimeInMillis());
			} else {
				String[] dateArr = date.split("-");
				int year = Integer.parseInt(dateArr[0]);
				int month = Integer.parseInt(dateArr[1])-1;
				int day = Integer.parseInt(dateArr[2]);
				
				dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			}
			
			License l = new License();
			l.setLicenseTitle(title);
			l.setLicenseWriter(writer);
			l.setLicenseContent(content);
			l.setCreateDate(dat);
			l.setAnswer1(answer1);
			l.setAnswer2(answer2);
			l.setAnswer3(answer3);
			l.setAnswer4(answer4);
			l.setAnswer5(answer5);
			l.setQuestion1(q1);
			l.setQuestion2(q2);
			l.setQuestion3(q3);
			l.setQuestion4(q4);
			l.setQuestion5(q5);
			
			ArrayList<Files> fileList = new ArrayList<Files>();
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				// 위에서 파일이 거꾸로 4, 3, 2, 1로 출력되는 상황 해결해주기
				Files fi = new Files();
				fi.setFilePath(savePath);
				fi.setFileName(originFiles.get(i));
				fi.setChangeName(saveFiles.get(i));
				fi.setFileLevel(1);
				
				fileList.add(fi);
				
			}
			
			int result = new LicenseService().insertLicense(l, fileList);
			
			if(result > 0) {
				response.sendRedirect("list.li"); // 목록으로
			} else {
				request.setAttribute("msg", "사진 게시판 등록에 실패하였습니다");
				
				for(int i = 0; i < saveFiles.size(); i++) {
					File fail = new File(savePath + saveFiles.get(i));
					fail.delete();
				}
				
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
			
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
