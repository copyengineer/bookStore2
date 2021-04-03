package com.xjb.servlet;

import com.xjb.bean.book;
import com.xjb.dao.bookDao;
import com.xjb.dao.bookDaoImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class client_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private bookFilter bookFilter = new bookFilter();
    private bookDao bookDao = (bookDao) new bookDaoImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<book> books = this.bookFilter.dofilter(null, 0);
        request.setAttribute("books", books);

        int startSize = this.bookDao.getStartSize();
        request.getSession().setAttribute("pageSize", Integer.valueOf(startSize));
        request.getSession().setAttribute("nowPage", Integer.valueOf(1));
        request.getSession().setAttribute("selected", new HashMap<>());
        request.getRequestDispatcher("/pages/nologin_pages/index.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


