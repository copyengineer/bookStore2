/*    */ package com.xjb.dao;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.util.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JDBCTools
/*    */ {
/*    */   public static Connection getConnection(){
/* 14 */     try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	 Properties properties = new Properties();
	 properties.load(JDBCTools.class.getClassLoader().getResourceAsStream("druid.properties"));
	 String str1 = properties.getProperty("url");
	 System.out.println(str1);
	 String str2 = properties.getProperty("username");
	 System.out.println(str2);
	 String str3 = properties.getProperty("password");
	 System.out.println(str3);
	 return DriverManager.getConnection(str1, str2, str3);
	 
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return null;
	
}
/* 15 */    
/* 16 */     
/* 17 */     
/* 18 */     
/* 19 */     
/* 20 */     
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\dao\JDBCTools.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */