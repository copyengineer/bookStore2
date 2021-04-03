package com.xjb.service;

import com.xjb.bean.book;
import com.xjb.dao.bookDao;
import com.xjb.dao.bookDaoImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class bookImpl implements bookService {
    private bookDao book_dao = (bookDao) new bookDaoImpl();


    public List<book> service_dofilter(Map<String, String> map, int start) {
        String sql = "select * from book_info where";
        String[] keys = new String[6];

        if (map == null) {
            sql = "select * from book_info limit " + start + "," + '6';
        } else if (map.size() == 0 && start < 0) {
            sql = "select * from book_info";
        } else if (map.size() != 0) {
            Set<String> keySet = map.keySet();
            int i = 0;
            for (String key : keySet) {
                if (!key.equals("firstWord") && !((String) map.get(key)).equals("全部作品") && !((String) map.get(key)).equals("全部") && !key.equals("book_updatetime")) {
                    keys[i] = key;
                    i++;
                }
            }

            int len = 0;
            for (int k = 0; k < keys.length; k++) {
                if (keys[k] != null) {
                    len++;
                }
            }

            for (int j = 0; j < len; j++) {

                if (j != len - 1) {
                    sql = String.valueOf(sql) + " " + keys[j] + "=" + '\'' + (String) map.get(keys[j]) + '\'' + " and";
                } else if (start < 0) {
                    sql = String.valueOf(sql) + " " + keys[j] + "=" + '\'' + (String) map.get(keys[j]) + '\'';
                } else {
                    sql = String.valueOf(sql) + " " + keys[j] + "=" + '\'' + (String) map.get(keys[j]) + '\'' + " limit " + start + "," + '6';
                }
            }
        } else {

            sql = "select * from book_info limit " + start + "," + '6';
        }
        return this.book_dao.dao_dofilter(sql);
    }
}


