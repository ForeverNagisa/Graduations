<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的首页</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jamescss.css">
</head>
<body>
<!-- 页面框 -->
    <div class="containers">
      <!-- 导航栏 -->
      <div class="navinformation navbar-fixed-top">
        <!-- 左按钮 点击可以隐藏下面的个人信息 复击可弹出 -->
        <span class="glyphicon glyphicon-menu-hamburger navbutton" aria-hidden="true"></span>
        <div class="navname">
          <span><a href="#">James P.D</span></a> <span class="navnamecut">|</span> <span>我的博客</span>
        </div>
        <div class="navsearch">
          <form action="" class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" size="70" placeholder="搜索我的文章">
            </div>
          </form>
        </div>

      </div>
      <!-- 左边导航栏 -->
      <div class="leftnavinfo">
        <a href="#">
          <div class="homepage">
            <div class="homeinfocss">
              <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
              <span class="homepagecss">我的首页</span>
            </div>

          </div>
        </a>
        <a href="#">
          <div class="personalinfo">
            <div class="personalinfocss">
              <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
              <span class="homepagecss">我的资料</span>
            </div>

          </div>
        </a>
        <a href="#">
          <div class="personarticle">
            <div class="personarticlecss">
              <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
              <span class="homepagecss">我的文章</span>
            </div>

          </div>
        </a>
        <a href="#">
          <div class="personimg">
            <div class="personimgcss">
              <span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
              <span class="homepagecss">我的图片</span>
            </div>
          </div> 
        </a>
      </div>

    </div>


  </body>
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="js/leftjsinfo.js"></script>

</html>
