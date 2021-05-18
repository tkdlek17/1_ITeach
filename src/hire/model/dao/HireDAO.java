package hire.model.dao;

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
import hire.model.vo.Files;
import hire.model.vo.Hire;
import hire.model.vo.PageInfo;

import static common.JDBCTemplate.*;

public class HireDAO {
	private Properties prop = new Properties();
	
	public HireDAO() {
		String filePath = HireDAO.class.getResource("/sql/hire-query.properties").getPath();
	
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public ArrayList<Hire> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Hire> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Hire>();
			while(rset.next()) {
				Hire hire = new Hire(rset.getInt("HIRE_NO"),
									 rset.getString("HIRE_COMPANY"),
									 rset.getString("HIRE_NAME"),
									 rset.getString("HIRE_EMAIL"),
									 rset.getString("HIRE_FIELD"),
									 rset.getInt("EMPLOY_NUM"),
									 rset.getDate("HIRE_DATE"),
									 rset.getString("COMPANY_ADDRESS"),
									 rset.getString("WRITER"),
									 rset.getInt("VIEW_COUNT"),
									 rset.getString("HIRE_YN"),
									 rset.getDate("CREATE_DATE"),
									 rset.getString("STATUS"),
									 rset.getInt("CATE_NO"));
				list.add(hire);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertHireInfo(Connection conn, Hire h) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertHireInfo");
		
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, h.getHireCompany());
			pstmt.setString(2, h.getHireName());
			pstmt.setString(3, h.getHireEmail());
			pstmt.setString(4, h.getHireField());
			pstmt.setInt(5, h.getEmployNum());
			pstmt.setDate(6, h.getHireDate());
			pstmt.setString(7, h.getCompanyAddress());
			pstmt.setString(8, h.getWriter());
			pstmt.setInt(9, h.getCateNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertFiles(Connection conn, ArrayList<Files> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFiles");

		try {
			for(int i = 0; i < fileList.size(); i++) {
				Files fi = fileList.get(i);
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, fi.getFileName());
				pstmt.setString(2, fi.getFilePath());
				pstmt.setString(3, fi.getChangeName());
				pstmt.setInt(4, fi.getFileLevel());
				
				result = pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
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
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Hire selectHireInfo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Hire h = null;
		
		String query = prop.getProperty("selectHireInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				h = new Hire(rset.getInt("HIRE_NO"),
							 rset.getString("HIRE_COMPANY"),
							 rset.getString("HIRE_NAME"),
							 rset.getString("HIRE_EMAIL"),
							 rset.getString("HIRE_FIELD"),
							 rset.getInt("EMPLOY_NUM"),
							 rset.getDate("HIRE_DATE"),
							 rset.getString("COMPANY_ADDRESS"),
							 rset.getString("WRITER"),
							 rset.getInt("VIEW_COUNT"),
							 rset.getString("HIRE_YN"),
							 rset.getDate("CREATE_DATE"),
							 rset.getString("STATUS"),
							 rset.getInt("CATE_NO"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return h;
	}

	public ArrayList<Files> selectImg(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Files> list = null;
		
		String query = prop.getProperty("selectImg");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Files>();
			while(rset.next()) {
				Files fi = new Files();
				fi.setFileNo(rset.getInt("FILE_NO"));
				fi.setFileName(rset.getString("FILE_NAME"));
				fi.setFilePath(rset.getString("FILE_PATH"));
				fi.setChangeName(rset.getString("CHANGE_NAME"));
				fi.setFileLevel(rset.getInt("FILE_LEVEL"));
				fi.setHireNo(rset.getInt("HIRE_NO"));
				
				list.add(fi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList selectHList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Hire> list = null;
		
		String query = prop.getProperty("selectHList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Hire>();
			
			while(rset.next()) {
				list.add(new Hire(rset.getInt("HIRE_NO"),
						 rset.getString("HIRE_COMPANY"),
						 rset.getString("HIRE_NAME"),
						 rset.getString("HIRE_EMAIL"),
						 rset.getString("HIRE_FIELD"),
						 rset.getInt("EMPLOY_NUM"),
						 rset.getDate("HIRE_DATE"),
						 rset.getString("COMPANY_ADDRESS"),
						 rset.getString("WRITER"),
						 rset.getInt("VIEW_COUNT"),
						 rset.getString("HIRE_YN"),
						 rset.getDate("CREATE_DATE"),
						 rset.getString("STATUS"),
						 rset.getInt("CATE_NO")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public ArrayList selectFList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Files> list = null;
		
		String query = prop.getProperty("selectFList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Files>();
			
			while(rset.next()) {
				list.add(new Files(rset.getString("CHANGE_NAME"),
								   rset.getInt("HIRE_NO")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int deleteHire(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteHire");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int SWriterCount(Connection conn, String search, String searchtext) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("SWriterCount");
		
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

	public int SCompanyAdCount(Connection conn, String search, String searchtext) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("SCompanyAdCount");
		
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

	public ArrayList<Hire> SWriterList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt =null;
		ResultSet rset =null;
		ArrayList<Hire> list = new ArrayList<Hire>();
		
		String query = prop.getProperty("SWriterList");
		
		try {
			
			int starRow = (pi.getCurrentPage()-1 )*pi.getBoardLimit() +1;
			int endRow = starRow + pi.getMaxPage() * pi.getBoardLimit();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, starRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Hire>();
			while(rset.next()) {
				Hire hire = new Hire(rset.getInt("HIRE_NO"),
									 rset.getString("HIRE_COMPANY"),
									 rset.getString("HIRE_NAME"),
									 rset.getString("HIRE_EMAIL"),
									 rset.getString("HIRE_FIELD"),
									 rset.getInt("EMPLOY_NUM"),
									 rset.getDate("HIRE_DATE"),
									 rset.getString("COMPANY_ADDRESS"),
									 rset.getString("WRITER"),
									 rset.getInt("VIEW_COUNT"),
									 rset.getString("HIRE_YN"),
									 rset.getDate("CREATE_DATE"),
									 rset.getString("STATUS"),
									 rset.getInt("CATE_NO"));
				list.add(hire);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		 return list;
	}

	public ArrayList<Hire> SCompanyAdList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt =null;
		ResultSet rset =null;
		ArrayList<Hire> list = new ArrayList<Hire>();
		
		String query = prop.getProperty("SCompanyAdList");
		
		try {
			
			int starRow = (pi.getCurrentPage()-1 )*pi.getBoardLimit() +1;
			int endRow = starRow + pi.getMaxPage() * pi.getBoardLimit();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, starRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Hire>();
			while(rset.next()) {
				Hire hire = new Hire(rset.getInt("HIRE_NO"),
									 rset.getString("HIRE_COMPANY"),
									 rset.getString("HIRE_NAME"),
									 rset.getString("HIRE_EMAIL"),
									 rset.getString("HIRE_FIELD"),
									 rset.getInt("EMPLOY_NUM"),
									 rset.getDate("HIRE_DATE"),
									 rset.getString("COMPANY_ADDRESS"),
									 rset.getString("WRITER"),
									 rset.getInt("VIEW_COUNT"),
									 rset.getString("HIRE_YN"),
									 rset.getDate("CREATE_DATE"),
									 rset.getString("STATUS"),
									 rset.getInt("CATE_NO"));
				list.add(hire);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		 return list;
	}
	
	
}
