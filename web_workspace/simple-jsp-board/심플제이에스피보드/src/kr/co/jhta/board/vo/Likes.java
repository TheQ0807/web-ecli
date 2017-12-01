package kr.co.jhta.board.vo;

public class Likes {

	private String userId;
	private int boardNo;
	
	public Likes() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "Likes [userId=" + userId + ", boardNo=" + boardNo + "]";
	}
	
	
}
