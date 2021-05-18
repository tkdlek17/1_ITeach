package license.model.vo;

import java.sql.Date;

public class Comments {
	private int commentNo;
	private String content;
	private Date createDate;
	private int boardNo;
	private int memNum;
	private String memNick;
	private String status;
	private int licenseNo;
	
	
	public Comments() {}
		
	public Comments(int commentNo, String content, Date createDate, int boardNo, int memNum, String memNick,
			String status, int licenseNo) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.memNum = memNum;
		this.memNick = memNick;
		this.status = status;
		this.licenseNo = licenseNo;
	}
	
	
	
	public Comments(int commentNo, String content, Date createDate, int boardNo, int memNum, String status,
			int licenseNo) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.memNum = memNum;
		this.status = status;
		this.licenseNo = licenseNo;
	}
	
	


	public Comments(int commentNo, String content, int licenseNo, Date createDate, String memNick) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.licenseNo = licenseNo;
		this.createDate = createDate;
		this.memNick = memNick;
	}

	public Comments(int commentNo, String content, Date createDate, int boardNo, int memNum, String status) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.memNum = memNum;
		this.status = status;
	}

	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getMemNick() {
		return memNick;
	}
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(int licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Override
	public String toString() {
		return "Comments [commentNo=" + commentNo + ", content=" + content + ", createDate=" + createDate + ", boardNo="
				+ boardNo + ", memNum=" + memNum + ", memNick=" + memNick + ", status=" + status + ", licenseNo="
				+ licenseNo + "]";
	}
	
	
	

}
