package com.it.dto;

import java.util.Date;//거의 util 많이 사용한다.

public class BoardVO {//int, date로 만들때 

	
	private String boardNo; //게시판 번호
	private String boardTitle; //게시판 이름
	private String  boardDate ; //게시판 작성일자
	private int boardHits;   //게시판조회수
	private String boardContents; // 게시판 내용
	private String memberId;    // 게시판학번
	private String adminId;        // 게시판 관리자
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardHits() {
		return boardHits;
	}
	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate
				+ ", boardHits=" + boardHits + ", boardContents=" + boardContents + ", memberId=" + memberId
				+ ", adminId=" + adminId + "]";
	}
	

	
	
}

