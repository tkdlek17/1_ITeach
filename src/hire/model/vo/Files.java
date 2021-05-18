package hire.model.vo;

import java.sql.Date;

public class Files {
	private int fileNo;
	private String fileName; // 기존 파일명
	private String filePath;
	private String changeName; // 변경된 파일명
	private String status;
	private int fileLevel; //썸네일 구분용도 0은 대표이미지 1은 썸네일
	private int boardNo;
	private int hireNo;
	
	public Files() {}

	public Files(String changeName, int hireNo) {
		super();
		this.changeName = changeName;
		this.hireNo = hireNo;
	}

	public Files(int fileNo, String fileName, String filePath, String changeName, String status, int fileLevel,
			int boardNo, int hireNo) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.changeName = changeName;
		this.status = status;
		this.fileLevel = fileLevel;
		this.boardNo = boardNo;
		this.hireNo = hireNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getHireNo() {
		return hireNo;
	}

	public void setHireNo(int hireNo) {
		this.hireNo = hireNo;
	}

	@Override
	public String toString() {
		return "Files [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", changeName="
				+ changeName + ", status=" + status + ", fileLevel=" + fileLevel + ", boardNo=" + boardNo + ", hireNo="
				+ hireNo + "]";
	}
	
	

}
