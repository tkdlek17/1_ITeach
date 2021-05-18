package common.model.vo;

public class Category {
	private int cateNo;
	private String cateName;
	private int memNum;
	private int parentCate;
	
	public Category() {
		
	}

	
	
	public Category(int cateNo, String cateName, int memNum, int parentCate) {
		super();
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.memNum = memNum;
		this.parentCate = parentCate;
	}



	public Category(int cateNo, int memNum, int parentCate) {
		super();
		this.cateNo = cateNo;
		this.memNum = memNum;
		this.parentCate = parentCate;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	
	

	public String getCateName() {
		return cateName;
	}



	public void setCateName(String cateName) {
		this.cateName = cateName;
	}



	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public int getParentCate() {
		return parentCate;
	}

	public void setParentCate(int parentCate) {
		this.parentCate = parentCate;
	}



	@Override
	public String toString() {
		return "Category [cateNo=" + cateNo + ", cateName=" + cateName + ", memNum=" + memNum + ", parentCate="
				+ parentCate + "]";
	}
	
	

}
