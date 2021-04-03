<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>网上书城</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <base href="http://118.31.245.190:80/bookStore_spring2/">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
	<h1>劳保洒勒嗯歪属</h1>
	<h1>辛逸成是傻逼</h1>
<div class="main">
        <div class="head">
            <div class="head_top">
                <img src="img/logo.png" alt="" class="logo">
                <form action="searchBook">
                	<input type="text" class="search" name="userInput">
                	<input type="submit" class="search_btn" value="">
                </form>
                <div class="login_register_recharge">
                    <a href="" class="recharge">充值</a>
                    <a href="" class="login">登陆</a>
                    <a href="" class="register">注册</a>
                </div>
            </div>
        </div>

        <div class="type">
            <div class="content">
                <div class="sex_type">
                    <a href="" class="boy_type active">男生频道</a>
                    <span>|</span>
                    <a href="" class="gril-type">女生频道</a>
                </div>
                <div class="book_type kind">
                    <div class="type_name">作品分类:</div>
                    <a class="active2" style="width: 66px;">全部作品</a>
                    <a>奇幻玄幻</a>
                    <a>武侠仙侠</a>
                    <a>历史军事</a>
                    <a>都市娱乐</a>
                    <a>科幻游戏</a>
                    <a>悬疑灵异</a>
                    <a>竞技同人</a>
                    <a>评论文集</a>
                    <a>二次元</a>
                </div>
                <div class="write_schedule kind">
                    <div class="type_name">写作进度:</div>
                    <a class="active2">全部</a>
                    <a>连载中</a>
                    <a>已完结</a>
                </div>
                <div class="word_num kind">
                    <div class="type_name">作品字数:</div>
                    <a style="width: 39px;" class="active2">全部</a>
                    <a>30万字以下</a>
                    <a>30-50万</a>
                    <a>50万-100万</a>
                    <a>100万-200万</a>
                    <a>200万以上</a>
                </div>
                <div class="update_time kind">
                    <div class="type_name">更新时间:</div>
                    <a class="active2">全部</a>
                    <a>三日内</a>
                    <a>七日内</a>
                    <a>半月内</a>
                    <a>一月内</a>
                </div>
                <div class="first_word kind">
                    <div class="type_name">书名首字母:</div>
                    <a style="width: 39px;" class="active2">全部</a>
                    <a>A</a>
                    <a>B</a>
                    <a>C</a>
                    <a>D</a>
                    <a>E</a>
                    <a>F</a>
                    <a>G</a>
                    <a>H</a>
                    <a>I</a>
                    <a>J</a>
                    <a>K</a>
                    <a>L</a>
                    <a>M</a>
                    <a>N</a>
                    <a>O</a>
                    <a>P</a>
                    <a>Q</a>
                    <a>R</a>
                    <a>S</a>
                    <a>T</a>
                    <a>U</a>
                    <a>V</a>
                    <a>W</a>
                    <a>X</a>
                    <a>Y</a>
                    <a>Z</a>
                </div>
                <div class="other kind">
                    <div class="type_name">其他:</div>
                    <a class="active2">全部</a>
                    <a>免费</a>
                    <a>VIP</a>
                </div>
                <div class="cut_line" style="margin: 5px auto;height: 1px;background: #e6e6e6;"></div>
                <div class="selected">
                    <div class="type_name" style="line-height: 32px;">已选条件:</div>
                    <c:forEach var="selected" items="${selected }">
                    	<span>${selected.value }
                    		<a href="removeSelected?value=${selected.key }"></a>
                    	</span>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="book">
            <c:forEach var="book" items="${books }">
            	<div class="one_book">
                	<div class="preview_img">
                    	<img src="img/${book.getBook_img() }.jpeg" alt="">
                	</div>
                	<div class="book_info">
                    	<div class="book_name"><a href="">${book.getBook_name() }</a>
                    </div>
                    <div class="book_link">
                        <a href="" class="author">${book.getBook_author() }</a>
                        |
                        <a href="" class="type_info">${book.getBook_type() }</a>
                        |
                        <span>${book.getWrite_schedule() }</span>
                        <span>更新时间 ${book.getBook_updatetime() }</span>
                    </div>
                    <div class="book_desc">
                        ${book.getBook_preview() }
                    </div>
                    <div class="latest">
                        ${book.getBook_latest() }
                    </div>
                </div>
       		</div>
          	</c:forEach>
            <div class="page_choice" style="float: left;">
            	<a href="select_page?page=lastPage">上一页</a>
            	<a href="select_page?page=firstPage">首页</a>
                <a href="select_page?page=endPage">尾页</a>
                <a href="select_page?page=nextPage">下一页</a>
                 	跳转到:
                <form action="select_page?page=customerPage" method="post">
                	<input type="text" value="1" name="pageChoice"/>/<span>${pageSize }页</span>
                	<input type="submit" value="跳转" style="background: #fff;width: 40px;"/>
                </form>
                	当前页:<span>第${nowPage }页</span>
            </div>
        </div>

        <div style="height: 500px;"></div>
    </div>
    
    <script src="js/bookType.js"></script>
    <script src="js/firstWord.js"></script>
    <script src="js/other.js"></script>
    <script src="js/updateTime.js"></script>
    <script src="js/wordNum.js"></script>
    <script src="js/writeSchedule.js"></script>
</body>
</html>
