package question.model.vo;

import java.sql.Date;

public class Answer {
	private int answerId;
	private String answerTitle;
	private String content;
	private Date andwerCreateAt;
	private int boardNo;
	private String status;
	private int writer;

	public Answer() {

	}

	public Answer(int answerId, String answerTitle, String content, Date andwerCreateAt, int boardNo, String status) {
		super();
		this.answerId = answerId;
		this.answerTitle = answerTitle;
		this.content = content;
		this.andwerCreateAt = andwerCreateAt;
		this.boardNo = boardNo;
		this.status = status;
	}

	

	public Answer(int answerId, String answerTitle, String content, Date andwerCreateAt, int boardNo, String status,
			int writer) {
		super();
		this.answerId = answerId;
		this.answerTitle = answerTitle;
		this.content = content;
		this.andwerCreateAt = andwerCreateAt;
		this.boardNo = boardNo;
		this.status = status;
		this.writer = writer;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAndwerCreateAt() {
		return andwerCreateAt;
	}

	public void setAndwerCreateAt(Date andwerCreateAt) {
		this.andwerCreateAt = andwerCreateAt;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerTitle=" + answerTitle + ", content=" + content
				+ ", andwerCreateAt=" + andwerCreateAt + ", boardNo=" + boardNo + ", status=" + status + "]";
	}

}
