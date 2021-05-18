package Likes.model.dao;

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


import Book.model.vo.Book;
import Book.model.vo.Files;
import board.model.vo.Attachment;



public class LikeDAO {
	private Properties prop = new Properties();
	
	public LikeDAO() {
		String fileName = LikeDAO.class.getResource("/sql/likes/likes-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int updateUnlike(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateUnlike");
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		
			return result;
		
		}

	public int selectsql(Connection conn, String nickname , int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("selectsql");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "nickname");
			pstmt.setInt(2, no);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public void insertsql(Connection conn, String nickname, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertsql");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setString(2, nickname);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}

	


	
}
