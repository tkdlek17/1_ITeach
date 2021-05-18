package license.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.vo.Files;
import license.model.dao.LicenseDAO;
import license.model.vo.Comments;
import license.model.vo.License;
import license.model.vo.PageInfo;

public class LicenseService {
	
	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new LicenseDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	
	public ArrayList<License> selectLicenseList(PageInfo pi) {
		Connection conn = getConnection();
		
		 ArrayList<License> list = new LicenseDAO().selectLicenseList(conn, pi);
		
		 close(conn);
		 
		return list;
	}


	public int insertLicense(License l, ArrayList<Files> fileList) {
		Connection conn = getConnection();
		
		LicenseDAO lDAO = new LicenseDAO();
		
		int result1 = lDAO.insertLicense(conn, l);
		int result2 = lDAO.insertFiles(conn, fileList);
		System.out.println(result1);
		System.out.println(result2);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}


	public License selectLicense(int li) {
		// detail.li
		Connection conn = getConnection();
		
		int result = new LicenseDAO().updateCount(conn, li);
		
		License license = null;
		
		if(result > 0) {
			license = new LicenseDAO().selectLicense(conn, li);
			
			if(license != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		return license;
	}


	public ArrayList<Files> selectFiles(int li) {
		Connection conn = getConnection();
		
		ArrayList<Files> list = new LicenseDAO().selectFiles(conn, li);
		
		return list;
	}




	public int deleteLicense(int li) {
		Connection conn = getConnection();
		
		int result = new LicenseDAO().deleteLicense(conn, li);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public ArrayList<Comments> selectCommentsList(int li) {
		Connection conn = getConnection();
		
		ArrayList<Comments> list = new LicenseDAO().selectCommentsList(conn, li);
		
		close(conn);
		
		return list;
	}


	public ArrayList<Comments> insertComments(Comments c) {
		Connection conn = getConnection();
		LicenseDAO lDAO = new LicenseDAO();
		
		int result = lDAO.insertComments(conn, c);
		
		ArrayList<Comments> list = null;
		
		if(result > 0) {
			commit(conn);
			list = lDAO.selectCommentsList(conn, c.getLicenseNo());
			
		} else {
			rollback(conn);
		}
		
		return list;
	}




	public int searchListCount(String search, String searchText) {
		Connection conn = getConnection();
		int listCount = 0;
		
		if(search.equals("licenseTitle")) {
			listCount = new LicenseDAO().STitleCount(conn, search, searchText);
		} else if(search.equals("licenseContent")){
			listCount = new LicenseDAO().SContentCount(conn, search, searchText);
		}
		
		close(conn);
		
		return listCount;
	}


	public ArrayList<License> sList(String search, String searchText, PageInfo pi) {
		Connection conn = getConnection();
		LicenseDAO dao = new LicenseDAO();
		
		ArrayList<License> list = null;
		
		System.out.println("searchText : " + searchText);
		
		if(!searchText.isEmpty()) {
			if(search.equals("licenseTitle")) {
				list = dao.STitleList(conn, search, searchText, pi);
			} else if(search.equals("licenseContent")){
				list = dao.SContentList(conn, search, searchText, pi);
			}
		} else {
			list = dao.selectLicenseList(conn, pi);
		}
		
		close(conn);
		
		return list;
	}


	public int updateLicense(License l) {
		Connection conn = getConnection();
		int result = new LicenseDAO().updateLicense(conn, l);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
}
