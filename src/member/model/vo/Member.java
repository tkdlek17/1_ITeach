package member.model.vo;

import java.sql.Date;

public class Member {
	private int memNum;
	private String memId;
	private String memPwd;
	private String memName;
	private String memNick;
	private String gender;
	private String email;
	private Date enrollDate ;
	private String isStaff;
	private String status;
	

	
	public Member() {}
	
	public Member(String memId, String memPwd) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
	}
	
	public Member(int memNum) {
		super();
		this.memNum = memNum;
		
	}
	
	public Member(String memId, String memPwd, String memName, String memNick, String gender, String email) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.memNick = memNick;
		this.gender = gender;
		this.email = email;
		
	}
	
	public Member(String memId, String memName, String memNick, String gender, String email) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memNick = memNick;
		this.gender = gender;
		this.email = email;
		
	}
	public Member(int memNum, String memId, String memPwd, String memName, String memNick, String gender,
			String email, Date enrollDate, String isStaff, String status) {
		super();
		this.memNum = memNum;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.memNick = memNick;
		this.gender = gender;
		this.email = email;
		this.enrollDate = enrollDate;
		this.isStaff = isStaff;
		this.status = status;
		
		
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemNick() {
		return memNick;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(String isStaff) {
		this.isStaff = isStaff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [memNum=" + memNum + ", memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName
				+ ", memNick=" + memNick + ", gender=" + gender + ", email=" + email + ", enrollDate=" + enrollDate
				+ ", isStaff=" + isStaff + ", status=" + status + "]";
	}
	
	
}
