package Book.model.vo;

import java.sql.Date;

public class Files {
	private int fileNo;
	private String fileName;
	private String filePath;
	private String changeName;
	private char status;
	private int articleNo;
	private int fileLevel;
	private int bookNo;
	private Date createDate;
	
	public Files() {}

	public Files( int bookNo, String changeName) {
		super();
		this.bookNo = bookNo;
		this.changeName = changeName;
	}

	public Files(int fileNo, String fileName, String filePath, String changeName, char status, int articleNo,
			int fileLevel, int bookNo, Date createDate) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.changeName = changeName;
		this.status = status;
		this.articleNo = articleNo;
		this.fileLevel = fileLevel;
		this.bookNo = bookNo;
		this.createDate = createDate;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Files [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", changeName="
				+ changeName + ", status=" + status + ", articleNo=" + articleNo + ", fileLevel=" + fileLevel
				+ ", bookNo=" + bookNo + ", createDate=" + createDate + "]";
	}

	
	
	
}
