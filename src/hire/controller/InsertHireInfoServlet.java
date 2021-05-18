package hire.controller;

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

import common.MyFileRenamePolicy;
import hire.model.service.HireService;
import hire.model.vo.Files;
import hire.model.vo.Hire;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertHireInfoServlet
 */
@WebServlet("/insert.hire")
public class InsertHireInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertHireInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024*1024*10; // 전송파일 용량 : 10Mbyte
			
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "thumbnail_uploadFiles/";
			//System.out.println(savePath);
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			MultipartRequest multipartRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();   // 바뀐 이름의 파일을 저장할 용도
			ArrayList<String> originFiles = new ArrayList<String>(); // 원본 이름의 파일을 저장할 용도
			
			Enumeration<String> files = multipartRequest.getFileNames(); // getFileNames() : 폼에서 전송된 파일 리스트들의 name 반환
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				if(multipartRequest.getFilesystemName(name) != null) {
					saveFiles.add(multipartRequest.getFilesystemName(name));
					originFiles.add(multipartRequest.getOriginalFileName(name));
				}
			}
			
			String hireCompany = multipartRequest.getParameter("hireCompany");
			String hireName = multipartRequest.getParameter("hireName");
			String hireEmail = multipartRequest.getParameter("hireEmail");
			String hireField = multipartRequest.getParameter("hireField");
			int employNum = Integer.parseInt(multipartRequest.getParameter("employNum").trim());
			String hireDate = multipartRequest.getParameter("hireDate");
			String companyAddress = multipartRequest.getParameter("companyAddress");
			String writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNick();
			Date dat = null;
			if(hireDate.equals("")) {
				// 날짜를 입력하지 않으면 오늘 날짜로 채용일 지정
				dat = new Date(new GregorianCalendar().getTimeInMillis());
			} else {
				String[] dateArr = hireDate.split("-");
				
				int year = Integer.parseInt(dateArr[0]);
				int month = Integer.parseInt(dateArr[1])-1;
				int day = Integer.parseInt(dateArr[2]);
				
				dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			}
			
			System.out.println(employNum);
			
			//h.setCateNo(50);
			// 운영자로 작성
			Hire h = new Hire(hireCompany, hireName, hireEmail, hireField, employNum, dat, companyAddress, writer,50);
			
			ArrayList<Files> fileList = new ArrayList<Files>();
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Files fi = new Files();
				fi.setFilePath(savePath);
				fi.setFileName(originFiles.get(i));
				fi.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() - 1) {
					fi.setFileLevel(0);
				}else {
					fi.setFileLevel(1);
				}
				
				fileList.add(fi);
			}
			
			int result = new HireService().insertHireInfo(h, fileList);
			
			if(result > 0) {
				response.sendRedirect("list.hire");
			} else {
				request.setAttribute("msg", "채용공고 등록에 실패하였습니다.");
				// 실패했을 경우 파일에 저장된 사진들을 지워줌
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
