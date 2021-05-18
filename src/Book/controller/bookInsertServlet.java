package Book.controller;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import Book.model.service.BookService;
import Book.model.vo.Book;
import Book.model.vo.Files;
import common.MyFileRenamePolicy;
import member.model.vo.Member;


/**
 * Servlet implementation class bookInsert
 */
@WebServlet("/insertbook.bo")
public class bookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	if(ServletFileUpload.isMultipartContent(request)) {
		
		int maxSize = 1024*1024*10;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "image_uploadFiles/";
		
		File f = new File(savePath);
		if(!f.exists()) {
			f.mkdirs();
		}
			
		
			MultipartRequest multipartRequest = new MultipartRequest(request, savePath,maxSize, "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();
			
			Enumeration<String> file= multipartRequest.getFileNames(); //폼에서 받아온 파일 리스트
			while(file.hasMoreElements()) {
				String name = file.nextElement();
				
				if(multipartRequest.getFilesystemName(name)!= null) {
					saveFiles.add(multipartRequest.getFilesystemName(name));
					originFiles.add(multipartRequest.getOriginalFileName(name));
				}
			}
			
			String title = multipartRequest.getParameter("title");
			String content  = multipartRequest.getParameter("content");
			String author = multipartRequest.getParameter("author");
			String company = multipartRequest.getParameter("company");
			int memnum =((Member)request.getSession().getAttribute("loginUser")).getMemNum();
			System.out.println("저자" +author);		
			System.out.println("츨핀" +company);	
			Book b = new Book(title, content, author, company, memnum);

			ArrayList<Files> fileList = new ArrayList<Files>();
			for(int i = originFiles.size()-1; i >= 0; i--) {
				Files files = new Files();
				files.setFilePath(savePath);
				files.setFileName(originFiles.get(i));
				files.setChangeName(saveFiles.get(i));
			
				fileList.add(files);
				
				if(i == originFiles.size() -1) {
					files.setFileLevel(0);
				} else { 
					files.setFileLevel(1);
				}
				fileList.add(files);
			}
			System.out.println(fileList);
			int result = new BookService().insertBook(b, fileList);	
			
			if(result > 0) {
				response.sendRedirect("bookListServlet");
			} else { 
				request.setAttribute("msg", "서적게시판 등록에 실패하였습니다.");
				for(int i = 0; i < saveFiles.size(); i++) {
					File fail = new File(savePath + saveFiles.get(i));
					fail.delete();
				}
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
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
