package com.xjb.servlet;

import com.xjb.bean.user;
import com.xjb.dao.userDaoImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class login_register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userDaoImpl userdao = new userDaoImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type.equals("login")) {
            String username_login = request.getParameter("username_login");
            String phoneNumber_login = request.getParameter("phoneNumber_login");
            String password_login = request.getParameter("password_login");
            String code1 = request.getParameter("cheackCode");
            String code2 = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
            if (!code1.equals(code2)) {
                request.setAttribute("login_sucess", "验证码输入错误");
                request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
                request.getRequestDispatcher("/pages/nologin_pages/loginAndRegister.jsp").forward((ServletRequest) request, (ServletResponse) response);
            } else {
                user user = new user(username_login, password_login, phoneNumber_login);

                user cheackUser = this.userdao.cheackUser(user);

                if (cheackUser != null) {
                    request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

                    request.getRequestDispatcher("/pages/index.jsp").forward((ServletRequest) request, (ServletResponse) response);
                } else {
                    request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
                    request.setAttribute("login_sucess", "用户名或密码有误，请重新输入");
                    request.getRequestDispatcher("/pages/nologin_pages/loginAndRegister.jsp").forward((ServletRequest) request, (ServletResponse) response);
                }

            }

        } else if (request.getParameter("action").equals("cheackUserName")) {
            String value = request.getParameter("value");
            if (this.userdao.getOneUser(value) != null) {
                response.getWriter().write("{\"isExist\":\"用户名已存在!!!\"}");
                System.out.println("用户名存在");
            } else {
                response.getWriter().write("{\"isExist\":\"欢迎注册\"}");
            }
        } else {
            String username_register = request.getParameter("username_register");
            String phoneNumber_register = request.getParameter("phoneNumber_register");
            String password_register = request.getParameter("password_register");
            user user = new user(username_register, password_register, phoneNumber_register);

            int addUser = this.userdao.addUser(user);
            if (addUser == 1) {
                request.getRequestDispatcher("/pages/nologin_pages/loginAndRegister.jsp").forward((ServletRequest) request, (ServletResponse) response);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


