<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 2018/5/2
  Time: 下午9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    .img{
        margin-left: 700px;
        margin-top: 200px;
    }
    .img img{
        width: 400px;
        height: 250px;
    }
    .art{
        margin-left: 100px;
    }
</style>
<body>
    <div class="img">
        <img src="img/succ.jpg">
        <div class="art">
            <p> 发表成功!三秒后将返回个人主页 </p>
            <p> <a href="selectAllAriticle.action">如果三秒后没返回 请点我</a></p>
        </div>
    </div>
</body>
    <script type="text/javascript">
        window.setTimeout("window.location='selectAllAriticle.action?id=${person_id}'",3000);
    </script>
</html>
