package common.model.dao;
import static common.JDBCTemplate.*;

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
import question.model.dao.QuestionDAO;

public class CommonDAO {
	private Properties prop;
	public CommonDAO() {
		String filePath = CommonDAO.class.getResource("/sql/common-query.properties").getPath();
		prop = new Properties();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Category> getCategory(Connection conn, int parentCategory) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> list = new ArrayList<Category>();
		String query = prop.getProperty("getCategory");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, parentCategory);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Category category = new Category();
				category.setCateNo(rset.getInt("CATE_NO"));
				category.setCateName(rset.getString("CATE_NAME"));
				category.setParentCate(rset.getInt("PARENT_CATE"));
				
				list.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
