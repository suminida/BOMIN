package com.it.dto;


   public class MemberVO {
         private String memId;
         private String memName;
         private String memPwd;
         private String memPhone;
         private String memEmail;
         private int   memAuth;
         private String  adminId;
      public String getMemId() {
         return memId;
      }
      public void setMemId(String memId) {
         this.memId = memId;
      }
      public String getMemName() {
         return memName;
      }
      public void setMemName(String memName) {
         this.memName = memName;
      }
      public String getMemPwd() {
         return memPwd;
      }
      public void setMemPwd(String memPwd) {
         this.memPwd = memPwd;
      }
      public String getMemPhone() {
         return memPhone;
      }
      public void setMemPhone(String memPhone) {
         this.memPhone = memPhone;
      }
      public String getMemEmail() {
         return memEmail;
      }
      public void setMemEmail(String memEmail) {
         this.memEmail = memEmail;
      }
      public int getMemAuth() {
         return memAuth;
      }
      public void setMemAuth(int memAuth) {
         this.memAuth = memAuth;
      }
      public String getAdminId() {
         return adminId;
      }
      public void setAdminId(String adminId) {
         this.adminId = adminId;
      }
      @Override
      public String toString() {
         return "MemberVO [memId=" + memId + ", memName=" + memName + ", memPwd=" + memPwd + ", memPhone=" + memPhone
               + ", memEmail=" + memEmail + ", memAuth=" + memAuth + ", adminId=" + adminId + "]";
      }

   
   
}