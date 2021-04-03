package com.xjb.servlet;


import com.xjb.bean.book;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class select_page extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private bookFilter bookFilter = new bookFilter();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize, nowPage;
        String page = request.getParameter("page");


        if (request.getSession().getAttribute("pageSize") != null) {
            pageSize = ((Integer) request.getSession().getAttribute("pageSize")).intValue();
            nowPage = ((Integer) request.getSession().getAttribute("nowPage")).intValue();
        } else {
            pageSize = 6;
            nowPage = 1;
        }
        System.out.println(nowPage);
        List<book> books = null;

        if (page.equals("lastPage")) {
            if (nowPage == 1) {
                books = this.bookFilter.dofilter((Map<String, String>) request.getSession().getAttribute("filterMap"), 0);


            } else {


                books = this.bookFilter.dofilter((Map<String, String>) request.getSession().getAttribute("filterMap"), (nowPage - 2) * 6);
                nowPage--;
            }
        }
        if (page.equals("nextPage")) {
            if (nowPage == pageSize) {
                books = this.bookFilter.dofilter((Map<String, String>) request.getSession().getAttribute("filterMap"), (nowPage - 1) * 6);
            } else {
                books = this.bookFilter.dofilter((Map<String, String>) request.getSession().getAttribute("filterMap"), nowPage * 6);
                nowPage++;
                System.out.println(nowPage);
            }
        }

        if (page.equals("firstPage")) {
            books = this.bookFilter.dofilter((Map<String, String>) request.getSession().getAttribute("filterMap"), 0);
            nowPage = 1;
        }
        if (page.equals("endPage")) {
            books = this.bookFilter.dofilter((Map<String, String>) request.getSession().getAttribute("filterMap"), (pageSize - 1) * 6);
            nowPage = pageSize;
        }
        if (page.equals("customerPage")) {
            int pageChoice = Integer.parseInt(request.getParameter("pageChoice"));
            books = this.bookFilter.dofilter((Map<String, String>) request.getSession().getAttribute("filterMap"), (pageChoice - 1) * 6);
            nowPage = pageChoice;
        }

        request.setAttribute("books", books);
        request.getSession().setAttribute("nowPage", Integer.valueOf(nowPage));
        request.getRequestDispatcher("/pages/nologin_pages/index.jsp").forward((ServletRequest) request, (ServletResponse) response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


