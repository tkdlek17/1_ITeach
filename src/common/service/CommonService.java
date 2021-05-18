package common.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import common.model.dao.CommonDAO;
import common.model.vo.Category;

public class CommonService {
	
	public CommonService() {
		
	}

	public ArrayList<Category> getCategory(int parentCategory) {
		Connection conn = getConnection();
		
		ArrayList<Category> list = new CommonDAO().getCategory(conn, parentCategory);
		
		return list;
	}

}
