package board.model.vo;

import java.sql.Date;

public class Files {
	private int fileNo;
	private String fileName;	// originName
	private Date create;		// uploadDate
	private String filePath;
	private String changeName;	// changeName
	private int fileLevel;
	private char status;
	private int cateNo;
	
	public Files() {}


	public Files(int fileNo, String fileName, Date create, String filePath, String changeName, int fileLevel,
			char status, int cateNo) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.create = create;
		this.filePath = filePath;
		this.changeName = changeName;
		this.fileLevel = fileLevel;
		this.status = status;
		this.cateNo = cateNo;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
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

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
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

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	@Override
	public String toString() {
		return "Files [fileNo=" + fileNo + ", fileName=" + fileName + ", create=" + create + ", filePath=" + filePath
				+ ", changeName=" + changeName + ", fileLevel=" + fileLevel + ", status=" + status + ", cateNo="
				+ cateNo + "]";
	}

	
	
	
	
}
