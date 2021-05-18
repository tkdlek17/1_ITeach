package Likes.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import Likes.model.dao.LikeDAO;





public class LikesService {

	public int updateUnlike(int no) {
		Connection conn = getConnection();
		
		int result = new LikeDAO().updateUnlike(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int selectsql(String nickname , int no) {
		Connection conn = getConnection();
		LikeDAO dao = new LikeDAO();
		int result = dao.selectsql(conn, nickname, no);
		
		if(result !=1 ) {
			dao.insertsql(conn, nickname, no );
		}
	
		
		return result;
	}

	

	

}
