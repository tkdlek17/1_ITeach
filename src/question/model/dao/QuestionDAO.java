package question.model.dao;

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

import common.model.vo.Category;
import question.model.vo.Answer;
import board.model.vo.Attachment;
import question.model.vo.Board;
import question.model.vo.PageInfo;

public class QuestionDAO {
	private Properties prop;

	public QuestionDAO() {
		prop = new Properties(); 
		String filePath = QuestionDAO.class.getResource("/sql/question-query.properties").getPath(); 
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Category> selectQuestionCategory(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> list = new ArrayList<Category>();
		String query = prop.getProperty("selectQuestionCategory");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 10);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Category category = new Category(rset.getInt("CATE_NO"), rset.getString("CATE_NAME"),
						rset.getInt("MEM_NUM"), rset.getInt("PARENT_CATE"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertQuestion(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertQuestion");

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

	public int getListCount(Connection conn, int i) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getListCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, i);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Board> selectQuestionList(Connection conn, PageInfo pi, int category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();

		String query = prop.getProperty("selectQuestionList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; 
		int endRow = startRow + pi.getBoardLimit() - 1;
		System.out.println("startRow: "+ startRow + " endRow : "+ endRow);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Board board = new Board(rset.getInt("BOARD_NO"),
										rset.getString("BOARD_TITLE"),
										rset.getInt("BOARD_VIEW"), 
										rset.getString("BOARD_CONTENT"), 
										rset.getDate("BOARD_CREATE_AT"), 
										rset.getString("MEM_NICK"), 
										rset.getDate("MODIFY_DATE"),
										rset.getInt("LIKE_COUNT"), 
										rset.getInt("MEM_NUM"), 
										rset.getInt("CATE_NO"), 
										rset.getInt("ID"));
				list.add(board);
			}
			
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Board getQuestion(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;
		String query = prop.getProperty("getQuestion");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				board = new Board(rset.getInt("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getInt("BOARD_VIEW"), 
						rset.getString("BOARD_CONTENT"), 
						rset.getDate("BOARD_CREATE_AT"), 
						rset.getString("MEM_NICK"), 
						rset.getDate("MODIFY_DATE"),
						rset.getInt("LIKE_COUNT"), 
						rset.getInt("MEM_NUM"), 
						rset.getInt("CATE_NO"), 
						rset.getInt("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return board;
	}

	public ArrayList<Answer> getAnswer(Connection conn, int qno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Answer> aList = new ArrayList<Answer>();
		String query = prop.getProperty("getAnswer");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qno);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Answer answer = new Answer(rset.getInt("ANSWER_ID"), rset.getString("ANSWER_TITLE"),
						rset.getString("ANSWER_CONTENT"), rset.getDate("ANSWER_CREATE_AT"), rset.getInt("BOARD_NO"),
						rset.getString("STATUS"), rset.getInt("WRITER"));

				aList.add(answer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return aList;
	}

	public int updateViewCount(Connection conn, int no) {
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

	public int insertAnswer(Connection conn, Answer answer) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAnswer");
		System.out.println(answer);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, answer.getAnswerTitle());
			pstmt.setString(2, answer.getContent());
			pstmt.setInt(3, answer.getBoardNo());
			pstmt.setInt(4, answer.getWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteQuestion(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteQuestion");

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


	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertAttachment");
		int result = 0;
		try {
			for (Attachment a : fileList) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, a.getOriginName());
				pstmt.setString(2, a.getFilePath());
				pstmt.setString(3, a.getChageName());
				result += pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Attachment> getAttachment(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		
		String query = prop.getProperty("getAttachment");
		
		try {
			pstmt = conn.prepareStatement(query); // SELECT * FROM ATTACHMENT WHERE ARTICLE_NO =  ? AND STATUS='Y'
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment att = new Attachment();
				att.setOriginName(rset.getString("FILE_NAME"));
				att.setFilePath(rset.getString("FILE_PATH"));
				att.setChageName(rset.getString("CHANGE_NAME"));
				att.setBoardNo(rset.getInt("BOARD_NO"));
				
				list.add(att);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(list);
		
		return list;
	}

	public int insertBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertBoard");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitile());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getMemNum());
			pstmt.setInt(4, board.getCateNum());
			pstmt.setString(5, "");
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Board> getSubList(Connection conn, PageInfo pi, int categoryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String query = prop.getProperty("getSubList"); 
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board(rset.getInt("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getInt("BOARD_VIEW"), 
						rset.getString("BOARD_CONTENT"), 
						rset.getDate("BOARD_CREATE_AT"), 
						rset.getString("MEM_NICK"), 
						rset.getDate("MODIFY_DATE"),
						rset.getInt("LIKE_COUNT"), 
						rset.getInt("MEM_NUM"), 
						rset.getInt("CATE_NO"), 
						rset.getInt("ID"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return list;
	}

	public ArrayList<Board> searchQuestionList(Connection conn, PageInfo pi, int category) {
		return null;
	}

	public int getSubListCount(Connection conn, int categoryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result = 0;
		
		String query = prop.getProperty("getSubListCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, categoryNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int getsubListCount(Connection conn, int categoryNo) {
		PreparedStatement pstmt = null;
		
		return 0;
	}

	public int getTitleSearchedSubListCount(Connection conn, int category, String searchText) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("getTitleSeachedSubListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setString(2, "%"+searchText+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int getTitleAndContentSearchedSubListCount(Connection conn, int category, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("getTitleSeachedSubListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setString(2, "%"+searchText+"%");
			pstmt.setString(3, "%"+searchText+"%");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getTitleSearchedListCount(Connection conn, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("getTitleSearchedListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int getTitleAndContentSearchedListCount(Connection conn, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("getTitleAndContentSearchedListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			pstmt.setString(2, "%"+searchText+"%");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Board> getTitleSearchedSubList(Connection conn, PageInfo pi, int category, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		String query = prop.getProperty("getTitleSearchedSubList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setString(2, "%"+searchText + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board(rset.getInt("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getInt("BOARD_VIEW"), 
						rset.getString("BOARD_CONTENT"), 
						rset.getDate("BOARD_CREATE_AT"), 
						rset.getString("MEM_NICK"), 
						rset.getDate("MODIFY_DATE"),  
						rset.getInt("LIKE_COUNT"), 
						rset.getInt("MEM_NUM"), 
						rset.getInt("CATE_NO"), 
						rset.getInt("ID"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Board> getTitleAndContentSearchedSubList(Connection conn, PageInfo pi, int category, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		String query = prop.getProperty("getTitleAndContentSearchedSubList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setString(2, "%"+searchText + "%");
			pstmt.setString(3, "%"+searchText + "%");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board(rset.getInt("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getInt("BOARD_VIEW"), 
						rset.getString("BOARD_CONTENT"), 
						rset.getDate("BOARD_CREATE_AT"), 
						rset.getString("MEM_NICK"), 
						rset.getDate("MODIFY_DATE"),
						rset.getInt("LIKE_COUNT"), 
						rset.getInt("MEM_NUM"), 
						rset.getInt("CATE_NO"), 
						rset.getInt("ID"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Board> getTitleSearchedList(Connection conn, PageInfo pi, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		String query = prop.getProperty("getTitleSearchedList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 10);
			pstmt.setString(1, "%"+searchText + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board(rset.getInt("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getInt("BOARD_VIEW"), 
						rset.getString("BOARD_CONTENT"), 
						rset.getDate("BOARD_CREATE_AT"), 
						rset.getString("MEM_NICK"), 
						rset.getDate("MODIFY_DATE"), 
						rset.getInt("LIKE_COUNT"), 
						rset.getInt("MEM_NUM"), 
						rset.getInt("CATE_NO"), 
						rset.getInt("ID"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Board> getTitleAndContentSearchedList(Connection conn, PageInfo pi, String searchText) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		String query = prop.getProperty("getTitleAndContentSearchedList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText + "%");
			pstmt.setString(2, "%"+searchText + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board(rset.getInt("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getInt("BOARD_VIEW"), 
						rset.getString("BOARD_CONTENT"), 
						rset.getDate("BOARD_CREATE_AT"), 
						rset.getString("MEM_NICK"), 
						rset.getDate("MODIFY_DATE"), 
						rset.getInt("LIKE_COUNT"), 
						rset.getInt("MEM_NUM"), 
						rset.getInt("CATE_NO"), 
						rset.getInt("ID"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	public int updateQuestion(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateQuestion");
		try {
			pstmt = conn.prepareStatement(query); // UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT =?, CATE_NO =? WHERE BOARD_NO = ? 
			pstmt.setString(1, board.getBoardTitile());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getCateNum());
			pstmt.setInt(4, board.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
