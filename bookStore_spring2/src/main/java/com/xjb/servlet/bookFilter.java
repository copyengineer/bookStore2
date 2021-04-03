package com.xjb.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xjb.bean.book;
import com.xjb.service.bookImpl;
import com.xjb.service.bookService;

public class bookFilter extends HttpServlet {

    bookService book_service = new bookImpl();
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String value = request.getParameter("value");

        Map<String, String> filterMap = null;

        if (request.getSession().getAttribute("filterMap") == null) {
            filterMap = new HashMap<>();
            filterMap.put(name, value);
            request.getSession().setAttribute("filterMap", filterMap);
        } else {
            filterMap = (Map<String, String>) request.getSession().getAttribute("filterMap");
            if (name != null && value != null) {
                filterMap.put(name, value);
            }
        }
        List<book> books = dofilter(filterMap, 0);
        System.out.println(filterMap);
        int size = dofilter(filterMap, -1).size();
        int pageSize = (size % 6 == 0) ? (size / 6) : (size / 6 + 1);
        Map<String, String> selected = select_item(filterMap);

        request.setAttribute("books", books);
        request.getSession().setAttribute("selected", selected);
        request.getSession().setAttribute("pageSize", Integer.valueOf(pageSize));
        request.getSession().setAttribute("nowPage", Integer.valueOf(1));
        System.out.println(pageSize);
        request.getRequestDispatcher("/pages/nologin_pages/index.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }


    public Map<String, String> select_item(Map<String, String> filterMap) {

        Set<String> keySet = filterMap.keySet();
        Map<String, String> filterMap2 = new HashMap<>();
        for (String key : keySet) {
            if (!((String) filterMap.get(key)).equals("全部") && !((String) filterMap.get(key)).equals("全部作品")) {
                filterMap2.put(key, filterMap.get(key));
            }
        }
        return filterMap2;
    }


    public List<book> dofilter(Map<String, String> filterMap, int start) {

        return this.book_service.service_dofilter(filterMap, start);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 79 */
        doGet(request, response);
    }
}
