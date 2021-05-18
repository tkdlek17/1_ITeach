package hire.model.vo;

import java.sql.Date;

public class Hire {
	private int hireNo;
	private String hireCompany;
	private String hireName;
	private String hireEmail;
	private String hireField;
	private int employNum;
	private Date hireDate;
	private String companyAddress;
	private String writer;
	private int viewCount;
	private String hireYN;
	private Date createDate;
	private String status;
	private int cateNo;
	
	public Hire() {}
	

	public Hire(String hireCompany, String hireName, String hireEmail, String hireField, int employNum, Date hireDate,
			String companyAddress, int cateNo) {
		super();
		this.hireCompany = hireCompany;
		this.hireName = hireName;
		this.hireEmail = hireEmail;
		this.hireField = hireField;
		this.employNum = employNum;
		this.hireDate = hireDate;
		this.companyAddress = companyAddress;
		this.cateNo = cateNo;
	}

	public Hire(String hireCompany, String hireName, String hireEmail, String hireField, int employNum, Date hireDate,
			String companyAddress, String writer, int cateNo) {
		super();
		this.hireCompany = hireCompany;
		this.hireName = hireName;
		this.hireEmail = hireEmail;
		this.hireField = hireField;
		this.employNum = employNum;
		this.hireDate = hireDate;
		this.companyAddress = companyAddress;
		this.writer = writer;
		this.cateNo = cateNo;
	}


	public Hire(int hireNo, String hireCompany, String hireName, String hireEmail, String hireField, int employNum,
			Date hireDate, String companyAddress, String writer, int viewCount, String hireYN, Date createDate,
			String status, int cateNo) {
		super();
		this.hireNo = hireNo;
		this.hireCompany = hireCompany;
		this.hireName = hireName;
		this.hireEmail = hireEmail;
		this.hireField = hireField;
		this.employNum = employNum;
		this.hireDate = hireDate;
		this.companyAddress = companyAddress;
		this.writer = writer;
		this.viewCount = viewCount;
		this.hireYN = hireYN;
		this.createDate = createDate;
		this.status = status;
		this.cateNo = cateNo;
	}

	public int getHireNo() {
		return hireNo;
	}

	public void setHireNo(int hireNo) {
		this.hireNo = hireNo;
	}

	public String getHireCompany() {
		return hireCompany;
	}

	public void setHireCompany(String hireCompany) {
		this.hireCompany = hireCompany;
	}

	public String getHireName() {
		return hireName;
	}

	public void setHireName(String hireName) {
		this.hireName = hireName;
	}

	public String getHireEmail() {
		return hireEmail;
	}

	public void setHireEmail(String hireEmail) {
		this.hireEmail = hireEmail;
	}

	public String getHireField() {
		return hireField;
	}

	public void setHireField(String hireField) {
		this.hireField = hireField;
	}

	public int getEmployNum() {
		return employNum;
	}

	public void setEmployNum(int employNum) {
		this.employNum = employNum;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getHireYN() {
		return hireYN;
	}

	public void setHireYN(String hireYN) {
		this.hireYN = hireYN;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
		return "Hire [hireNo=" + hireNo + ", hireCompany=" + hireCompany + ", hireName=" + hireName + ", hireEmail="
				+ hireEmail + ", hireField=" + hireField + ", employNum=" + employNum + ", hireDate=" + hireDate
				+ ", companyAddress=" + companyAddress + ", writer=" + writer + ", viewCount=" + viewCount + ", hireYN="
				+ hireYN + ", createDate=" + createDate + ", status=" + status + ", cateNo=" + cateNo + "]";
	}


}
