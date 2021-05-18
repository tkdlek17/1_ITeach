package grammar.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import question.model.vo.Board;
import question.model.vo.PageInfo;

public class GrammarDAO {
	
	private Properties prop;
	public GrammarDAO() {
		prop = new Properties();
		String filePath = GrammarDAO.class.getResource("/sql/grammar-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertGrammar(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertGrammar");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitile());
			pstmt.setInt(2, board.getMemNum());
			pstmt.setInt(3, board.getCateNum());
			pstmt.setString(4, board.getBoardContent());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Board> selectGrammar(Connection conn, PageInfo pi, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset  = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String query = prop.getProperty("selectGrammar");
		int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset);
				Board board =new Board(rset.getInt("BOARD_NO"), rset.getString("BOARD_TITLE"),
						rset.getInt("BOARD_VIEW"), rset.getString("BOARD_CONTENT"), rset.getDate("BOARD_CREATE_AT"),
						rset.getString("MEM_NICK"), rset.getDate("MODIFY_DATE"), rset.getInt("LIKE_COUNT"),
						rset.getInt("MEM_NUM"), rset.getInt("CATE_NO"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getListCount(Connection conn, int cateNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getListCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cateNum);
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

	public Board getGrammar(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getGrammar");
		Board board = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new Board(rset.getInt("BOARD_NO"), 
								rset.getString("BOARD_TITLE"), 
								rset.getInt("BOARD_VIEW"), 
								rset.getString("BOARD_CONTENT"), 
								rset.getDate("BOARD_CREATE_AT"), 
								rset.getString("MEM_NICK"), 
								rset.getDate("MODIFY_DATE"), 
								rset.getInt("LIKE_COUNT"), 
								rset.getInt("MEM_NUM"), 
								rset.getInt("CATE_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	public int updateGrammar(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateGrammar");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitile());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getCateNum());
			pstmt.setInt(4, board.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteGrammar(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteGrammar");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateCount(Connection conn, int no) {
		PreparedStatement pstmt  = null;
		
		String query = prop.getProperty("updateCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> getSubList(Connection conn, int cateNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String query = prop.getProperty("getSubList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cateNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board(rset.getInt("BOARD_NO"), 
						rset.getString("BOARD_TITLE"), 
						rset.getInt("BOARD_VIEW"), 
						rset.getString("BOARD_CONTENT"), 
						rset.getDate("BOARD_CREATE_AT"), 
						rset.getString("MEM_NICK"), 
						rset.getDate("MODIFY_DATE"), rset.getInt("LIKE_COUNT"), 
						rset.getInt("MEM_NUM"), 
						rset.getInt("CATE_NO"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	

}
