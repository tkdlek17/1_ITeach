package board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardView;
	private Date create_Date;
	private Date modify_Date;
	private char status;
	private char notice_yn;
	private String region;
	private int like_Count;
	private int mem_Num;
	private int cate_No;
	
	public Board() {}

	public Board(int boardNo, String boardTitle, String boardContent, int boardView, Date create_Date, Date modify_Date,
			char status, char notice_yn, String region, int like_Count, int mem_Num, int cate_No) {
		super();
		this.boardNo = boardNo;
		this.cate_No = cate_No;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.mem_Num = mem_Num;
		this.boardView = boardView;
		this.create_Date = create_Date;
		this.modify_Date = modify_Date;
		this.status = status;
		this.notice_yn = notice_yn;
		this.region = region;
		this.like_Count = like_Count;
		
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardView() {
		return boardView;
	}

	public void setBoardView(int boardView) {
		this.boardView = boardView;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	public Date getModify_Date() {
		return modify_Date;
	}

	public void setModify_Date(Date modify_Date) {
		this.modify_Date = modify_Date;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public char getNotice_yn() {
		return notice_yn;
	}

	public void setNotice_yn(char notice_yn) {
		this.notice_yn = notice_yn;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getLike_Count() {
		return like_Count;
	}

	public void setLike_Count(int like_Count) {
		this.like_Count = like_Count;
	}

	public int getMem_Num() {
		return mem_Num;
	}

	public void setMem_Num(int mem_Num) {
		this.mem_Num = mem_Num;
	}

	public int getCate_No() {
		return cate_No;
	}

	public void setCate_No(int cate_No) {
		this.cate_No = cate_No;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardView=" + boardView + ", create_Date=" + create_Date + ", modify_Date=" + modify_Date
				+ ", status=" + status + ", notice_yn=" + notice_yn + ", region=" + region + ", like_Count="
				+ like_Count + ", mem_Num=" + mem_Num + ", cate_No=" + cate_No + "]";
	}
	
	

}