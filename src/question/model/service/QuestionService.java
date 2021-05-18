package question.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import common.model.vo.Category;
import grammar.model.dao.GrammarDAO;
import question.model.dao.QuestionDAO;
import question.model.vo.Answer;
import board.model.vo.Attachment;
import question.model.vo.Board;
import question.model.vo.PageInfo;

public class QuestionService {

	public ArrayList<Category> selectQuestionCategory() {
		Connection conn = getConnection();

		ArrayList<Category> list = new QuestionDAO().selectQuestionCategory(conn);

		close(conn);

		return list;
	}

	public int insertQuestion(Board board, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();

		QuestionDAO qDAO = new QuestionDAO();
		System.out.println("insertQuestion" + board);
		int result1 = new QuestionDAO().insertQuestion(conn, board);
		int result2 = 0;
		if (result1 > 0) {
			result2 = qDAO.insertAttachment(conn, fileList);
		}

		
		if (result1 > 0) {
				commit(conn);
		} else {
				rollback(conn);
		}

		close(conn);

		return result1;
	}

	public int getListCount(int cateNum) {
		Connection conn = getConnection();
		int result = 0;

		result = new GrammarDAO().getListCount(conn, cateNum);

		close(conn);
		return result;
	}

	public ArrayList<Board> selectQuestionList(PageInfo pi, int category) {
		Connection conn = getConnection();

		ArrayList<Board> list = new QuestionDAO().selectQuestionList(conn, pi, category);

		return list;
	}

	public Board getQuestion(int no) {
		Connection conn = getConnection();
		QuestionDAO qDAO = new QuestionDAO();
		Board board = null;
		int result = qDAO.updateViewCount(conn, no);
		if (result > 0) {
			board = qDAO.getQuestion(conn, no);
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		return board;
	}

	public ArrayList<Answer> getAnswer(int qno) {
		Connection conn = getConnection();
		ArrayList<Answer> aList = new QuestionDAO().getAnswer(conn, qno);

		close(conn);
		return aList;
	}

	public int insertAnswer(Answer answer) {
		Connection conn = getConnection();

		int result = new QuestionDAO().insertAnswer(conn, answer);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int deleteQuestion(int no) {
		Connection conn = getConnection();
		int result = new QuestionDAO().deleteQuestion(conn, no);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public ArrayList<Attachment> getAttachment(int no) {
		Connection conn = getConnection();

		ArrayList<Attachment> list = new QuestionDAO().getAttachment(conn, no);

		return list;
	}

	public ArrayList<Board> getSubCategory(int category) {
		Connection conn = getConnection();
		return null;
	}

	public ArrayList<Board> getSubList(PageInfo pi, int categoryNo) {
		Connection conn = getConnection();

		ArrayList<Board> list = new QuestionDAO().getSubList(conn, pi, categoryNo);

		close(conn);

		return list;
	}

	public ArrayList<Board> searchQuestionList(PageInfo pi, int category) {
		Connection conn = getConnection();

		ArrayList<Board> list = new QuestionDAO().searchQuestionList(conn, pi, category);

		return list;
	}

	public int getSubListCount(int categoryNo) {
		Connection conn = getConnection();

		int result = new QuestionDAO().getsubListCount(conn, categoryNo);

		close(conn);

		return result;
	}

	public int getSearchListCount(int searchMethod, String searchText) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Board> getSearchedSubList(PageInfo pi, int category, int searchMethod, String searchText) {
		Connection conn = getConnection();
		ArrayList<Board> list = new ArrayList<Board>();
		QuestionDAO qDAO = new QuestionDAO();
		if (searchMethod == 1) {
			list = qDAO.getTitleSearchedSubList(conn, pi, category, searchText);
		} else if (searchMethod == 2) {
			list = qDAO.getTitleAndContentSearchedSubList(conn, pi, category, searchText);
		}

		close(conn);

		return list;
	}

	public int getSearchedSubListCount(int category, int searchMethod, String searchText) {
		Connection conn = getConnection();
		int result = 0;
		if (searchMethod == 1) {
			result = new QuestionDAO().getTitleSearchedSubListCount(conn, category, searchText);
		} else if (searchMethod == 2) {
			result = new QuestionDAO().getTitleAndContentSearchedSubListCount(conn, category, searchText);
		}
		close(conn);

		return result;
	}

	public int getSearchedListCount(int searchMethod, String searchText) {
		Connection conn = getConnection();
		int result = 0;
		if (searchMethod == 1) {
			result = new QuestionDAO().getTitleSearchedListCount(conn, searchText);
		} else if (searchMethod == 2) {
			result = new QuestionDAO().getTitleAndContentSearchedListCount(conn, searchText);
		}
		close(conn);
		return result;
	}

	public ArrayList<Board> getSearchedList(PageInfo pi, int searchMethod, String searchText) {
		Connection conn = getConnection();
		QuestionDAO qDAO = new QuestionDAO();
		ArrayList<Board> list = null;

		if (searchMethod == 1) {
			list = qDAO.getTitleSearchedList(conn, pi, searchText);
		} else if (searchMethod == 2) {
			list = qDAO.getTitleAndContentSearchedList(conn, pi, searchText);
		}

		close(conn);

		return list;
	}

	public int updateQuestion(Board board) {
		Connection conn = getConnection();
		QuestionDAO qDAO = new QuestionDAO();
		int result = qDAO.updateQuestion(conn, board);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

}
