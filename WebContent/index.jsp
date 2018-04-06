<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jamescss.css">
<link rel="stylesheet" href="css/white.css">
</head>

<body>
 <!-- 页面框 -->
    <div class="containers">
      <!-- 导航栏 -->
      <div class="navinformation navbar-fixed-top">
        <!-- 左按钮 点击可以隐藏下面的个人信息 复击可弹出 -->
        <span class="glyphicon glyphicon-menu-hamburger navbutton" aria-hidden="true"></span>
        <div class="navname">
          <span>我的博客</span>
        </div>
        <div class="navsearch">
          <form action="" class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" size="70" placeholder="搜索我的文章">
              <span class="gosearch">
                <button class="searchbtn" type="button">搜索</button>

              </span>
            </div>
          </form>
        </div>
        <div class="navleft">
          <span class="navlogin" id="login">
          登陆
          </span>
          <span class="navnamecut">|</span>
          <span class="navregin" id="regist">
          注册
          </span>
        </div>

      </div>
      <!-- 左边导航栏 -->
      <div class="leftnavinfo">
        <a href="#">
          <div class="homepage">
            <div class="homeinfocss">
              <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
              <span class="homepagecss">发现文章</span>
            </div>

          </div>
        </a>
        <a href="#">
          <div class="personalinfo">
            <div class="personalinfocss">
              <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
              <span class="homepagecss">了解我们</span>
            </div>

          </div>
        </a>
      </div>
        <%-- 中间瀑布流布局 --%>

        <div class="waterfall">
          <div class="logininfo">
            <span>登陆后能干什么?</span>
          </div>
          <section id="gallery-wrapper">
            <article class="white-panel">
               <img src="img/图2.jpg" class="thumb">
              <h1><a href="#">修改自己的账号信息</a></h1>
              <p></p>
            </article>
            <article class="white-panel">
              <img src="img/图5.png" class="thumb">
              <h1><a href="#">评论和点赞文章</a></h1>
              <p></p>
            </article>
            <article class="white-panel">
              <img src="img/图6.jpg" class="thumb">
              <h1><a href="#">写属于自己的文章</a></h1>
              <p></p>
            </article>
          </section>
        </div>
    <!-- 弹窗用户登陆 -->
    <form class="" action="${pageContext.request.contextPath }/login" method="post">
      <div class="hide-center">
        <div id="formhead">
          <div id="formhead-title">
            用户登陆
          </div>
          <button type="button" id="close">X</button>
        </div>
        <div id="formbody">
          <div class="loginUserName">
            用户名:<input id="input-topright-loginInput" name="username" class="loginInput" placeholder="请输入账号" type="text">
          </div>
          <div class="loginPassword">
            密码:<input id="input-bottomright-loginInput" name="password" class="loginInput" placeholder="请输入密码" type="password" style="border-bottom-right-radius:5px;">
          </div>
          <div id="formfoot">
            <button id="BSignIn" type="submit">登陆</button> 
          </div>
        </div>
      </div>
    </form>
    <!-- 用户注册  用户名 密码 重复密码 性别 邮箱 验证码-->
    <%
	String codes = (String)session.getAttribute("code");
	%>
    <form class="" action="${pageContext.request.contextPath }/register" method="post">
      <div class="registered">
        <div class="registered-entirety">
          <div class="registered-title">
            用户注册
          </div>
          <button type="button" id="regclose">X</button>
          <div class="registered-bottom">
            <div class="registered-username">
              用户名:<input type="text" size="28" name="username" placeholder="请输入用户名">
            </div>
            <div class="registered-password">
              密码:<input type="password" id="passjudge" size="28" name="password" placeholder="请输入密码">
            </div>
            <div class="registered-repassword">
              确认密码:<input type="password" id="repassjudge" size="28" name="repassword" placeholder="请再次输入密码">
            </div>
            <div class="registered-sex">
              性别: <input type="radio" name="sex" value="男">男
              <input type="radio" name="sex" value="女">女
            </div>
            <div class="registered-email">
              邮箱: <input type="email" size="28" name="email" placeholder="请输入邮箱">
            </div>
            <div class="registered-code">
              验证码：<input type="text" size="10" id="regcode" name="code" />
              <img src="/Graduation/code" id="codeimg" onclick="changeCode()" />
              <a href="javascript:changeCode()">换一张</a>
            </div>
            <div class="registered-submit" >
              <button class="registered-s" type="submit">注册</button>
            </div>
          </div>
        </div>
      </div>
    </form>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script  type="text/javascript" src="js/pinterest_grid.js"></script>
  <script type="text/javascript" src="js/leftjsinfo.js"></script>
  <script type="text/javascript">
  $("#regcode").blur(function() {
    var regcode = $("#regcode").val();
    var reggcodes ='<%=codes %>';
    if(regcode.toLowerCase() != reggcodes.toLowerCase()){
		alert("验证码输入错误");
    }
  });
  $(function() {
    $("#gallery-wrapper").pinterest_grid({
      no_columns: 4,
      padding_x: 10,
      padding_y: 10,
      margin_bottom: 50,
      single_column_breakpoint: 700
    });
  });
  </script>
</html> 