package license.model.dao;

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

import board.model.vo.Files;
import license.model.vo.Comments;
import license.model.vo.License;
import license.model.vo.PageInfo;

public class LicenseDAO {

private Properties prop = new Properties();
	
	public LicenseDAO() {
		String filePath = LicenseDAO.class.getResource("/sql/license-query.properties").getPath();
	
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getListCount(Connection conn) { // 조회수
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

	
	public ArrayList<License> selectLicenseList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<License> list = null;
		
		String query = prop.getProperty("selectLicenseList");
//		SELECT * FROM LLIST WHERE RNUM BETWEEN ? AND ? 
		try {
			
			// page 1 ==> 1 2 3 4 5 6 7 8 9 10
			// page 2 ==> 11 12 13 14 15 16 17 18 19 20
			int startRow = (pi.getCurrentPage() - 1) * pi.getLicenseLimit() + 1; // 10n + 1
			int endRow = startRow + pi.getLicenseLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<License>();
			
			while(rset.next()) {
				License l = new License(rset.getInt("LICENSE_NO"),
										rset.getString("LICENSE_TITLE"),
										rset.getString("LICENSE_CONTENT"),
										rset.getString("LICENSE_WRITER"),
										rset.getDate("CREATE_DATE"),
										rset.getInt("LICENSE_VIEW"),
										rset.getString("MEM_NICK"),
										rset.getString("STATUS"));
				
				list.add(l);
			
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	
	
	public int insertLicense(Connection conn, License l) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertLicense");
//	INSERT INTO LICENSE 
//		VALUES(SEQ_LIC.NEXTVAL, ?, ?, ?, ?, DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT, SEQ_FIL.NEXTVAL)	      
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, l.getLicenseTitle());
			pstmt.setString(2, l.getLicenseContent());
			pstmt.setString(3, l.getLicenseWriter());
			pstmt.setDate(4, l.getCreateDate());
			pstmt.setString(5, l.getQuestion1());
			pstmt.setString(6, l.getQuestion2());
			pstmt.setString(7, l.getQuestion3());
			pstmt.setString(8, l.getQuestion4());
			pstmt.setString(9, l.getQuestion5());
			pstmt.setInt(10, l.getAnswer1());
			pstmt.setInt(11, l.getAnswer2());
			pstmt.setInt(12, l.getAnswer3());
			pstmt.setInt(13, l.getAnswer4());
			pstmt.setInt(14, l.getAnswer5());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
				
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}


	public int updateCount(Connection conn, int li) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
//		UPDATE LICENSE SET LICENSE_VIEW = LICENSE_VIEW + 1 WHERE LICENSE_NO = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, li);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public License selectLicense(Connection conn, int li) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		License l = new License();
		
		String query = prop.getProperty("selectLicense");
//		SELECT * FROM SLLIST WHERE LICENSE_NO=?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, li);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				l.setLicenseNo(rset.getInt("LICENSE_NO"));
				l.setLicenseTitle(rset.getString("LICENSE_TITLE"));
				l.setLicenseContent(rset.getString("LICENSE_CONTENT"));
				l.setLicenseWriter(rset.getString("LICENSE_WRITER"));
				l.setCreateDate(rset.getDate("CREATE_DATE"));
				l.setLicenseView(rset.getInt("LICENSE_VIEW"));
				l.setQuestion1(rset.getString("QUESTION1"));
				l.setQuestion2(rset.getString("QUESTION2"));
				l.setQuestion3(rset.getString("QUESTION3"));
				l.setQuestion4(rset.getString("QUESTION4"));
				l.setQuestion5(rset.getString("QUESTION5"));
				l.setAnswer1(rset.getInt("ANSWER1"));
				l.setAnswer2(rset.getInt("ANSWER2"));
				l.setAnswer3(rset.getInt("ANSWER3"));
				l.setAnswer4(rset.getInt("ANSWER4"));
				l.setAnswer5(rset.getInt("ANSWER5"));
				l.setMemNick(rset.getString("MEM_NICK"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return l;
	}


	public ArrayList<Files> selectFiles(Connection conn, int li) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Files> list = null;
		
		String query = prop.getProperty("selectFiles");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, li);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Files>();
			
			while(rset.next()) {
				Files fi = new Files();
				fi.setFileNo(rset.getInt("File_NO"));
				fi.setFileName(rset.getString("FILE_NAME"));
				fi.setChangeName(rset.getString("CHANGE_NAME"));
				fi.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(fi);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	



	public int deleteLicense(Connection conn, int li) {
		PreparedStatement pstmt = null;
		int result = 0;
				
		String query = prop.getProperty("deleteLicense");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, li);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<Comments> selectCommentsList(Connection conn, int li) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comments> cList = null;
		
		String query = prop.getProperty("selectCommentsList");
		// SELECT * FROM COMMENTS WHERE LICENSE_NO=?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, li);
			
			rset = pstmt.executeQuery();
			cList = new ArrayList<Comments>();
			
			while(rset.next()) {
				cList.add(new Comments(rset.getInt("COMMENT_NO"),
										rset.getString("CONTENT"),
										rset.getInt("LICENSE_NO"),
										rset.getDate("COMMENT_CREATE_AT"),
										rset.getString("MEM_NICK")));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("cList : " + cList);
		
		return cList;
	}

	public int insertComments(Connection conn, Comments c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertComments");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getContent());
			pstmt.setInt(2, c.getMemNum());
			pstmt.setInt(3, c.getLicenseNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
			System.out.println("result : " + result); 
		
		return result;
		
	}

	public int updateLicense(Connection conn, License l) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateLicense");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, l.getLicenseTitle());
			pstmt.setString(2, l.getLicenseContent());
			pstmt.setString(3, l.getQuestion1());
			pstmt.setString(4, l.getQuestion2());
			pstmt.setString(5, l.getQuestion3());
			pstmt.setString(6, l.getQuestion4());
			pstmt.setString(7, l.getQuestion5());
			pstmt.setInt(8, l.getAnswer1());
			pstmt.setInt(9, l.getAnswer2());
			pstmt.setInt(10, l.getAnswer3());
			pstmt.setInt(11, l.getAnswer4());
			pstmt.setInt(12, l.getAnswer5());
			pstmt.setInt(13, l.getLicenseNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}


	public int STitleCount(Connection conn, String search, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("STitleCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  "%"+searchText+"%");
			
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
	


	public int SContentCount(Connection conn, String search, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("SContentCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  "%"+searchText+"%");
			
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

	public ArrayList<License> STitleList(Connection conn, String search, String searchText, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<License> list = new ArrayList<License>();
		
		String query = prop.getProperty("STitleList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1)* pi.getLicenseLimit() + 1;
//			int endRow = startRow + pi.getLicenseLimit() - 1;
			int endRow = pi.getStartPage() * pi.getLicenseLimit() + pi.getMaxPage() * pi.getLicenseLimit();
		
			
			System.out.println("startRow : " + startRow);
			System.out.println("endRow : " + endRow);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchText+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<License>();
			
			while(rset.next()) {
				License l = new License(rset.getInt("LICENSE_NO"),
						rset.getString("LICENSE_TITLE"),
						rset.getString("LICENSE_CONTENT"),
						rset.getString("LICENSE_WRITER"),
						rset.getDate("CREATE_DATE"),
						rset.getInt("LICENSE_VIEW"),
						rset.getString("MEM_NICK"));

				list.add(l);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<License> SContentList(Connection conn, String search, String searchText, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<License> list = new ArrayList<License>();
		
		String query = prop.getProperty("SContentList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1)* pi.getLicenseLimit() + 1;
//			int endRow = startRow + pi.getLicenseLimit() - 1;
			int endRow = pi.getStartPage() * pi.getLicenseLimit() + pi.getMaxPage() * pi.getLicenseLimit();
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchText+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<License>();
			
			while(rset.next()) {
				License l = new License(rset.getInt("LICENSE_NO"),
						rset.getString("LICENSE_TITLE"),
						rset.getString("LICENSE_CONTENT"),
						rset.getString("LICENSE_WRITER"),
						rset.getDate("CREATE_DATE"),
						rset.getInt("LICENSE_VIEW"),
						rset.getString("MEM_NICK"));

				list.add(l);
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
