package board.model.vo;

public class Attachment {
	private int fileId;
	private int boardNo;
	private String originName;
	private String chageName;
	private String filePath;
	private int filelevle;
	private int downloadCount;
	private String status;
	
	public Attachment () {}
	
	public Attachment(int boardNo, String chageName) {
		super();
		this.boardNo = boardNo;
		this.chageName = chageName;
	}
	
	public Attachment(int fileId, int boardNo, String originName, String chageName, String filePath, int filelevle,
			int downloadCount, String status) {
		super();
		this.fileId = fileId;
		this.boardNo = boardNo;
		this.originName = originName;
		this.chageName = chageName;
		this.filePath = filePath;
		this.filelevle = filelevle;
		this.downloadCount = downloadCount;
		this.status = status;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChageName() {
		return chageName;
	}

	public void setChageName(String chageName) {
		this.chageName = chageName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFilelevle() {
		return filelevle;
	}

	public void setFilelevle(int filelevle) {
		this.filelevle = filelevle;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fileId=" + fileId + ", boardNo=" + boardNo + ", originName=" + originName + ", chageName="
				+ chageName + ", filePath=" + filePath + ", filelevle=" + filelevle + ", downloadCount=" + downloadCount
				+ ", status=" + status + "]";
	}
	
	
	
	
}
