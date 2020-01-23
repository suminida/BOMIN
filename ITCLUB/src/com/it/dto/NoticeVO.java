package com.it.dto;

public class NoticeVO {
   private String notiNo;
   private String notiTitle;
   private String notiContents;
   private String notiDate;
   private String  adminId;
public String getNotiNo() {
   return notiNo;
}
public void setNotiNo(String notiNo) {
   this.notiNo = notiNo;
}
public String getNotiTitle() {
   return notiTitle;
}
public void setNotiTitle(String notiTitle) {
   this.notiTitle = notiTitle;
}
public String getNotiContents() {
   return notiContents;
}
public void setNotiContents(String notiContents) {
   this.notiContents = notiContents;
}
public String getNotiDate() {
   return notiDate;
}
public void setNotiDate(String notiDate) {
   this.notiDate = notiDate;
}
public String getAdminId() {
   return adminId;
}
public void setAdminId(String adminId) {
   this.adminId = adminId;
}

@Override
public String toString() {
   return "NoticeVO [notiNo=" + notiNo + ", notiTitle=" + notiTitle + ", notiContents=" + notiContents + ", notiDate="
         + notiDate + ", adminId=" + adminId + "]";
}
   




}