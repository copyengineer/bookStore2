package com.xjb.dao;

import com.xjb.bean.book;

import java.util.List;


public class bookDaoImpl extends basicDao<book> implements bookDao {

    public List<book> dao_dofilter(String sql) {
        try {
            System.out.println(sql);
            return getbeans(sql, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public int getStartSize() {
        String sql = "select * from book_info";
        try {
            List<book> books = getbeans(sql, new Object[0]);
            int startSize = (books.size() % 6 == 0) ? (books.size() / 6) : (books.size() / 6 + 1);
            System.out.println(startSize);
            return startSize;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}