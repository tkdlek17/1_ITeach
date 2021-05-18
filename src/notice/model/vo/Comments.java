package notice.model.vo;

import java.sql.Date;

public class Comments {
	private int commentNo;
	private String content;
	private int noticeNo;
	private int memNum;
	private String memNick;
	private Date createDate;
	private String status;
	
	public Comments() {
		
	}

	public Comments(int commentNo, String content, int noticeNo, int memNum, String memNick, Date createDate,
			String status) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.noticeNo = noticeNo;
		this.memNum = memNum;
		this.memNick = memNick;
		this.createDate = createDate;
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

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Comments [commentNo=" + commentNo + ", content=" + content + ", noticeNo=" + noticeNo + ", memNum="
				+ memNum + ", memNick=" + memNick + ", createDate=" + createDate + ", status=" + status + "]";
	}
}
