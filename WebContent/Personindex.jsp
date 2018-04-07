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
				<span><a href="#">${username.username }</span></a> <span
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
				<span class="Headimg"> <img src="img/heand.jpg"
					class="img-circle">
				</span><span class="navnamecut">|</span><a href="${pageContext.request.contextPath }/cancellation"> <span> 注销登陆 </span></a>
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

		<%-- 右下角编辑文章图标 --%>
		<div class="editor-article" id="article">
			<div class="circular-button" >
				<span class="glyphicon glyphicon-pencil pencilcss"></span>
			</div>
		</div>

	</div>

	<%-- 修该个人信息 --%>
	<form class=""
		action="${pageContext.request.contextPath }/alterPerson?id=${username.username }"
		method="post">
		<div class="registered">
			<div class="registered-entirety">
				<div class="registered-title">修改您的个人信息</div>
				<button type="button" id="regclose">X</button>
				<div class="registered-bottom">
					<div class="registered-username">
						用户名:<input type="text" size="28" name="username"
							value="${username.username }">
					</div>
					<div class="registered-password">
						密码:<input type="password" id="passjudge" size="28" name="password"
							value="${username.password }">
					</div>
					<div class="registered-repassword">
						确认密码:<input type="password" id="repassjudge" size="28"
							name="repassword" value="${username.password }">
					</div>
					<div class="registered-sex">
						性别: <input type="radio" name="sex" value="男">男 <input
							type="radio" name="sex" value="女">女
					</div>
					<div class="registered-submit">
						<button class="registered-s" type="submit">修改</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<%-- 编写文章弹窗 --%>
	<form class="" action="" method="post">
		<div class="article-page">
			<div class="article-pagebody">
				<div class="registered-title">编辑属于你的文章</div>
				<button type="button" id="article-close">X</button>
				<div class="article-bottom">
					<div class="article-username">
						文章标题:<input type="text" size="28" name="article">
					</div>
					<div class="article-body">
						<textarea placeholder="在这里输入你的文章内容" name="name" rows="8" cols="60"></textarea>
					</div>
					<div class="upload-picture">
						<span class="glyphicon glyphicon-picture"></span>
					</div>
					<div class="article-submit">
						<input class="article-s" disabled="true" value="发表" type="submit">
					</div>
				</div>
			</div>
		</div>
	</form>


</body>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/pinterest_grid.js"></script>
<script type="text/javascript" src="js/leftjsinfo.js"></script>
<script type="text/javascript">
	$(function() {
		$("#gallery-wrapper").pinterest_grid({
			no_columns : 4,
			padding_x : 10,
			padding_y : 10,
			margin_bottom : 50,
			single_column_breakpoint : 700
		});
	});
</script>

</html>
