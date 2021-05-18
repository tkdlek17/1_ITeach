package board.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Comments;
import board.model.vo.Fboard;
import board.model.vo.PageInfo;
import notice.model.dao.NoticeDAO;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new BoardDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Fboard> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Fboard> list = new BoardDAO().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int insertBoard(Fboard fb) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn, fb);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Fboard selectBoard(int fbNo) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.updateCount(conn, fbNo);
		
		Fboard Fboard = null;
		
		if(result > 0) {
			Fboard = dao.selectBoard(conn, fbNo);
			
			if(Fboard != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		return Fboard;
	}

	public int updateBoard(Fboard fboard) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateBoard(conn, fboard);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteBoard(int fbNo) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().deleteBoard(conn, fbNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Fboard> selectSList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Fboard> list = new BoardDAO().selectSList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int insertSBoard(Fboard fb) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertSBoard(conn, fb);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Fboard selectSBoard(int stNo) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.updateSCount(conn, stNo);
		
		Fboard Fboard = null;
		
		if(result > 0) {
			Fboard = dao.selectSBoard(conn, stNo);
			
			if(Fboard != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		return Fboard;
	}

	public int updateSBoard(Fboard sboard) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateSBoard(conn, sboard);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteSBoard(int stNo) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().deleteSBoard(conn, stNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Comments> selectCommentsList(int fbNo) {
		Connection conn = getConnection();
		
		ArrayList<Comments> list = new BoardDAO().selectCommentsList(conn, fbNo);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Comments> insertComments(Comments c) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.insertComments(conn, c);
		
		ArrayList<Comments> list = null;
		if(result > 0) {
			commit(conn);
			list = bDAO.selectCommentsList(conn, c.getBoardNo());
		} else {
			rollback(conn);
		}
		return list;
	}

	public ArrayList<Comments> selectCommentsstList(int stNo) {
		Connection conn = getConnection();
		
		ArrayList<Comments> list = new BoardDAO().selectCommentsstList(conn, stNo);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Comments> insertCommentsst(Comments c) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.insertCommentsst(conn, c);
		
		ArrayList<Comments> list = null;
		if(result > 0) {
			commit(conn);
			list = bDAO.selectCommentsstList(conn, c.getBoardNo());
		} else {
			rollback(conn);
		}
		return list;
	}

	public ArrayList<Fboard> SEList(String search, String searchtext, PageInfo pi) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		ArrayList<Fboard> list = null;
		
		if(search.equals("free_title")) {
			list = bDAO.SETitleList(conn, search, searchtext, pi);
		} else if(search.equals("free_writer")) {
			list = bDAO.SEWriterList(conn, search, searchtext, pi);
		}
		
		close(conn);
		
		return list;
	}

	public int searchlistCount(String search, String searchtext) {
		Connection conn = getConnection();
		int listCount = 0;
		
		if(search.equals("free_title")) {
			listCount = new BoardDAO().SETitleCount(conn, search, searchtext);
		} else if(search.equals("free_writer")) {
			listCount = new BoardDAO().SEWriterCount(conn, search, searchtext);
		}
		close(conn);
		
		return listCount;
	}

	public ArrayList<Fboard> SESList(String search, String searchtext, PageInfo pi) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		ArrayList<Fboard> list = null;
		
		if(search.equals("study_title")) {
			list = bDAO.SESTitleList(conn, search, searchtext, pi);
		} else if(search.equals("study_writer")) {
			list = bDAO.SESWriterList(conn, search, searchtext, pi);
		} else if(search.equals("study_region")) {
			list = bDAO.SESRegionList(conn, search, searchtext, pi);
		}
		
		close(conn);
		
		return list;
	}
}
