package Book.model.vo;

public class Book {
	
	private int bookNo;
	private String bookTitle;
	private String bookContent;
	private String bookAuthor;
	private String bookCompany;
	private int bookCount;
	private String nickName;
	private int memNum;
	private int cate_No;
	private char status;
	
	
	public Book() {}


	public Book(int bookNo, String bookTitle, String bookContent, String bookAuthor, String bookCompany, int bookCount,
			String nickName, int memNum, int cate_No, char status) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
		this.bookAuthor = bookAuthor;
		this.bookCompany = bookCompany;
		this.bookCount = bookCount;
		this.nickName = nickName;
		this.memNum = memNum;
		this.cate_No = cate_No;
		this.status = status;
	}


	public Book(int bookNo, String bookTitle, String bookContent, String bookAuthor, String bookCompany,
			String nickName) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
		this.bookAuthor = bookAuthor;
		this.bookCompany = bookCompany;
		this.nickName = nickName;
	}


	public Book(String bookTitle, String bookContent, String bookAuthor, String bookCompany, int memNum) {
		super();
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
		this.bookAuthor = bookAuthor;
		this.bookCompany = bookCompany;
		this.memNum = memNum;
	}


	public Book(int bookNo, String bookTitle, String bookContent, String bookAuthor, String bookCompany, int bookCount,
			String nickName) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookContent = bookContent;
		this.bookAuthor = bookAuthor;
		this.bookCompany = bookCompany;
		this.bookCount = bookCount;
		this.nickName = nickName;
	}

	
	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookContent() {
		return bookContent;
	}


	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public String getBookCompany() {
		return bookCompany;
	}


	public void setBookCompany(String bookCompany) {
		this.bookCompany = bookCompany;
	}


	public int getBookCount() {
		return bookCount;
	}


	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public int getMemNum() {
		return memNum;
	}


	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}


	public int getCate_No() {
		return cate_No;
	}


	public void setCate_No(int cate_No) {
		this.cate_No = cate_No;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookContent=" + bookContent + ", bookAuthor="
				+ bookAuthor + ", bookCompany=" + bookCompany + ", bookCount=" + bookCount + ", nickName=" + nickName
				+ ", memNum=" + memNum + ", cate_No=" + cate_No + ", status=" + status + "]";
	}
	
	
	
	
}