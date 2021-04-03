/*     */ package com.xjb.dao;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class basicDao<T>
/*     */ {
/*     */   Class<T> t;
/*     */   
/*     */   public basicDao() {
/*  21 */     Class<? extends basicDao> clazz = (Class)getClass();
/*  22 */     Type type = clazz.getGenericSuperclass();
/*  23 */     ParameterizedType pt = (ParameterizedType)type;
/*  24 */     Type[] types = pt.getActualTypeArguments();
/*  25 */     this.t = (Class<T>)types[0];
/*     */   }
/*     */   
/*     */   public int update(String sql, Object... args) throws SQLException {
/*  29 */     Connection con = JDBCTools.getConnection();
/*  30 */     PreparedStatement pst = con.prepareStatement(sql);
/*  31 */     if (args != null && args.length > 0) {
/*  32 */       for (int i = 0; i < args.length; i++) {
/*  33 */         pst.setObject(i + 1, args[i]);
/*     */       }
/*     */     }
/*     */     
/*  37 */     int len = pst.executeUpdate();
/*  38 */     pst.close();
/*  39 */     con.close();
/*  40 */     return len;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getbean(String sql, Object... args) throws SQLException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {
/*  45 */     Connection con = JDBCTools.getConnection();
/*  46 */     PreparedStatement pst = con.prepareStatement(sql);
/*  47 */     if (args != null && args.length > 0) {
/*  48 */       for (int i = 0; i < args.length; i++) {
/*  49 */         pst.setObject(i + 1, args[i]);
/*     */       }
/*     */     }
/*  52 */     ResultSet set = pst.executeQuery();
/*     */     
/*  54 */     T truetype = this.t.newInstance();
/*     */     
/*  56 */     ResultSetMetaData data = set.getMetaData();
/*  57 */     int coulmn = data.getColumnCount();
/*  58 */     if (set.next()) {
/*     */ 
/*     */       
/*  61 */       for (int i = 0; i < coulmn; i++) {
/*  62 */         Field field = this.t.getDeclaredField(data.getColumnName(i + 1));
/*  63 */         field.setAccessible(true);
/*  64 */         field.set(truetype, set.getObject(i + 1));
/*     */       } 
/*     */     } else {
/*  67 */       truetype = null;
/*     */     } 
/*  69 */     set.close();
/*  70 */     pst.close();
/*  71 */     return truetype;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<T> getbeans(String sql, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
/*  76 */     Connection con = JDBCTools.getConnection();
/*  77 */     PreparedStatement pst = con.prepareStatement(sql);
/*  78 */     if (args != null && args.length > 0) {
/*  79 */       for (int i = 0; i < args.length; i++) {
/*  80 */         pst.setObject(i + 1, args[i]);
/*     */       }
/*     */     }
/*  83 */     ResultSet set = pst.executeQuery();
/*     */     
/*  85 */     List<T> list = new ArrayList<>();
/*  86 */     ResultSetMetaData data = set.getMetaData();
/*  87 */     int coulmn = data.getColumnCount();
/*     */     
/*  89 */     while (set.next()) {
/*  90 */       T truetype = this.t.newInstance();
/*     */       
/*  92 */       for (int i = 0; i < coulmn; i++) {
/*  93 */         Field field = this.t.getDeclaredField(data.getColumnName(i + 1));
/*  94 */         field.setAccessible(true);
/*  95 */         field.set(truetype, set.getObject(i + 1));
/*     */       } 
/*  97 */       list.add(truetype);
/*     */     } 
/*  99 */     pst.close();
/* 100 */     set.close();
/* 101 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\dao\basicDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */