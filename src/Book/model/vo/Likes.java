package Book.model.vo;

public class Likes {
	private int bookNo;
	private int memNum;

	
	public Likes() {}


	public Likes(int bookNo, int memNum) {
		super();
		this.bookNo = bookNo;
		this.memNum = memNum;
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public int getMemNum() {
		return memNum;
	}


	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}


	@Override
	public String toString() {
		return "Likes [bookNo=" + bookNo + ", memNum=" + memNum + "]";
	}

	
	
}
