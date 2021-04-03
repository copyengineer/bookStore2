package com.xjb.dao;

import com.xjb.bean.book;

import java.util.List;

public interface bookDao {

    List<book> dao_dofilter(String paramString);

    int getStartSize();
}

