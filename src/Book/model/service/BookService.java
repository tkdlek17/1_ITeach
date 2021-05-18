package Book.model.service;

import static common.JDBCTemplate.*;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



import Book.model.vo.Book;
import Book.model.vo.Comment;
import Book.model.vo.Files;
import Book.model.vo.Likes;
import Book.model.vo.PageInfo;
import Book.model.dao.BookDAO;



public class BookService {
	
	public ArrayList<Book> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Book> list = new BookDAO().selectList(conn, pi);

		close(conn);
		
		return list;
	}
	
	public ArrayList<Book> selectSearchList() {
		Connection conn = getConnection();
		
		ArrayList<Book> list = new BookDAO().selectSearchList(conn);

		close(conn);
		
		return list;
	}
	
	public int insertBook(Book b, ArrayList<Files> fileList) {
		Connection conn = getConnection();
		
		BookDAO bdao = new  BookDAO();
		int result1 = bdao.insertBook(conn, b);
		int result2 = bdao.insertBookimg(conn, fileList);

		if(result1 > 0 && result2 > 0 ) { 
			commit(conn);
			
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result1 ;
	}
	

	public Book selectBook(int no) {
		Connection conn = getConnection();
		
		BookDAO bDAO = new BookDAO();
		
		int result = bDAO.updateCount(conn, no); //조회수 

		Book b = null;
		
		if(result > 0 ) {
			b = bDAO.selectBook(conn , no);
			 if(b != null) {
				 commit(conn);
			 } else {
				 rollback(conn);
			 }
		} else {
			rollback(conn);
		}
		
		close(conn);
		return b;
	}

	public ArrayList<Files> selectFList() {
		Connection conn = getConnection();
		
		ArrayList<Files> list = new BookDAO().selectFList(conn);
		
		close(conn);
		return list;
	}
	public ArrayList<Files> selectBookimg(int no) {
		Connection conn = getConnection();
		
		ArrayList<Files> flist = new BookDAO().selectBookimg(conn, no);
		
		
		close(conn);
		return flist;
	}
	public int deleteBook(int no) {
		Connection conn = getConnection();
		
		int result = new BookDAO().deleteBook(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else { 
			rollback(conn);
		}
		
		close(conn);
		
		return result ;
	}

	public ArrayList<Book> selectmainList() {
		Connection conn = getConnection();
		
		ArrayList<Book> list = new BookDAO().selectmainList(conn);

		close(conn);
		
		return list;
	}

	public ArrayList<Comment> selectcomment(int no) {
		Connection conn = getConnection();
		
		ArrayList<Comment> list = new BookDAO().selectcomment(conn, no);
		
		
		return list;
	}
	public ArrayList<Comment> insertComment(Comment com) {

		Connection conn = getConnection();
		BookDAO dao = new BookDAO();
		
		int result = dao.insertComment(conn, com);
		
		ArrayList<Comment> list = null;
		if(result > 0) {
			commit(conn);
			list = dao.selectcomment(conn, com.getBookNo());
		} else {
			rollback(conn);
		}
		
		return list;
	}
	public  int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new BookDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public  int searchlistCount(String search, String searchtext) {
		Connection conn = getConnection();
		int listCount = 0;
		
		if(search.equals("book_title")) {
			listCount = new BookDAO().StitleCount(conn, search, searchtext);
		} else if(search.equals("book_content")) {
			listCount = new BookDAO().SContentCount(conn, search, searchtext);
		} else if(search.equals("book_author")) {
			listCount = new BookDAO().SAuthorCount(conn, search, searchtext);
		}
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Book> SList(String search, String searchtext, PageInfo pi ) {
		Connection conn = getConnection();
		BookDAO dao = new BookDAO();
		
		ArrayList<Book> list = null;
		
		if(search.equals("book_title")) {
			list = dao.STitleList(conn, search, searchtext, pi);
		} else if(search.equals("book_content")) {
			list = dao.SContentList(conn, search, searchtext, pi);
		} else if(search.equals("book_author")) {
			list = dao.SAuthorList(conn, search, searchtext, pi);
		}
		
		close(conn);
		
		return list;
	}

	public int checkLike(Likes likes) {
		Connection conn = getConnection();
		
		int result = new BookDAO().checkLike(conn, likes);
		
		System.out.println("check result" + result);
		
		close(conn);
		
		return result;
	}


	public void bookLikeCountDelete(Likes likes) {
		Connection conn = getConnection();
		int result = new BookDAO().bookLikeCountDelete(conn, likes);
		
		if(result > 0) {
			commit(conn);
		} else { 
			rollback(conn);
		}
		
		close(conn);
	}

	public void bookLikeCountUpdate(Likes likes) {
		Connection conn = getConnection();
		int result = new BookDAO().bookLikeCountUpdate(conn, likes);
		
		if(result > 0) {
			commit(conn);
		} else { 
			rollback(conn);
		}
		
		close(conn);
		
	}



	public int bookLikeCount(int bookNo) {
		Connection conn = getConnection();
		int result = new BookDAO().bookLikeCount(conn, bookNo);
		
		if(result > 0) {
			commit(conn);
		} else { 
			rollback(conn);
		}
		
		close(conn);
		
		return result;		
	}
	

	

}
