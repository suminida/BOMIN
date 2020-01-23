package com.it.dto;

public class IntroductionVO {
	
	private String introNo;
	private String adminId; //소개글 관리자번호
	private String introName; //소개슬이름
	private String introContents; //소새글  내용
	private String introHistory;  //소개글 연혁
	
	
	@Override
	public String toString() {
		return "IntroductionVO [introNo=" + introNo + ", adminId=" + adminId + ", introName=" + introName
				+ ", introContents=" + introContents + ", introHistory=" + introHistory + "]";
	}
	public String getIntroNo() {
		return introNo;
	}
	public void setIntroNo(String introNo) {
		this.introNo = introNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getIntroName() {
		return introName;
	}
	public void setIntroName(String introName) {
		this.introName = introName;
	}
	public String getIntroContents() {
		return introContents;
	}
	public void setIntroContents(String introContents) {
		this.introContents = introContents;
	}
	public String getIntroHistory() {
		return introHistory;
	}
	public void setIntroHistory(String introHistory) {
		this.introHistory = introHistory;
	}
	

	
	
}
