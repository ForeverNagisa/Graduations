<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的首页</title>
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
        <span class="glyphicon glyphicon-menu-hamburger navbutton"
              aria-hidden="true"></span>
        <div class="navname">
            <span ><a href="#" >${persons.username }</a></span>

            <span
                    class="navnamecut">|</span> <span>我的博客</span>
        </div>
        <div class="navsearch">
            <form action="" class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" size="70"
                           placeholder="搜索我的文章"> <span class="gosearch">
							<button class="searchbtn" type="button">搜索</button>
						</span>
                </div>
            </form>
        </div>
        <div class="navleft">
				<span class="Headimg" title="点击更换头像" id="upheandimg">
					<c:if test="${!empty imgpath}">
						<img src="upimg/${imgpath}"
                             class="img-circle">
                    </c:if>
					<c:if test="${empty imgpath}">
						<img src="upimg/${empty persons.headimg ? "default.png" : persons.headimg }"
                             class="img-circle">
                    </c:if>

				</span><span class="navnamecut">|</span><a href="logonlogon.action"> <span> 注销登陆 </span></a>
        </div>
    </div>
    <!-- 左边导航栏 -->
    <div class="leftnavinfo">
        <a href="Personindex.jsp">
            <div class="homepage">
                <div class="homeinfocss">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    <span class="homepagecss">我的首页</span>
                </div>

            </div>
        </a> <a href="#">
        <div class="personalinfo" id="myinfo">
            <div class="personalinfocss">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <span class="homepagecss">我的资料</span>
            </div>

        </div>
    </a> <a href="#">
        <div class="personarticle">
            <div class="personarticlecss">
                <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                <span class="homepagecss">我的文章</span>
            </div>

        </div>
    </a> <a href="#">
        <div class="personimg">
            <div class="personimgcss">
                <span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
                <span class="homepagecss">我的图片</span>
            </div>
        </div>
    </a>
    </div>
    <%-- 中间文章区域--%>

   <div class="arts_content">
       <div class="arts_title">
           <h1>${article.art_title}</h1>
           <span>${article.art_time}   作者:${article.art_person_name}</span>
       </div>

       <div class="art_contex">
           <p>${article.art_content}</p>
           <c:if test="${!empty article.art_img}">
               <img src="upimg/${article.art_img }" class="th">
           </c:if>
       </div>

       <hr/>
       <form action="pushArticleComment.action" method="post">
           <input value="${article.art_id}" name="article_id" style="display: none">
           <input value="${persons.id}" name="person_id" style="display: none">
           <input value="${persons.username}" name="person_name" style="display: none">
           <h3 class="comm_info">发表评论</h3>
           <div class="commet">
               <span class="comm_name">${persons.username }:</span>
               <textarea rows="5" cols="100" name="comm_name"></textarea>
               <input type="submit" value="发布">
           </div>
       </form>

       <div class="commts_css">
       <c:forEach items="${comments}" var="comments">
           <div class="">
               <span>${comments.person_name}:</span>
               <span>${comments.comm_name}</span>
           </div>
       </c:forEach>
       </div>
   </div>




    <%-- 右下角编辑文章图标 --%>
    <div class="editor-article" id="article">
        <div class="circular-button" >
            <span class="glyphicon glyphicon-pencil pencilcss"></span>
        </div>
    </div>

</div>

<%-- 修改个人信息 --%>
<form
        action="updatePersonInfo.action"
        method="post">
    <div class="registered">
        <div class="registered-entirety">
            <div class="registered-title">修改您的个人信息</div>
            <button type="button" id="regclose">X</button>
            <div class="registered-bottom">
                <div class="registered-username">
                    用户名:<input type="text" size="28" name="username" class="person_name"
                               value="${persons.username }">
                    <input type="text" value="${persons.id}" name="id" style="display:none;">
                </div>
                <div class="registered-password">
                    密码:<input type="password" id="passjudge" size="28" name="password"
                              value="${persons.password }">
                </div>
                <div class="registered-repassword">
                    确认密码:<input type="password" id="repassjudge" size="28"
                                name="repassword" value="${persons.password }">
                </div>
                <div class="registered-sex">
                    性别: <input type="radio" name="sex" value="男">男 <input
                        type="radio" name="sex" value="女">女
                </div>
                <div class="registered-submit">
                    <input class="registered-s" type="submit" value="修改" />
                </div>
            </div>
        </div>
    </div>
</form>

<%-- 编写文章弹窗 --%>
<form class="" action="publishingArtice.action" method="post" enctype="multipart/form-data">
    <div class="article-page">
        <div class="article-pagebody">
            <div class="registered-title">编辑属于你的文章</div>
            <button type="button" id="article-close">X</button>
            <div class="article-bottom">
                <div class="article-username">
                    文章标题:<input type="text" size="28" name="art_title">
                </div>
                <div class="article-body">
                    <textarea placeholder="在这里输入你的文章内容" name="art_content" rows="8" cols="60"></textarea>
                </div>
                <div class="upload-picture" title="添加图片">
                    <span class="glyphicon glyphicon-picture"></span>
                    <input type="file" name="art_img">
                    <input type="text" value="${persons.id}" name="person_id" id="person_id" style="display:none;">
                    <input type="text" value="${persons.username}" name="art_person_name" style="display:none;">
                </div>

                <div class="article-submit">
                    <input class="article-s" value="发表" type="submit">
                </div>
            </div>
        </div>
    </div>
</form>

<%-- 更改头像弹窗 --%>
<form class="" action="upPersonimgs.action" method="post" enctype="multipart/form-data">
    <div class="heand-img">
        <div class="heand-body">
            <div class="registered-title">上传属于你的头像</div>
            <button type="button" id="head-close">X</button>
            <div class="heand-bottom">
                <div class="article-username">
                    上传头像:
                    <input type="file" name="file">
                </div>
                <input type="text" value="${persons.id}" name="id" style="display:none;">
                <div class="heand-submit">
                    <input class="heand-s"  value="上传" type="submit">
                </div>
            </div>
        </div>
    </div>
</form>


</body>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/pinterest_grid.js"></script>
<script type="text/javascript" src="js/leftjsinfo.js"></script>






</html>
