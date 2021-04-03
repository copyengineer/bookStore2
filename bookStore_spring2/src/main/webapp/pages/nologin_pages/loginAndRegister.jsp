<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <base href="http://localhost:8080/bookStore_spring/">
    <link rel="stylesheet" href="css/loginAndRegister.css">
     
</head>
<body>
    <div class="login">
        <h3 class="read" onclick="click()">用阅读</h3>
        <p class="change">改变我们的一生</p>

        <div class="choice">
            <ul class="tab">
                <li class="active" id="f1" style=" border-radius: 20px 20px 0px 0px;user-select: none;">登陆</li>
                <li id="f2" style=" border-radius: 20px 20px 0px 0px;user-select: none;">注册</li>
            </ul>
           
            <div class="tab1" style="display: block;" >
                <form action="login_register?type=login" method="post">
                    <p style="position: absolute;top: 60px;height: 30px;text-align: center;line-height: 30px;width: 480px;color: red;">${login_sucess }</p>
                    <dl class="dl1">
                        <dt>用户名</dt>
                        <dd>
                            <input id="id1" title="请输入用户名" type="text" value="请输入用户名" onclick="c(id,title)" onblur="c1(id,title)" name="username_login">
                        </dd>
                    </dl>
                    <dl class="dl2">
                        <dt>手机号</dt>
                        <dd>
                            <input type="text" title="请输入手机号" value="请输入手机号" onclick="c(id,title)" id="id2" onblur="c1(id,title)" name="phoneNumber_login">
                        </dd>
                    </dl>
                    <dl class="dl3">
                        <dt>密      码</dt>
                        <dd>
                            <input type="text" title="请输入密码" value="请输入密码" onclick="c(id,title)" id="id3" onblur="c1(id,title)" name="password_login">
                        </dd>
                    </dl>
                    <dl class="dl4">
                        <dt>验证码</dt>
                        <dd>
                            <input type="text" title="请输入验证码" value="请输入验证码" name="cheackCode">
                            <img src="kaptcha.jpg" alt="" id="codeImg">
                        </dd>
                    </dl>
                    <button style="position: absolute;top: 478px;left:20px ;width: 440px;height: 50px;background: #BDCEFC;color: #fff;border-radius: 25px;cursor: pointer;border-style: none;">立即登陆</button>
                </form>
            </div>
            <div class="tab2" style="display: none;">
                <p style="position: absolute;top: 60px;height: 30px;text-align: center;line-height: 30px;width: 480px;color: red;">欢迎注册</p>
                <form action="login_register?type=register&action=register" method="post">
                    <dl class="dl1">
                        <dt>用户名</dt>
                        <dd>
                            <input type="text" value="请输入用户名" id="id11" title="请输入用户名" onclick="c(id,title)" onblur="c3(id,title)" autocomplete="on" name="username_register">
                        </dd>
                    </dl>
                    <dl class="dl2">
                        <dt>手机号</dt>
                        <dd>
                            <input type="text" value="请输入手机号" id="id22" title="请输入手机号" onclick="c(id,title)" onblur="c1(id,title)" name="phoneNumber_register">
                        </dd>
                    </dl>
                    <dl class="dl3">
                        <dt>密      码</dt>
                        <dd>
                            <input type="text" value="请输入密码" id="id33" title="请输入密码" onclick="c(id,title)" onblur="c1(id,title)" name="password_register">
                        </dd>
                    </dl>
                    <dl class="dl4">
                        <dt>确认密码</dt>
                        <dd>
                            <input type="text" value="请再次输入密码" id="id44" title="请再次输入密码" onclick="c(id,title)" onblur="c1(id,title)">
                        </dd>
                    </dl>
                    <button style="position: absolute;top: 470px;left:20px ;width: 440px;height: 50px;background: #BDCEFC;color: #fff;border-radius: 25px;cursor: pointer;border-style: none;">立即注册</button>

                </form>
            </div>
        </div>

    </div>
    <script src="js/loginAndRegister.js" onload=""></script>
</body>
</html>