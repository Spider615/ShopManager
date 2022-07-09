<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <title>登录注册页面</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div class="materialContainer">
        <div class="box">
            <div class="title">登录</div>
            <div class="input">
                <label for="name">用户名</label>
                <input type="text" name="name" id="name">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="pass">密码</label>
                <input type="password" name="pass" id="pass">
                <span class="spin"></span>
            </div>
            <div class="button login">
                <button id="refresh">
                    <span>登录</span>
                    <i class="fa fa-check"></i>
                </button>
            </div>
 			 <label id="loading"></label> 
            <a href="javascript:" class="pass-forgot">忘记密码？</a>
        </div>

        <div class="overbox">
            <div class="material-button alt-2">
                <span class="shape"></span>
            </div>
            <div class="title">注册</div>
            <div class="input">
                <label for="regname">用户名</label>
                <input type="text" name="regname" id="regname">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="regpass">密码</label>
                <input type="password" name="regpass" id="regpass">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="reregpass">确认密码</label>
                <input type="password" name="reregpass" id="reregpass">
                <span class="spin"></span>
            </div>
            <div class="button">
                <button id="register">
                    <span>注册</span>
                </button>
            </div>
        </div>

    </div>
    <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="js/index.js"></script>
    <script type="text/javascript">
		$("#refresh").click(function(){
			var uname=$('#name').val();
			var upwd=$('#pass').val();
			$('#loading').html("<img src='image/ajax-loader.gif'>正在加载中。。。请稍后！");
			$.post('LoginServlet',{uname:uname,upwd:upwd},function(res)
					{
						if(res=='success')
							{
							alert("登录成功");
							window.location.href="home.jsp?uname="+uname;
							}
						else
							{
								alert("登录失败");
								location.href='index.jsp';
							}
						
					},"text")
		});
		$("#register").click(function(){
			var uname=$('#regname').val();
			var upwd=$('#regpass').val();
			var reregpass=$('#reregpass').val();
			$.post('RegisterServlet',{uname:uname,upwd:upwd,reregpass:reregpass},function(res)
					{
						if(res=='success')
							{
							alert("注册成功");
							}
						else if(res=='false1')
							{
								alert("注册失败");
							}
						else
							{
								alert("两次密码不一致，请重新输入");
							}
						location.href='index.jsp';
					},"text")
		});
	</script>
</body>

</html>