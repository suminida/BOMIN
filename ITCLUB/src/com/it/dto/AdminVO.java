package com.it.dto;

public class AdminVO {

	private String adminId;
	private String adminPwd;
	private int  authority;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "AdminVO [adminId=" + adminId + ", adminPwd=" + adminPwd + ", authority=" + authority + "]";
	}
	

	
}
