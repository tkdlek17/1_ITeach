package member.model.service;
import static common.JDBCTemplate.*;
import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	public Member loginMember(Member member) {
		Connection conn = getConnection();
		
		Member loginUser = new MemberDAO().loginMember(conn, member);
		close(conn);
		return loginUser;
	}
	
	
	
	public int insertMember(Member member) {

		Connection conn =  getConnection();
		
		int result = new MemberDAO().insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}



	public Member selectMember(String memId) {
		Connection conn = getConnection();
		
		Member member = new MemberDAO().selectMember(conn, memId);
		return member;
	}



	public int checkNick(String inputNick) {
		Connection conn = getConnection();
		int result = new MemberDAO().checkNick(conn, inputNick);
		
		return result;
	}



	public int checkId(String inputId) {
		Connection conn = getConnection();
		int result = new MemberDAO().checkId(conn, inputId);
		
		return result;
		
	}

	public int updateMember(Member myInfo) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateMember(conn, myInfo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}



	public int updatePwdMember(String memId, String memPwd, String newPwd) {
		Connection conn = getConnection();
		int result = new MemberDAO().updatePwdMember(conn, memId, memPwd, newPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteMember(String memId) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteMember(conn, memId);

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
}
