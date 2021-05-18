package board.model.vo;

import java.sql.Date;

public class Fboard {
	private int boardNo;
	private String boardTitle;
	private int boardView;
	private Date createDate;
	private Date modifyDate;
	private String region;
	private String status;
	private int memNum;
	private int cateNo;
	private String memNick;
	private String cateName;
	private int id;
	private String boardContent;
	
	public Fboard() {
	
	}
	
	public Fboard(int boardNo, String boardTitle, int boardView, Date createDate, Date modifyDate, String status,
			int memNum, int cateNo, String memNick, String cateName, int id, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardView = boardView;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.memNum = memNum;
		this.cateNo = cateNo;
		this.memNick = memNick;
		this.cateName = cateName;
		this.id = id;
		this.boardContent = boardContent;
	}

	public Fboard(int boardNo, String boardTitle, int boardView, Date createDate, Date modifyDate, String region,
			String status, int memNum, int cateNo, String memNick, String cateName, int id, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardView = boardView;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.region = region;
		this.status = status;
		this.memNum = memNum;
		this.cateNo = cateNo;
		this.memNick = memNick;
		this.cateName = cateName;
		this.id = id;
		this.boardContent = boardContent;
	}

	public Fboard(int boardNo, String boardTitle, int id, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.id = id;
		this.boardContent = boardContent;
	}

	public Fboard(int boardNo, String boardTitle, String region, int id, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.region = region;
		this.id = id;
		this.boardContent = boardContent;
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
	public int getBoardView() {
		return boardView;
	}
	public void setBoardView(int boardView) {
		this.boardView = boardView;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getMemNick() {
		return memNick;
	}
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "Fboard [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardView=" + boardView
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", region=" + region + ", status="
				+ status + ", memNum=" + memNum + ", cateNo=" + cateNo + ", memNick=" + memNick + ", cateName="
				+ cateName + ", id=" + id + ", boardContent=" + boardContent + "]";
	}
	
}
