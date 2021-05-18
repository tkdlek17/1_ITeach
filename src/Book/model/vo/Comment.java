package Book.model.vo;

import java.sql.Date;

public class Comment {
	private int commentNo;
	private String content;
	private String nickname;
	private int memNum;
	private int bookNo;
	private int boardNo;
	private Date createDate;
	private char status;
	
	public Comment () {}

	public Comment(int commentNo, String content, String nickname, int memNum , int bookNo, int boardNo, Date createDate,
			char status) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.nickname = nickname;
		this.memNum = memNum;
		this.bookNo = bookNo;
		this.boardNo = boardNo;
		this.createDate = createDate;
		this.status = status;
	}
	

	public Comment(int commentNo, String content, String nickname, int bookNo, Date createDate) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.nickname = nickname;
		this.bookNo = bookNo;
		this.createDate = createDate;
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

	public String getNickname() {
		return nickname;
	}
	

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public int getmemNum() {
		return memNum;
	}
	
	public void setmemNum(int memNum) {
		this.memNum = memNum;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", content=" + content + ", nickname=" + nickname + ", bookNo="
				+ bookNo + ", boardNo=" + boardNo + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
}
