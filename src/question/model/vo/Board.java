package question.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo;
	private String boardTitile;
	private int boardView;
	private String boardContent;
	private Date boardCreateAt;
	private String nickName;
	private Date modifyDate;
	private String status;
	private String noticeYN;
	private String region;
	private int likeCount;
	private int memNum;
	private int cateNum;
	private int id;

	public Board() {

	}
	
	public Board(int boardNo, String boardTitile, int boardView, String boardContent, Date boardCreateAt,
			String nickName, Date modifyDate,int likeCount, int memNum, int cateNum, int id) {
		super();
		this.boardNo = boardNo;
		this.boardTitile = boardTitile;
		this.boardView = boardView;
		this.boardContent = boardContent;
		this.boardCreateAt = boardCreateAt;
		this.nickName = nickName;
		this.modifyDate = modifyDate;
		this.likeCount = likeCount;
		this.memNum = memNum;
		this.cateNum = cateNum;
		this.id = id;
	}


	public Board(int boardNo, String boardTitile, int boardView, String boardContent, Date boardCreateAt,
			String nickName, Date modifyDate, String status, int likeCount, int memNum, int cateNum) {
		super();
		this.boardNo = boardNo;
		this.boardTitile = boardTitile;
		this.boardView = boardView;
		this.boardContent = boardContent;
		this.boardCreateAt = boardCreateAt;
		this.nickName = nickName;
		this.modifyDate = modifyDate;
		this.status = status;
		this.noticeYN = noticeYN;
		this.region = region;
		this.likeCount = likeCount;
		this.memNum = memNum;
		this.cateNum = cateNum;
	}

	public Board(int boardNo, String boardTitile, int boardView, String boardContent, Date boardCreateAt,
			String nickName, Date modifyDate, int likeCount, int memNum, int cateNum) {
		super();
		this.boardNo = boardNo;
		this.boardTitile = boardTitile;
		this.boardView = boardView;
		this.boardContent = boardContent;
		this.boardCreateAt = boardCreateAt;
		this.nickName = nickName;
		this.modifyDate = modifyDate;
		this.likeCount = likeCount;
		this.memNum = memNum;
		this.cateNum = cateNum;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitile() {
		return boardTitile;
	}

	public void setBoardTitile(String boardTitile) {
		this.boardTitile = boardTitile;
	}

	public int getBoardView() {
		return boardView;
	}

	public void setBoardView(int boardView) {
		this.boardView = boardView;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardCreateAt() {
		return boardCreateAt;
	}

	public void setBoardCreateAt(Date boardCreateAt) {
		this.boardCreateAt = boardCreateAt;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNoticeYN() {
		return noticeYN;
	}

	public void setNoticeYN(String noticeYN) {
		this.noticeYN = noticeYN;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public int getCateNum() {
		return cateNum;
	}

	public void setCateNum(int cateNum) {
		this.cateNum = cateNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitile=" + boardTitile + ", boardView=" + boardView
				+ ", boardContent=" + boardContent + ", boardCreateAt=" + boardCreateAt + ", modifyDate=" + modifyDate
				+ ", status=" + status + ", noticeYN=" + noticeYN + ", region=" + region + ", likeCount=" + likeCount
				+ ", memNUm=" + memNum + ", cateNum=" + cateNum + "]";
	}

}
