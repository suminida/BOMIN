package com.it.dto;

import java.util.Date;//���� util ���� ����Ѵ�.

public class BoardVO {//int, date�� ���鶧 

	
	private String boardNo; //�Խ��� ��ȣ
	private String boardTitle; //�Խ��� �̸�
	private String  boardDate ; //�Խ��� �ۼ�����
	private int boardHits;   //�Խ�����ȸ��
	private String boardContents; // �Խ��� ����
	private String memberId;    // �Խ����й�
	private String adminId;        // �Խ��� ������
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

