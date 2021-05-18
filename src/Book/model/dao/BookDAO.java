package Book.model.dao;

import static common.JDBCTemplate.close;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import Book.model.vo.Book;
import Book.model.vo.Comment;
import Book.model.vo.Files;
import Book.model.vo.Likes;
import Book.model.vo.PageInfo;
import board.model.vo.Attachment;



public class BookDAO {
	private Properties prop = new Properties();
	
	public BookDAO() {
		String fileName = BookDAO.class.getResource("/sql/book-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt =null;
		ResultSet rset =null;
		ArrayList<Book> list = new ArrayList<Book>();
		
		String query = prop.getProperty("selectList");
		
		try {
			
			int starRow = (pi.getCurrentPage()-1 )*pi.getBoardLimit() +1;
			int endRow = starRow + pi.getBoardLimit() -1;
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, starRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Book>();
			
			while(rset.next()) {
				Book book = new Book(rset.getInt("BOOK_NO"),
									 rset.getString("BOOK_TITLE"),
									 rset.getString("BOOK_CONTENT"),
									 rset.getString("BOOK_AUTHOR"),
									 rset.getString("BOOK_COMPANY"),
									 rset.getString("MEM_NICK"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	public ArrayList<Book> selectSearchList(Connection conn) {
	      Statement stmt =null;
	      ResultSet rset =null;
	      ArrayList<Book> list = new ArrayList<Book>();
	      
	      String query = prop.getProperty("selectSearchList");
	      
	      try {
	         stmt = conn.createStatement();
	         rset = stmt.executeQuery(query);
	         
	         while(rset.next()) {
	            Book book = new Book(rset.getInt("BOOK_NO"),
	                            rset.getString("BOOK_TITLE"),
	                            rset.getString("BOOK_CONTENT"),
	                            rset.getString("BOOK_AUTHOR"),
	                            rset.getString("BOOK_COMPANY"),
	                            rset.getString("MEM_NICK"));
	            list.add(book);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(stmt);
	      }

	      return list;
	   }

	public int insertBook(Connection conn, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBook");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBookTitle());
			pstmt.setString(2, b.getBookContent());
			pstmt.setString(3, b.getBookAuthor());
			pstmt.setString(4, b.getBookCompany());
			pstmt.setInt(5, b.getMemNum());
			result = pstmt.executeUpdate();
			
			System.out.println("author"+b.getBookAuthor());
			System.out.println("company"+b.getBookCompany());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public Book selectBook(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book book = null;
		
		String query = prop.getProperty("selectBook");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book(rset.getInt("BOOK_NO"),
								rset.getString("BOOK_TITLE"),
								rset.getString("BOOK_CONTENT"),
								rset.getString("BOOK_AUTHOR"),
								rset.getString("BOOK_COMPANY"),
								rset.getInt("BOOK_COUNT"),
								rset.getString("MEM_NICK"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}

	public int updateCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ;
	}

	public ArrayList<Files> selectFList(Connection conn) {
			Statement stmt = null;
			ResultSet rset = null;
			ArrayList<Files> list= null;
			
			String query = prop.getProperty("selectFList");
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				list = new ArrayList<Files>();
				while(rset.next()) {
					list.add(new Files (rset.getInt("BOOK_NO"),
										rset.getString("CHANGE_NAME")));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(stmt);
			}
			
		
		return list;
	}

	public int insertBookimg(Connection conn, ArrayList<Files> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBookimg");
		
			try {
				
				Files f = fileList.get(0);
					
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, f.getFileName());
				pstmt.setString(2, f.getFilePath());
				pstmt.setString(3, f.getChangeName());
				pstmt.setInt(4, f.getFileLevel());
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
		}
		return result;
	}

	public ArrayList<Files> selectBookimg(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Files> flist = null;
		
		String query = prop.getProperty("selectBookimg");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			flist = new ArrayList<Files>();
			while(rset.next()) {
				Files f = new Files();
				f.setFileNo(rset.getInt("FILE_NO"));
				f.setFileName(rset.getString("FILE_NAME"));
				f.setFilePath(rset.getString("FILE_PATH"));
				f.setChangeName(rset.getString("CHANGE_NAME"));
				f.setFilePath(rset.getString("FILE_PATH"));
				
				flist.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return flist;
	}

	public int deleteBook(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBook");
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Book> selectmainList(Connection conn) {
		Statement stmt =null;
		ResultSet rset =null;
		ArrayList<Book> list = new ArrayList<Book>();
		
		String query = prop.getProperty("selectmainList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book book = new Book(rset.getInt("BOOK_NO"),
									 rset.getString("BOOK_TITLE"),
									 rset.getString("BOOK_CONTENT"),
									 rset.getString("BOOK_AUTHOR"),
									 rset.getString("BOOK_COMPANY"),
									 rset.getString("MEM_NICK"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public ArrayList<Comment> selectcomment(Connection conn, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<Comment> list = null;
		
		String query = prop.getProperty("selectcomment");
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1,  no);
			
			rset =pstmt.executeQuery();
			list = new ArrayList<Comment>();
			while(rset.next()) {
				list.add(new Comment (rset.getInt("COMMENT_NO"),
										rset.getString("CONTENT"),
										rset.getString("MEM_NICK"),
										rset.getInt("BOOK_NO"),
										rset.getDate("COMMENT_CREATE_AT")));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
	
		
		return list;
	}

	public int insertComment(Connection conn, Comment com) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com.getContent());
			pstmt.setInt(2, com.getmemNum());
			pstmt.setInt(3, com.getBookNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int getListCount(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return result;
	}

	public int StitleCount(Connection conn, String search, String searchtext) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("StitleCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+searchtext+"%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int SContentCount(Connection conn, String search, String searchtext) {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			int result = 0;
			
			String query = prop.getProperty("SContentCount");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,"%"+searchtext+"%");
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					result = rset.getInt(1);
				}
		
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return result;
		}

	public int SAuthorCount(Connection conn, String search, String searchtext) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("SAuthorCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+searchtext+"%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	

	 public ArrayList<Book> STitleList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt =null;
		ResultSet rset =null;
		ArrayList<Book> list = new ArrayList<Book>();
		
		String query = prop.getProperty("STitleList");
		
		try {
			
			int starRow = (pi.getCurrentPage()-1 )*pi.getBoardLimit() +1;
			int endRow = starRow + pi.getMaxPage() * pi.getBoardLimit();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, starRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Book>();
			while(rset.next()) {
				Book book = new Book(rset.getInt("BOOK_NO"),
									 rset.getString("BOOK_TITLE"),
									 rset.getString("BOOK_CONTENT"),
									 rset.getString("BOOK_AUTHOR"),
									 rset.getString("BOOK_COMPANY"),
									 rset.getString("MEM_NICK"));
				list.add(book);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		 return list;
	}

	 public ArrayList<Book> SContentList(Connection conn, String search, String searchtext, PageInfo pi) {
			PreparedStatement pstmt =null;
			ResultSet rset =null;
			ArrayList<Book> list = new ArrayList<Book>();
			
			String query = prop.getProperty("SContentList");
			
			try {
				
				int starRow = (pi.getCurrentPage()-1 )*pi.getBoardLimit() +1;
				
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, starRow);
				pstmt.setInt(2, pi.getAllCount());
				pstmt.setString(3, "%"+searchtext+"%");
				
				rset = pstmt.executeQuery();
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book book = new Book(rset.getInt("BOOK_NO"),
										 rset.getString("BOOK_TITLE"),
										 rset.getString("BOOK_CONTENT"),
										 rset.getString("BOOK_COMPANY"),
										 rset.getString("BOOK_AUTHOR"),
										 rset.getString("MEM_NICK"));
					list.add(book);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			 return list;
		}

	 public ArrayList<Book> SAuthorList(Connection conn, String search, String searchtext, PageInfo pi) {
			PreparedStatement pstmt =null;
			ResultSet rset =null;
			ArrayList<Book> list = new ArrayList<Book>();
			
			String query = prop.getProperty("SAuthorList");
			
			try {
				
				int starRow = (pi.getCurrentPage()-1 )*pi.getBoardLimit() +1;
				
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, starRow);
				pstmt.setInt(2, pi.getAllCount());
				pstmt.setString(3, "%"+searchtext+"%");
				
				System.out.println( "end"+  pi.getAllCount());
				rset = pstmt.executeQuery();
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book book = new Book(rset.getInt("BOOK_NO"),
										 rset.getString("BOOK_TITLE"),
										 rset.getString("BOOK_CONTENT"),
										 rset.getString("BOOK_COMPANY"),
										 rset.getString("BOOK_AUTHOR"),
										 rset.getString("MEM_NICK"));
					list.add(book);
				}
				
		
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			 return list;
		}

	public int checkLike(Connection conn, Likes likes) {
		PreparedStatement pstmt =null;
		ResultSet rset =null;
		int result =0;
		
		String query = prop.getProperty("checkLike");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, likes.getBookNo());
			pstmt.setInt(2, likes.getMemNum());
			rset = pstmt.executeQuery();
					
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	
		
	public int bookLikeCountUpdate(Connection conn, Likes likes) {
		PreparedStatement pstmt =null;
		int result = 0;
		
		String query = prop.getProperty("bookLikeCountUpdate");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, likes.getBookNo());
			pstmt.setInt(2, likes.getMemNum());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int bookLikeCountDelete(Connection conn, Likes likes) {
		PreparedStatement pstmt =null;
		int result = 0;
		
		String query = prop.getProperty("bookLikeCountDelete");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, likes.getBookNo());
			pstmt.setInt(2, likes.getMemNum());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

	public int bookLikeCount(Connection conn, int bookNo) {
		PreparedStatement pstmt =null;
		ResultSet rset= null;
		int result = 0;
		String query = prop.getProperty("bookLikeCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return result;
	}

	
}
