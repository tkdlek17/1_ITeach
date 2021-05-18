package grammar.model.vo;

public class Grammar {
	private int grammarNo;
	private int boardNo;
	private char status;
	
	public Grammar() {}

	public Grammar(int grammarNo, int boardNo, char status) {
		super();
		this.grammarNo = grammarNo;
		this.boardNo = boardNo;
		this.status = status;
	}

	public int getGrammarNo() {
		return grammarNo;
	}

	public void setGrammarNo(int grammarNo) {
		this.grammarNo = grammarNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
	
	

}
