/*    */ package com.xjb.filter;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class encodingFilter
/*    */   implements Filter
/*    */ {
/*    */   public void destroy() {}
/*    */   
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/* 20 */     request.setCharacterEncoding("utf-8");
/* 21 */     response.setCharacterEncoding("utf-8");
/* 22 */     chain.doFilter(request, response);
/*    */   }
/*    */   
/*    */   public void init(FilterConfig fConfig) throws ServletException {}
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\filter\encodingFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */