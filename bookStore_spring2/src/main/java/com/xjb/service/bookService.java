package com.xjb.service;

import com.xjb.bean.book;
import java.util.List;
import java.util.Map;

public interface bookService {
  List<book> service_dofilter(Map<String, String> paramMap, int paramInt);
}


