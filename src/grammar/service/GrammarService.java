package grammar.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import grammar.model.dao.GrammarDAO;
import question.model.vo.Board;
import question.model.vo.PageInfo;

public class GrammarService {
	
	public GrammarService() {
		
	}
	
	public int insertGrammar(Board board) {
		Connection conn = getConnection();
		
		int result = new GrammarDAO().insertGrammar(conn, board);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Board> selectGrammar(PageInfo pi, int no) {
		Connection conn = getConnection();
		ArrayList<Board> list = new GrammarDAO().selectGrammar(conn, pi,  no);
		
		System.out.println("service list" + list);
		
		close(conn);
		return list;
	}

	public int getListCount(int no) {
		Connection conn = getConnection();
		
		int result = 0;
		
		result = new GrammarDAO().getListCount(conn, no);
		
		close(conn);
		
		return result;
	}

	public Board getGrammar(int no) {
		Connection conn = getConnection();
		int result = new GrammarDAO().updateCount(conn, no);
		Board board = null;
		if(result > 0) {
			commit(conn);
			board  = new GrammarDAO().getGrammar(conn, no);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return board;
	}

	public int updateGrammar(Board board) {
		Connection conn = getConnection();
		int result = new GrammarDAO().updateGrammar(conn, board);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int deleteGrammar(int no) {
		Connection conn = getConnection();
		int result = 0;
		result = new GrammarDAO().deleteGrammar(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Board> getSubList(int cateNo) {
		Connection conn = getConnection();
		ArrayList<Board> list = new GrammarDAO().getSubList(conn, cateNo);
		
		close(conn);
		return list;
	}

}
