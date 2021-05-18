package license.model.vo;

import java.sql.Date;

public class License {
	private int licenseNo;
	private String licenseTitle;
	private String licenseContent;
	private String licenseWriter;
	private Date createDate;
	private int licenseView;
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	private int answer1;
	private int answer2;
	private int answer3;
	private int answer4;
	private int answer5;
	private String status;
	private String memNick;
	
	public License() {}

	
	
	

	public License(int licenseNo, String licenseTitle, String licenseContent, String licenseWriter, Date createDate,
			int licenseView, String question1, String question2, String question3, String question4, String question5,
			int answer1, int answer2, int answer3, int answer4, int answer5, String status) {
		super();
		this.licenseNo = licenseNo;
		this.licenseTitle = licenseTitle;
		this.licenseContent = licenseContent;
		this.licenseWriter = licenseWriter;
		this.createDate = createDate;
		this.licenseView = licenseView;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.status = status;
	}




	





	public License(int licenseNo, String licenseTitle, String licenseContent, String licenseWriter, Date createDate,
			int licenseView, String memNick) {
		super();
		this.licenseNo = licenseNo;
		this.licenseTitle = licenseTitle;
		this.licenseContent = licenseContent;
		this.licenseWriter = licenseWriter;
		this.createDate = createDate;
		this.licenseView = licenseView;
		this.memNick = memNick;
	}





	public License(int licenseNo, String licenseTitle, String licenseContent, String licenseWriter, Date createDate,
			int licenseView, String question1, String question2, String question3, String question4, String question5,
			int answer1, int answer2, int answer3, int answer4, int answer5) {
		super();
		this.licenseNo = licenseNo;
		this.licenseTitle = licenseTitle;
		this.licenseContent = licenseContent;
		this.licenseWriter = licenseWriter;
		this.createDate = createDate;
		this.licenseView = licenseView;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
	}



	public License(int licenseNo, String licenseTitle, String licenseContent, String licenseWriter, Date createDate, int licenseView) {
		super();
		this.licenseNo = licenseNo;
		this.licenseTitle = licenseTitle;
		this.licenseContent = licenseContent;
		this.licenseWriter = licenseWriter;
		this.createDate = createDate;
		this.licenseView = licenseView;
	}




	public License(int licenseNo, String licenseTitle, String licenseWriter, Date createDate, int licenseView) {
		super();
		this.licenseNo = licenseNo;
		this.licenseTitle = licenseTitle;
		this.licenseWriter = licenseWriter;
		this.createDate = createDate;
		this.licenseView = licenseView;
	}



	public License(int licenseNo, String licenseTitle, String licenseContent, String licenseWriter, Date createDate,
			int licenseView, String question1, String question2, String question3, String question4, String question5,
			int answer1, int answer2, int answer3, int answer4, int answer5, String status, String memNick) {
		super();
		this.licenseNo = licenseNo;
		this.licenseTitle = licenseTitle;
		this.licenseContent = licenseContent;
		this.licenseWriter = licenseWriter;
		this.createDate = createDate;
		this.licenseView = licenseView;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.status = status;
		this.memNick = memNick;
	}





	public License(int licenseNo, String licenseTitle, String licenseContent, String licenseWriter, Date createDate,
			int licenseView, String memNick, String status) {
		super();
		this.licenseNo = licenseNo;
		this.licenseTitle = licenseTitle;
		this.licenseContent = licenseContent;
		this.licenseWriter = licenseWriter;
		this.createDate = createDate;
		this.licenseView = licenseView;
		this.memNick = memNick;
		this.status = status;
	}





	public int getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(int licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLicenseTitle() {
		return licenseTitle;
	}

	public void setLicenseTitle(String licenseTitle) {
		this.licenseTitle = licenseTitle;
	}

	public String getLicenseContent() {
		return licenseContent;
	}

	public void setLicenseContent(String licenseContent) {
		this.licenseContent = licenseContent;
	}

	public String getLicenseWriter() {
		return licenseWriter;
	}

	public void setLicenseWriter(String licenseWriter) {
		this.licenseWriter = licenseWriter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getLicenseView() {
		return licenseView;
	}

	public void setLicenseView(int licenseView) {
		this.licenseView = licenseView;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	public int getAnswer1() {
		return answer1;
	}

	public void setAnswer1(int answer1) {
		this.answer1 = answer1;
	}

	public int getAnswer2() {
		return answer2;
	}

	public void setAnswer2(int answer2) {
		this.answer2 = answer2;
	}

	public int getAnswer3() {
		return answer3;
	}

	public void setAnswer3(int answer3) {
		this.answer3 = answer3;
	}

	public int getAnswer4() {
		return answer4;
	}

	public void setAnswer4(int answer4) {
		this.answer4 = answer4;
	}

	public int getAnswer5() {
		return answer5;
	}

	public void setAnswer5(int answer5) {
		this.answer5 = answer5;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getMemNick() {
		return memNick;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}





	@Override
	public String toString() {
		return "License [licenseNo=" + licenseNo + ", licenseTitle=" + licenseTitle + ", licenseContent="
				+ licenseContent + ", licenseWriter=" + licenseWriter + ", createDate=" + createDate + ", licenseView="
				+ licenseView + ", question1=" + question1 + ", question2=" + question2 + ", question3=" + question3
				+ ", question4=" + question4 + ", question5=" + question5 + ", answer1=" + answer1 + ", answer2="
				+ answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", answer5=" + answer5 + ", status="
				+ status + ", memNick=" + memNick + "]";
	}



	
}
