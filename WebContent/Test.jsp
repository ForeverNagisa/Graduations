<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 2018/5/3
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jamescss.css">
<link rel="stylesheet" href="css/white.css">
<body>

<div class="waterfall">
    <section id="gallery-wrapper">

    </section>
</div>


</body>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/leftjsinfo.js"></script>
<script type="text/javascript" src="js/pinterest_grid.js"></script>
<script type="text/javascript">
    $(function() {
        $("#gallery-wrapper").pinterest_grid({
            no_columns : 2,
            padding_x : 30,
            padding_y : 30,
            margin_bottom : 50,
            single_column_breakpoint : 400
        });
    });




</script>
</html>
