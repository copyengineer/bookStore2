var a = document.getElementById("f1");//登陆按钮
var b = document.getElementById("f2");//注册按钮
var a1 = document.getElementsByClassName("tab1");//登陆界面
var b1 = document.getElementsByClassName("tab2");//注册界面
var login = $(".tab1").children("p");//登陆界面提示信息
var register = $(".tab2").children("p");//注册界面提示信息




//点击登陆时触发
a.onclick = function(){
    a.style.background = "#E0ECF8";
    a1[0].style.background = "#E0ECF8";
    a1[0].style.display = "block";
    b1[0].style.display = "none";
    b.style.background = "none";
}
//点击注册时触发
b.onclick = function(){
    b.style.background = "#E0ECF8";
    a.style.background = "none";
    a1[0].style.display = "none";
    b1[0].style.display = "block";
    b1[0].style.background = "#E0ECF8";
    b1[0].style.opacity="1.0";
}



function c(id,title){
   	var a = document.getElementById(id);
    if(a.value==title){
       a.value="";
    }
}

function c1(id,value){
    var a = document.getElementById(id);
    if(a.value==""){
       a.value=value;
    }
}

function c3(id,value){
    var a = document.getElementById(id);
    if(a.value==""){
       a.value=value;
    }else{//不为空才发送Ajax请求来验证用户名是否已经存在
    	$.ajax({
       url: "/bookStore_spring/login_register",
       data: "value="+a.value+"&type=register"+"&action=cheackUserName",
       dataType:"json",
       type: "POST",
       success: function (result) {
       		register.text(result.isExist);
       }              
    })
    }   
}

//切换验证码

$("#codeImg").click(function(){
	this.src = "kaptcha.jpg?t=" + new Date();
})


