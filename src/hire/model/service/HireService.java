package hire.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import Book.model.dao.BookDAO;
import Book.model.vo.Book;
import hire.model.dao.HireDAO;
import hire.model.vo.Files;
import hire.model.vo.Hire;
import hire.model.vo.PageInfo;


public class HireService {
	HireDAO hireDAO = new HireDAO();

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new HireDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Hire> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Hire> list = new HireDAO().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int insertHireInfo(Hire h, ArrayList<Files> fileList) {
		Connection conn = getConnection();
		HireDAO dao = new HireDAO();
		
		int result1 = dao.insertHireInfo(conn, h);
		int result2 = dao.insertFiles(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result1;
	}

	public Hire selectHireInfo(int no) {
		Connection conn = getConnection();
		HireDAO hDAO = new HireDAO();
		int result = hDAO.updateCount(conn, no);
		Hire h = null;
		
		if(result > 0) {
			h = hDAO.selectHireInfo(conn,no);
			if(h == null) {
				rollback(conn);
			} else {
				commit(conn);
			}
		} else {
			rollback(conn);
		}
		
		return h;
	}

	public ArrayList<Files> selectHireImg(int no) {
		Connection conn = getConnection();
		ArrayList<Files> list = new HireDAO().selectImg(conn, no);
		
		return list;
	}

	public ArrayList selectHList(int i) {
		Connection conn = getConnection();
		ArrayList list = null;
		
		HireDAO hDAO = new HireDAO();
		
		if(i == 1) {
			list = hDAO.selectHList(conn);
		} else {
			list = hDAO.selectFList(conn);
		}
		
		return list;
	}

	public int deleteHire(int no) {
		Connection conn = getConnection();
		int result = new HireDAO().deleteHire(conn, no);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public int searchlistCount(String search, String searchtext) {
		Connection conn = getConnection();
		int listCount = 0;
		
		if(search.equals("hireWriter")) {
			listCount = new HireDAO().SWriterCount(conn, search, searchtext);
		} else if(search.equals("CompanyAd")) {
			listCount = new HireDAO().SCompanyAdCount(conn, search, searchtext);
		} 
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Hire> SselectList(String search, String searchtext, PageInfo pi) {
		Connection conn = getConnection();
		HireDAO dao = new HireDAO();
		
		ArrayList<Hire> list = null;
		
		if(search.equals("hireWriter")) {
			list = dao.SWriterList(conn, search, searchtext, pi);
		} else if(search.equals("CompanyAd")) {
			list = dao.SCompanyAdList(conn, search, searchtext, pi);
		} 
		
		close(conn);
		
		return list;
	}
	
	

}
