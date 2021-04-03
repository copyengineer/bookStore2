/*    */ package com.xjb.bean;
/*    */ 
/*    */ public class user
/*    */ {
/*    */   private String userName;
/*    */   
/*    */   public String getUserName() {
/*  8 */     return this.userName;
/*    */   } private String passWord; private String phoneNumber;
/*    */   public void setUserName(String userName) {
/* 11 */     this.userName = userName;
/*    */   }
/*    */   public String getPassWord() {
/* 14 */     return this.passWord;
/*    */   }
/*    */   public void setPassWord(String passWord) {
/* 17 */     this.passWord = passWord;
/*    */   }
/*    */   public String getPhoneNumber() {
/* 20 */     return this.phoneNumber;
/*    */   }
/*    */   public void setPhoneNumber(String phoneNumber) {
/* 23 */     this.phoneNumber = phoneNumber;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 27 */     return "user [userName=" + this.userName + ", passWord=" + this.passWord + ", phoneNumber=" + this.phoneNumber + "]";
/*    */   }
/*    */   
/*    */   public user(String userName, String passWord, String phoneNumber) {
/* 31 */     this.userName = userName;
/* 32 */     this.passWord = passWord;
/* 33 */     this.phoneNumber = phoneNumber;
/*    */   }
/*    */   
/*    */   public user() {}
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\bea\\user.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */