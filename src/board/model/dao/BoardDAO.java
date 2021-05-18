package board.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.Comments;
import board.model.vo.Fboard;
import board.model.vo.PageInfo;


public class BoardDAO {
	
	private Properties prop = new Properties();
	
	public BoardDAO() {
		String filePath = BoardDAO.class.getResource("/sql/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Board> selectList(Connection conn) {
		return null;
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

	public ArrayList<Fboard> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Fboard> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Fboard>();
			while(rset.next()) {
				Fboard fb = new Fboard(rset.getInt("BOARD_NO"),
									   rset.getString("BOARD_TITLE"),
									   rset.getInt("BOARD_VIEW"),
									   rset.getDate("BOARD_CREATE_AT"),
									   rset.getDate("MODIFY_DATE"),
									   rset.getString("STATUS"),
									   rset.getInt("MEM_NUM"),
									   rset.getInt("CATE_NO"),
									   rset.getString("MEM_NICK"),
									   rset.getString("CATE_NAME"),
									   rset.getInt("ID"),
									   rset.getString("BOARD_CONTENT"));
				list.add(fb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertBoard(Connection conn, Fboard fb) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fb.getBoardTitle());
			pstmt.setInt(2, fb.getMemNum());
			pstmt.setInt(3, fb.getCateNo());
			pstmt.setString(4, fb.getBoardContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateCount(Connection conn, int fbNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fbNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Fboard selectBoard(Connection conn, int fbNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Fboard fb = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fbNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				fb = new Fboard(rset.getInt("BOARD_NO"),
						   		rset.getString("BOARD_TITLE"),
						   		rset.getInt("BOARD_VIEW"),
						   		rset.getDate("BOARD_CREATE_AT"),
						   		rset.getDate("MODIFY_DATE"),
						   		rset.getString("STATUS"),
						   		rset.getInt("MEM_NUM"),
						   		rset.getInt("CATE_NO"),
						   		rset.getString("MEM_NICK"),
						   		rset.getString("CATE_NAME"),
						   		rset.getInt("ID"),
						   		rset.getString("BOARD_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return fb;
	}

	public int updateBoard(Connection conn, Fboard fboard) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fboard.getBoardTitle());
			pstmt.setString(2, fboard.getBoardContent());
			pstmt.setInt(3, fboard.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int fbNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fbNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Fboard> selectSList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Fboard> list = null;
		
		String query = prop.getProperty("selectFList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Fboard>();
			while(rset.next()) {
				Fboard fb = new Fboard(rset.getInt("BOARD_NO"),
				   					   rset.getString("BOARD_TITLE"),
				   					   rset.getInt("BOARD_VIEW"),
				   					   rset.getDate("BOARD_CREATE_AT"),
				   					   rset.getDate("MODIFY_DATE"),
				   					   rset.getString("REGION"),
				   					   rset.getString("STATUS"),
				   					   rset.getInt("MEM_NUM"),
				   					   rset.getInt("CATE_NO"),
				   					   rset.getString("MEM_NICK"),
				   					   rset.getString("CATE_NAME"),
				   					   rset.getInt("ID"),
				   					   rset.getString("BOARD_CONTENT"));
				list.add(fb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertSBoard(Connection conn, Fboard fb) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertSBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fb.getBoardTitle());
			pstmt.setString(2, fb.getRegion());
			pstmt.setInt(3, fb.getMemNum());
			pstmt.setInt(4, fb.getCateNo());
			pstmt.setString(5, fb.getBoardContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Fboard selectSBoard(Connection conn, int stNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Fboard fb = null;
		
		String query = prop.getProperty("selectSBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, stNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				fb = new Fboard(rset.getInt("BOARD_NO"),
								rset.getString("BOARD_TITLE"),
								rset.getInt("BOARD_VIEW"),
								rset.getDate("BOARD_CREATE_AT"),
								rset.getDate("MODIFY_DATE"),
								rset.getString("REGION"),
								rset.getString("STATUS"),
								rset.getInt("MEM_NUM"),
								rset.getInt("CATE_NO"),
		   					   	rset.getString("MEM_NICK"),
		   					   	rset.getString("CATE_NAME"),
		   					   	rset.getInt("ID"),
		   					   	rset.getString("BOARD_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return fb;
	}

	public int updateSCount(Connection conn, int stNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, stNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateSBoard(Connection conn, Fboard sboard) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateSBoard");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sboard.getRegion());
			pstmt.setString(2, sboard.getBoardTitle());
			pstmt.setString(3, sboard.getBoardContent());
			pstmt.setInt(4, sboard.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteSBoard(Connection conn, int stNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, stNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Comments> selectCommentsList(Connection conn, int fbNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comments> fcList = null;
		
		String query = prop.getProperty("selectCommentsList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fbNo);
			
			rset = pstmt.executeQuery();
			fcList = new ArrayList<Comments>();
			while(rset.next()) {
				fcList.add(new Comments(rset.getInt("COMMENT_NO"),
						                rset.getString("CONTENT"),
						                rset.getInt("BOARD_NO"),
						                rset.getInt("MEM_NUM"),
						                rset.getString("MEM_NICK"),
						                rset.getDate("COMMENT_CREATE_AT"),
						                rset.getString("STATUS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return fcList;
	}

	public int insertComments(Connection conn, Comments c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertComments");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getContent());
			pstmt.setInt(2, c.getBoardNo());
			pstmt.setInt(3, c.getMemNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Comments> selectCommentsstList(Connection conn, int stNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comments> scList = null;
		
		String query = prop.getProperty("selectCommentsList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, stNo);
			
			rset = pstmt.executeQuery();
			scList = new ArrayList<Comments>();
			while(rset.next()) {
				scList.add(new Comments(rset.getInt("COMMENT_NO"),
						                rset.getString("CONTENT"),
						                rset.getInt("BOARD_NO"),
						                rset.getInt("MEM_NUM"),
						                rset.getString("MEM_NICK"),
						                rset.getDate("COMMENT_CREATE_AT"),
						                rset.getString("STATUS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return scList;
	}

	public int insertCommentsst(Connection conn, Comments c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertComments");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getContent());
			pstmt.setInt(2, c.getBoardNo());
			pstmt.setInt(3, c.getMemNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Fboard> SETitleList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Fboard> list = new ArrayList<Fboard>();
		
		String query = prop.getProperty("SETitleList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Fboard>();
			while(rset.next()) {
				Fboard fb = new Fboard(rset.getInt("BOARD_NO"),
									   rset.getString("BOARD_TITLE"),
									   rset.getInt("BOARD_VIEW"),
									   rset.getDate("BOARD_CREATE_AT"),
									   rset.getDate("MODIFY_DATE"),
									   rset.getString("STATUS"),
									   rset.getInt("MEM_NUM"),
									   rset.getInt("CATE_NO"),
									   rset.getString("MEM_NICK"),
									   rset.getString("CATE_NAME"),
									   rset.getInt("ID"),
									   rset.getString("BOARD_CONTENT"));
				list.add(fb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Fboard> SEWriterList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Fboard> list = new ArrayList<Fboard>();
		
		String query = prop.getProperty("SEWriterList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Fboard>();
			while(rset.next()) {
				Fboard fb = new Fboard(rset.getInt("BOARD_NO"),
									   rset.getString("BOARD_TITLE"),
									   rset.getInt("BOARD_VIEW"),
									   rset.getDate("BOARD_CREATE_AT"),
									   rset.getDate("MODIFY_DATE"),
									   rset.getString("STATUS"),
									   rset.getInt("MEM_NUM"),
									   rset.getInt("CATE_NO"),
									   rset.getString("MEM_NICK"),
									   rset.getString("CATE_NAME"),
									   rset.getInt("ID"),
									   rset.getString("BOARD_CONTENT"));
				list.add(fb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int SETitleCount(Connection conn, String search, String searchtext) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("SETitleCount");
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchtext+"%");
			
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

	public int SEWriterCount(Connection conn, String search, String searchtext) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("SEWriterCount");
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchtext+"%");
			
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

	public ArrayList<Fboard> SESTitleList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Fboard> list = new ArrayList<Fboard>();
		
		String query = prop.getProperty("SESTitleList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Fboard>();
			while(rset.next()) {
				Fboard fb = new Fboard(rset.getInt("BOARD_NO"),
									   rset.getString("BOARD_TITLE"),
									   rset.getInt("BOARD_VIEW"),
									   rset.getDate("BOARD_CREATE_AT"),
									   rset.getDate("MODIFY_DATE"),
									   rset.getString("REGION"),
									   rset.getString("STATUS"),
									   rset.getInt("MEM_NUM"),
									   rset.getInt("CATE_NO"),
									   rset.getString("MEM_NICK"),
									   rset.getString("CATE_NAME"),
									   rset.getInt("ID"),
									   rset.getString("BOARD_CONTENT"));
				list.add(fb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Fboard> SESWriterList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Fboard> list = new ArrayList<Fboard>();
		
		String query = prop.getProperty("SESWriterList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Fboard>();
			while(rset.next()) {
				Fboard fb = new Fboard(rset.getInt("BOARD_NO"),
							           rset.getString("BOARD_TITLE"),
							           rset.getInt("BOARD_VIEW"),
							           rset.getDate("BOARD_CREATE_AT"),
							           rset.getDate("MODIFY_DATE"),
							           rset.getString("REGION"),
							           rset.getString("STATUS"),
							           rset.getInt("MEM_NUM"),
							           rset.getInt("CATE_NO"),
							           rset.getString("MEM_NICK"),
							           rset.getString("CATE_NAME"),
							           rset.getInt("ID"),
							           rset.getString("BOARD_CONTENT"));
				list.add(fb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Fboard> SESRegionList(Connection conn, String search, String searchtext, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Fboard> list = new ArrayList<Fboard>();
		
		String query = prop.getProperty("SESRegionList");
		
		try {
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, "%"+searchtext+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Fboard>();
			while(rset.next()) {
				Fboard fb = new Fboard(rset.getInt("BOARD_NO"),
									   rset.getString("BOARD_TITLE"),
									   rset.getInt("BOARD_VIEW"),
									   rset.getDate("BOARD_CREATE_AT"),
									   rset.getDate("MODIFY_DATE"),
									   rset.getString("REGION"),
									   rset.getString("STATUS"),
									   rset.getInt("MEM_NUM"),
									   rset.getInt("CATE_NO"),
									   rset.getString("MEM_NICK"),
									   rset.getString("CATE_NAME"),
									   rset.getInt("ID"),
									   rset.getString("BOARD_CONTENT"));
				list.add(fb);
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
