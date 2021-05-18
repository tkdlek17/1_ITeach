package question.controller;

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

import common.QuestionFileRenamePolicy;
import member.model.vo.Member;
import question.model.service.QuestionService;
import board.model.vo.Attachment;
import question.model.vo.Board;

/**
 * Servlet implementation class QuestionInsertServlet
 */
@WebServlet("/insert.que")
public class QuestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member member = (Member)request.getSession().getAttribute("loginUser");
		if (ServletFileUpload.isMultipartContent(request) && member != null) {
			int maxSize = 1024 * 1024 * 10; 

			String root = request.getSession().getServletContext().getRealPath("/");

			String savePath = root + "question_uploadFiles/";

			File f = new File(savePath);
			if (!f.exists()) {
				f.mkdirs();
			}

			MultipartRequest multipartRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new QuestionFileRenamePolicy());

			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();

			Enumeration<String> files = multipartRequest.getFileNames();

			while (files.hasMoreElements()) {
				String name = files.nextElement();
				if (multipartRequest.getFilesystemName(name) != null) {
					saveFiles.add(multipartRequest.getFilesystemName(name));
					originFiles.add(multipartRequest.getFilesystemName(name));
				}
			}

			String title = multipartRequest.getParameter("title");
			int cateNum = Integer.parseInt(multipartRequest.getParameter("category"));
			String content = multipartRequest.getParameter("content");

			int memNum = member.getMemNum();
			Board board = new Board();
			board.setBoardTitile(title);
			board.setCateNum(cateNum);
			board.setBoardContent(content);
			board.setMemNum(memNum);
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Attachment at =  new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChageName(saveFiles.get(i));
				
				
				fileList.add(at);
				
			}
			
			QuestionService qService = new QuestionService();
			System.out.println("여기까지 :"+board);
			int result = qService.insertQuestion(board, fileList);
			
			String page = null;
			if (result > 0) {
				response.sendRedirect(request.getContextPath() +"/list.que");
			} else {
				page = "/WEB-INF/views/common/errorPage.jsp";
				request.setAttribute("msg", "질문 작성에 실패했습니다.");
				request.getRequestDispatcher(page).forward(request, response);
			}
		} else {
			String page = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "질문 작성에 실패했습니다.");
			request.getRequestDispatcher(page).forward(request, response);
		}

	}

}
