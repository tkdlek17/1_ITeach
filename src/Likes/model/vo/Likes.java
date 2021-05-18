package Likes.model.vo;

public class Likes {
	private int likeNo;
	private int bookNo;
	private int likeCount;
	private String nickname;
	
	public Likes() {}
	
	public Likes( int bookNoString,String nickname) {
		super();
		this.bookNo = bookNo;
		this.nickname = nickname;
	}


	public Likes(int likeNo, int bookNo, int likeCount, String nickname) {
		super();
		this.likeNo = likeNo;
		this.bookNo = bookNo;
		this.likeCount = likeCount;
		this.nickname = nickname;
	}


	public int getLikeNo() {
		return likeNo;
	}


	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public int getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	@Override
	public String toString() {
		return "Likes [likeNo=" + likeNo + ", bookNo=" + bookNo + ", likeCount=" + likeCount + ", nickname=" + nickname
				+ "]";
	}
	
	
	
}
