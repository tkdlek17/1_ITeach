package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import notice.model.vo.Comments;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.PageInfo;

public class NoticeService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new NoticeDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Notice> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDAO().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDAO().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int no) {
		Connection conn = getConnection();
		
		NoticeDAO nDAO = new NoticeDAO();
		
		int result = nDAO.updateCount(conn, no);
		
		Notice notice = null;
		
		if(result > 0) {
			notice = nDAO.selectNotice(conn, no);
			if(notice == null) {
				rollback(conn);
			} else {
				commit(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return notice;
	}

	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		
		int result = new NoticeDAO().updateNotice(conn, notice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteNotice(int no) {
		Connection conn = getConnection();
		
		int result = new NoticeDAO().deleteNotice(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Comments> selectCommentsList(int no) {
		Connection conn = getConnection();
		
		ArrayList<Comments> list = new NoticeDAO().selectCommentsList(conn, no);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Comments> insertnComments(Comments c) {
		Connection conn = getConnection();
		NoticeDAO nDAO = new NoticeDAO();
		
		int result = nDAO.insertComments(conn, c);
		
		ArrayList<Comments> list = null;
		if(result > 0) {
			commit(conn);
			list = nDAO.selectCommentsList(conn, c.getNoticeNo());
		} else {
			rollback(conn);
		}
		return list;
	}

	public int searchlistCount(String search, String searchtext) {
		Connection conn = getConnection();
		int listCount = 0;
		
		if(search.equals("notice_title")) {
			listCount = new NoticeDAO().SENTitleCount(conn, search, searchtext);
		} 
		close(conn);
		
		return listCount;
	}

	public ArrayList<Notice> SENList(String search, String searchtext, PageInfo pi) {
		Connection conn = getConnection();
		NoticeDAO nDAO = new NoticeDAO();
		
		ArrayList<Notice> list = null;
		
		if(search.equals("notice_title")) {
			list = nDAO.SENTitleList(conn, search, searchtext, pi);
		}
		
		close(conn);
		
		return list;	
	}
}
